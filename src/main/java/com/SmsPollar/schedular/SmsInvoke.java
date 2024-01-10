package com.SmsPollar.schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class SmsInvoke {

	@Autowired
	private RestTemplate restTtemplate;

//	@Value("${server.port}")
//	public int port;
//
	public void invokeGetSms() {

		log.info("invokeGetSms get called");
		restTtemplate.getForEntity("http://localhost:8080/sms/getsms", String.class);
	}

}
