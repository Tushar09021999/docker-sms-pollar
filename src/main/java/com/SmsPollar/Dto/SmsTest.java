//package com.sms.Dto;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//
//public class SmsTest {
//
////	@Autowired
//	private static RestTemplate restTemplate;
//
//	public SmsTest(RestTemplate restTemplate) {
//		this.restTemplate = restTemplate;
//	}
//
////	@Value("${api.url.properties}")
////	String url ;
//	static String url = "http://localhost:8080/sms/connect-URL";
//
//	public static void main(String[] args) {
//
//		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
//		int responseCode = responseEntity.getStatusCodeValue();
//		log.debug("[HTTP Error] - [Response Code]-" + responseCode);
////		
//		System.out.println("responseCode ->" + responseCode);
////
////		RequestSmsDto updateSmsResponse = updateSms.updateSmsResponse(responseCode, sms.getId(),
////				smsDetails.getMobileNumber(), smsDetails.getMessage());
//
//	}
//
//}
package com.SmsPollar.Dto;


