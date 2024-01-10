package com.SmsPollar.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SmsPollar.Dto.RequestSmsDto;
import com.SmsPollar.entity.RequestSms;
import com.SmsPollar.services.SmsPollarServies;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/sms")
@Log4j2
public class SmsPollarController {

    @Value("${sms.service.url}")
    private String smsServiceUrl;

    @Autowired
    private SmsPollarServies smsPollarServies;


    @GetMapping("/getsms")
    public ResponseEntity<List<RequestSmsDto>> getSms() {
        log.info("[SmsPollarController][getSms]  SmsPollar getting Started");
        List<RequestSmsDto> smsList = smsPollarServies.getSms();

        return new ResponseEntity<>(smsList, HttpStatus.OK);
    }


    @GetMapping("/connect-URL")
    public ResponseEntity<String> connectToURL() {
        log.info("[SmsPollarController][connectToURL] Connected to URL");
        return new ResponseEntity<>("Connected to URL", HttpStatus.OK);
    }


    @GetMapping("/")
    public String welcome() {
        log.info("Sms Pollar Working");
        return "Sms Pollar Working";
    }


    @PostMapping("/create")
    public RequestSms createOneRecord(@RequestBody RequestSms requestSms) {
        log.info("[SmsPollarController][createOneRecord]  New Record Created " + requestSms);
        return smsPollarServies.createRecord(requestSms);
    }


}
