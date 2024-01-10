package com.SmsPollar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "my_sms")
@Data

public class RequestSms {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
    @Column(name = "Mobile_Number")
	private Long mobileNumber;
    
    @Column(name = "Message")
	private String message;
	
    @Column(name = "Status")
	private String status;
    
//    @Column(name = "StatusFlag")
//    private Status statusFlag;
//
//    
    
    
	@Override
	public String toString() {
		return "RequestSms [id=" + id + ", mobileNumber=" + mobileNumber + ", Message=" + message + ", status="
				+ status + "]";
	}
    

	
	
	
	
	

}
