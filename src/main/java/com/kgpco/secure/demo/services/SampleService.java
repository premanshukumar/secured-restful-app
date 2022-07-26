package com.kgpco.secure.demo.services;

import org.springframework.stereotype.Service;

import com.kgpco.secure.demo.dto.Contact;

@Service
public class SampleService {
	public static Contact DEFAULT_CONTACT = new Contact("Web-app Team", "http://kgpco.com",
			"premanshu.kumar@kgpco.com");

	public Contact printDetails() {
		return DEFAULT_CONTACT;
	}
}
