package com.ty.cp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.cp.dto.EnquiryDto;
import com.ty.cp.entity.Enquiry;
import com.ty.cp.enums.ClassMode;
import com.ty.cp.enums.Course;
import com.ty.cp.enums.Status;
import com.ty.cp.service.EnquiryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;

	@PostMapping("/add")
	public ResponseEntity<String> addEnquiry(@RequestParam Integer cid, @RequestBody Enquiry enquiry) {
		boolean added = enquiryService.addEnquiry(cid, enquiry);
		if (added)
			return new ResponseEntity<String>("added", HttpStatus.CREATED);
		return new ResponseEntity<String>("already added", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/phone/{eid}/{phone}")
	public ResponseEntity<EnquiryDto> updatePhone(@PathVariable Integer eid, @PathVariable Long phone) {
		EnquiryDto updatePhone = enquiryService.updatePhone(eid, phone);
		return ResponseEntity.ok(updatePhone);
	}

	@PutMapping("/course/{eid}/{course}")
	public ResponseEntity<EnquiryDto> updateCourse(@PathVariable Integer eid, @PathVariable Course course) {
		EnquiryDto updatecourse = enquiryService.updateCourse(eid, course);
		return ResponseEntity.ok(updatecourse);
	}

	@PutMapping("/classMode/{eid}/{classMode}")
	public ResponseEntity<EnquiryDto> updateCourse(@PathVariable Integer eid, @PathVariable ClassMode classMode) {
		EnquiryDto updateClassMode = enquiryService.updateClassMode(eid, classMode);
		return ResponseEntity.ok(updateClassMode);
	}

	@PutMapping("/status/{eid}/{status}")
	public ResponseEntity<EnquiryDto> updateCourse(@PathVariable Integer eid, @PathVariable Status status) {
		EnquiryDto updateStatus = enquiryService.updateStatus(eid, status);
		return ResponseEntity.ok(updateStatus);
	}

	@GetMapping("/course")
	public ResponseEntity<List<Enquiry>> getByCourse(@RequestParam Course course) {

		List<Enquiry> enquiries = enquiryService.getByCourse(course);

		return ResponseEntity.ok(enquiries);
	}

	@GetMapping("/status")
	public ResponseEntity<List<Enquiry>> getByStatus(@RequestParam Status status) {

		List<Enquiry> enquiries = enquiryService.getByStatus(status);

		return ResponseEntity.ok(enquiries);
	}

	@DeleteMapping("/delete/{eid}")
	public ResponseEntity<String> deleteEnquiry(@PathVariable Integer eid) {
		String deleted = enquiryService.deleteById(eid);
		return ResponseEntity.ok(deleted);
	}

}
