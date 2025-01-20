package com.ty.cp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CounsellorRequest {

	private String name;

	private String email;

	private String password;

	private Long phone;
}
