package com.SmsPollar.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SmsPollar.Dto.RequestSmsDto;
import com.SmsPollar.entity.RequestSms;
import com.SmsPollar.respository.SmsPollarRepository;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class UpdateSmsData {

	@Autowired
	private SmsPollarRepository smsPollarRepository;

	@Transactional
	public RequestSmsDto updateSmsResponse(int responseCode, long id, long mobileNumber, String message) {

		RequestSms smsPollar = smsPollarRepository.findById(id).get();

		RequestSmsDto response = new RequestSmsDto();

		if (responseCode == 200) {
			log.info("[Response Code] is - " +responseCode );
			smsPollar.setStatus("C");
			smsPollar.setMobileNumber(mobileNumber);
			smsPollar.setMessage(message);
			log.debug("[UpdateSmsData][updateSmsResponse] status flag is '200'  status changed  to 'C' ");
			log.debug("[UpdateSmsData][updateSmsResponse] Message send.....! ");

			smsPollarRepository.save(smsPollar);

			response.setMobileNumber(smsPollar.getMobileNumber());
			response.setMessage(smsPollar.getMessage());

		} else {
			log.warn("[Response Code] is - " +responseCode );
			smsPollar.setStatus("F");
			smsPollar.setMobileNumber(mobileNumber);
			smsPollar.setMessage(message);
			log.debug("Message not send........!");
			log.debug("[UpdateSmsData][updateSmsResponse] status flag is not '200' after send message..! status changed  to'F' ");

			smsPollarRepository.save(smsPollar);
			response.setMobileNumber(smsPollar.getMobileNumber());
			response.setMessage(smsPollar.getMessage());

		}
		return response;

	}

}
