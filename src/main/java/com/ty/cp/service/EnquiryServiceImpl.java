package com.ty.cp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.cp.dto.EnquiryDto;
import com.ty.cp.entity.Counsellor;
import com.ty.cp.entity.Enquiry;
import com.ty.cp.enums.ClassMode;
import com.ty.cp.enums.Course;
import com.ty.cp.enums.Status;
import com.ty.cp.exception.CounsellorNotFound;
import com.ty.cp.exception.EnquiryNotFound;
import com.ty.cp.repository.CounsellorRepository;
import com.ty.cp.repository.EnquiryRepository;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private EnquiryRepository enquiryRepository;

	@Autowired
	private CounsellorRepository counsellorRepository;

	@Override
	public boolean addEnquiry(Integer cid, Enquiry enquiry) {
		Counsellor counsellor = counsellorRepository.findById(cid)
				.orElseThrow(() -> new CounsellorNotFound("Counsellor is not registered"));
		Optional<Enquiry> opt = enquiryRepository.findByPhone(enquiry.getPhone());

		if (opt.isPresent())
			return false;
		enquiry.setCounsellor(counsellor);
		enquiryRepository.save(enquiry);
		return true;
	}

	@Override
	public EnquiryDto updatePhone(Integer eid, Long phone) {
		Enquiry enquiry = enquiryRepository.findById(eid)
				.orElseThrow(() -> new EnquiryNotFound("Enquiry is not found"));
		enquiry.setPhone(phone);
		Enquiry save = enquiryRepository.save(enquiry);

		EnquiryDto dto = new EnquiryDto();

		BeanUtils.copyProperties(save, dto);

		return dto;
	}

	@Override
	public EnquiryDto updateCourse(Integer eid, Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnquiryDto updateClassMode(Integer eid, ClassMode classMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnquiryDto updateStatus(Integer eid, Status status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enquiry> getByCourse(Course course) {
		return enquiryRepository.findByCourse(course);
	}

	@Override
	public List<Enquiry> getByStatus(Status status) {
		return enquiryRepository.findByStatus(status);
	}

	@Override
	public String deleteById(Integer eid) {
		Enquiry enq = enquiryRepository.findById(eid).orElseThrow(()->new EnquiryNotFound("Enquiry Not FOund"));
		enquiryRepository.delete(enq);
		return "Deleted";
	}
}
