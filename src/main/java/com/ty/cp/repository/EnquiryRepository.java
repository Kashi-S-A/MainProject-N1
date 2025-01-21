package com.ty.cp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.cp.entity.Enquiry;
import com.ty.cp.enums.Course;
import com.ty.cp.enums.Status;

public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{

	Optional<Enquiry> findByPhone(Long phone);

	List<Enquiry> findByCourse(Course course);

	List<Enquiry> findByStatus(Status status);

}
