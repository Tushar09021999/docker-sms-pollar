package com.SmsPollar.schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class SmsScheduler {

	@Autowired
	private SmsInvoke smsInvoke;

	@Scheduled(fixedRate = 1000)
	public void start() {
		log.info("start method get called");
		smsInvoke.invokeGetSms();

	}

}
