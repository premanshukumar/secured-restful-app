package com.kgpco.secure.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Contact {
	private String name;
	private String url;
	private String email;
}
