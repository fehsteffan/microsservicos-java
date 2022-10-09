package com.program.payroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents.UriTemplateVariables;

import com.program.payroll.entities.Payment;
import com.program.payroll.entities.Worker;

@Service
public class PaymentService  {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVarables = new HashMap<>();
		uriVarables.put("id", ""+workerId);		
		
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVarables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
			
		
	}

}
