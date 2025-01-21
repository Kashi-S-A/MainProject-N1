package com.ty.cp.dto;

import com.ty.cp.enums.ClassMode;
import com.ty.cp.enums.Course;
import com.ty.cp.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnquiryDto {

	private String name;

	private Long phone;

	private ClassMode classMode;

	private Status status;

	private Course course;

}
