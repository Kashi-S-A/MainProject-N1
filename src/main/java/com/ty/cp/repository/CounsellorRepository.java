package com.ty.cp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.cp.entity.Counsellor;

public interface CounsellorRepository extends JpaRepository<Counsellor, Integer> {

	Optional<Counsellor> findByEmail(String email);
}
