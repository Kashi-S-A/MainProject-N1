package com.ty.cp.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.cp.dto.CounsellorRequest;
import com.ty.cp.dto.CounsellorResponse;
import com.ty.cp.dto.LoginDTO;
import com.ty.cp.entity.Counsellor;
import com.ty.cp.exception.CounsellorNotFound;
import com.ty.cp.exception.DuplicateEmailException;
import com.ty.cp.repository.CounsellorRepository;

@Service
public class CounsellorServiceImpl implements CounsellorService {

	@Autowired
	private CounsellorRepository counsellorRepository;

	@Override
	public boolean register(CounsellorRequest counsellorRequest) {

		Optional<Counsellor> byEmail = counsellorRepository.findByEmail(counsellorRequest.getEmail());

		if (byEmail.isPresent()) {
			throw new DuplicateEmailException("Email Already Registered");
		} else {

			Counsellor counsellor = new Counsellor();

			BeanUtils.copyProperties(counsellorRequest, counsellor);

			return counsellorRepository.save(counsellor) != null;
		}
	}

	@Override
	public boolean login(LoginDTO loginDTO) {
		Counsellor counsellor = counsellorRepository.findByEmail(loginDTO.getEmail())
				.orElseThrow(() -> new CounsellorNotFound("Counsellor Not Registered"));

		if (counsellor.getPassword().equals(loginDTO.getPassword()))
			return true;
		return false;
	}

	@Override
	public CounsellorResponse updateCounsellor(Integer cid, CounsellorRequest counsellorRequest) {
		Counsellor counsellor = counsellorRepository.findById(cid)
				.orElseThrow(() -> new CounsellorNotFound("Counsellor Is Not Registered"));

		if (counsellorRequest.getEmail() != null)
			counsellor.setEmail(counsellorRequest.getEmail());
		if (counsellorRequest.getName() != null)
			counsellor.setName(counsellorRequest.getName());
		if (counsellorRequest.getPhone() != null)
			counsellor.setPhone(counsellorRequest.getPhone());
		if (counsellorRequest.getPassword() != null)
			counsellor.setPassword(counsellorRequest.getPassword());

		Counsellor save = counsellorRepository.save(counsellor);

		CounsellorResponse counsellorResponse = new CounsellorResponse();

		BeanUtils.copyProperties(save, counsellorResponse);

		return counsellorResponse;
	}

	@Override
	public String deleteCounsellor(Integer cid) {
		Counsellor counsellor = counsellorRepository.findById(cid)
				.orElseThrow(() -> new CounsellorNotFound("Counsellor Is Not Registered"));
		counsellorRepository.delete(counsellor);
		return "Deleted";
	}
}
