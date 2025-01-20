package com.ty.cp.service;

import com.ty.cp.dto.CounsellorRequest;
import com.ty.cp.dto.CounsellorResponse;
import com.ty.cp.dto.LoginDTO;

public interface CounsellorService {

	boolean register(CounsellorRequest counsellorRequest);
	
	boolean login(LoginDTO loginDTO);
	
	CounsellorResponse updateCounsellor(Integer cid,CounsellorRequest counsellorRequest);

	String deleteCounsellor(Integer id);
}
