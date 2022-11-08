package com.dk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient 
public class DocPrescDiagApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocPrescDiagApplication.class, args);
	}
	

}
