package com.ty.cp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.cp.dto.CounsellorRequest;
import com.ty.cp.dto.CounsellorResponse;
import com.ty.cp.dto.LoginDTO;
import com.ty.cp.service.CounsellorService;

@RestController
@RequestMapping("/counsellor")
public class CounsellorController {

	@Autowired
	private CounsellorService counsellorService;

	/*
	 * used to register the counsellor
	 * 
	 * @param : takes CounsellorRequest and checks for registration, if already
	 * registered then throw excp,else register
	 */
	@PostMapping("/register")
	public ResponseEntity<String> registerCounsellor(@RequestBody CounsellorRequest counsellorRequest) {
		boolean register = counsellorService.register(counsellorRequest);
		if (register) {
			return new ResponseEntity<String>("Registered Successfully", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Registration is failed", HttpStatus.BAD_REQUEST);
	}

	/*
	 * 
	*/
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO dto) {
		boolean login = counsellorService.login(dto);
		if (login)
			return ResponseEntity.ok("Logged In Successfully");
		else
			return ResponseEntity.badRequest().body("Invalid Credentials");

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CounsellorResponse> updateCounsellor(@PathVariable Integer id,
			@RequestBody CounsellorRequest counsellorRequest) {
		CounsellorResponse updateCounsellor = counsellorService.updateCounsellor(id, counsellorRequest);
		return ResponseEntity.ok(updateCounsellor);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCounsellor(@PathVariable Integer id) {
		String deleteCounsellor = counsellorService.deleteCounsellor(id);
		return ResponseEntity.ok(deleteCounsellor);
	}

//	@GetMapping("/get/{cid}")
//	public ResponseEntity<CounsellorResponse> fetchCounsellorById(@PathVariable Integer cid) {
//		// TODO: logic to fetch counsellor by id
//		return ResponseEntity.ok(counsellorResponse);
//	}

//	@GetMapping("/all")
//	public ResponseEntity<List<CounsellorResponse>> getEnquiriesById(@RequestParam Integer cid) {
//		// TODO: logic to fetch all enquiries by counsellor id
//		return ResponseEntity.ok(counsellors);
//	}

}
