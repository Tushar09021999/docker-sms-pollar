
package com.SmsPollar.respository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SmsPollar.entity.RequestSms;

@Repository
public interface SmsPollarRepository extends JpaRepository<RequestSms, Long> {
	
	RequestSms findByStatus(String Status);
	
	List<RequestSms> getAllByStatus(String Status);


}
