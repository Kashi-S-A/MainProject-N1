package com.ty.cp.service;

import java.util.List;

import com.ty.cp.dto.EnquiryDto;
import com.ty.cp.entity.Enquiry;
import com.ty.cp.enums.ClassMode;
import com.ty.cp.enums.Course;
import com.ty.cp.enums.Status;

public interface EnquiryService {

	boolean addEnquiry(Integer cid, Enquiry enquiry);

	EnquiryDto updatePhone(Integer eid, Long phone);

	EnquiryDto updateCourse(Integer eid, Course course);

	EnquiryDto updateClassMode(Integer eid, ClassMode classMode);

	EnquiryDto updateStatus(Integer eid, Status status);

	List<Enquiry> getByCourse(Course course);

	List<Enquiry> getByStatus(Status status);

	String deleteById(Integer eid);

}
