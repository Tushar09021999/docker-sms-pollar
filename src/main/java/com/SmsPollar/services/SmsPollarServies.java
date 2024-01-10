package com.SmsPollar.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.SmsPollar.Dto.RequestSmsDto;
import com.SmsPollar.entity.RequestSms;
import com.SmsPollar.exception.ResourceNotFoundException;
import com.SmsPollar.respository.SmsPollarRepository;

import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class SmsPollarServies {

	@Autowired
	private SmsPollarRepository smsPollarRepository;

	@Autowired
	private UpdateSmsData updateSms;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.url.properties}")
	String baseUrl;

	public List<RequestSmsDto> getSms() {

		log.debug("[SMSPoller][getSms]Inside getSms Method in SmsPoller");

		List<RequestSmsDto> responseList = new ArrayList<RequestSmsDto>();

		List<RequestSms> byStatus = smsPollarRepository.getAllByStatus("O");
		log.debug("[SMSPoller][getSms] Getting records with status 'O' ");

		for (RequestSms sms : byStatus) {
			log.debug("[SMSPoller][getSms]Found Data for SMS");

			RequestSms smsDetails = new RequestSms();

			if (sms.getStatus().equalsIgnoreCase("O")) {

				smsDetails.setId(sms.getId());
				smsDetails.setMobileNumber(sms.getMobileNumber());
				smsDetails.setMessage(sms.getMessage());
				smsDetails.setStatus(sms.getStatus());

				log.debug("[SMSPoller][getSms] ID is -" + sms.getId() + "mobileNo is -" + sms.getMobileNumber()
						+ "Message is -" + sms.getMessage() + "Status is -" + sms.getStatus());

				int responseCode = 0;
				
				String url = UriComponentsBuilder.fromUriString(baseUrl)
						.queryParam("mobileNumber",sms.getMobileNumber())
						.queryParam("message",sms.getMessage()).build().toString();
				
				try {
					ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
					responseCode = responseEntity.getStatusCodeValue();
					log.debug("[HTTP Error] - [Response Code]-" + responseCode);

					System.out.println("responseCode ->" + responseCode);

				} catch (HttpStatusCodeException e) {
					responseCode = e.getRawStatusCode();
					log.warn("[HTTP Error] - [Response Code]-" + responseCode);
				}

				RequestSmsDto updateSmsResponse = updateSms.updateSmsResponse(responseCode, sms.getId(),
						smsDetails.getMobileNumber(), smsDetails.getMessage());

				log.debug("[SmsPollarServies][getSms] UpdateSms process completed");

				responseList.add(updateSmsResponse);
				log.debug("[SmsPollarServies][getSms] Set response process completed");

			} else {

				log.debug("[SmsPollarServies][getSms][ResourceNotFoundException] Resource with status 'O' Not Found");
				throw new ResourceNotFoundException("Resource with status 'O' Not Found");

			}

		}
		return responseList;

	}

	public RequestSms createRecord(RequestSms requestSms) {

		return smsPollarRepository.save(requestSms);
	}

}
