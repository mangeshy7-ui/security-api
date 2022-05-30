package com.usd.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usd.security.entity.UserManagement;
import com.usd.security.service.IUserManagementService;

@RestController
@RequestMapping("/usermanage")
public class UserManagementController {

	@Autowired
	private IUserManagementService userManagementservice;

	@PostMapping("/save")
	public ResponseEntity<String> saveUserManagement(@RequestBody UserManagement usermanage) {

		Integer id = userManagementservice.saveUserManagement(usermanage);

		return new ResponseEntity<String>("Usermanage '" + id + "'saved", HttpStatus.OK);

	}

	@GetMapping("/all")
	public ResponseEntity<List<UserManagement>> getAllUserManagement() {
		List<UserManagement> list = userManagementservice.getAllUserManagement();
		return new ResponseEntity<List<UserManagement>>(list, HttpStatus.OK);
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<UserManagement> getOneUserManagement(@PathVariable Integer id) {

		UserManagement unm = userManagementservice.getOneUserManagement(id);
		return new ResponseEntity<UserManagement>(unm, HttpStatus.OK);
	}

	/*
	 * @DeleteMapping("/delete/{id}") public ResponseEntity<String>
	 * UserManagement(@PathVariable Integer id){
	 * 
	 * 
	 * userManagementservice.deleteUserManagement(id);
	 * 
	 * return new
	 * ResponseEntity<String>("UserManagement '"+id+"' deleted",HttpStatus.OK);
	 * 
	 * }
	 */

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<UserManagement>> UserManagement(@PathVariable Integer id) {

		userManagementservice.deleteUserManagement(id);
		List<UserManagement> all=userManagementservice.getAllUserManagement();

		return new ResponseEntity<List<UserManagement>>(all, HttpStatus.OK);

	}

	@PutMapping("/modify/{id}")
	public ResponseEntity<String> updateUserManagement(@PathVariable Integer id, @RequestBody UserManagement umng) {

		UserManagement umngdb = userManagementservice.getOneUserManagement(id);
		umngdb.setCreatedON(umng.getCreatedON());
		umngdb.setDescription(umng.getDescription());
		umngdb.setEmailId(umng.getEmailId());
		umngdb.setFirstName(umng.getFirstName());
		umngdb.setLastName(umng.getLastName());
		umngdb.setKyc(umng.getKyc());
		umngdb.setPhoneNumber(umng.getPhoneNumber());
		umngdb.setPurchaseServicePlan(umng.getPurchaseServicePlan());
		umngdb.setRoles(umng.getRoles());
		userManagementservice.saveUserManagement(umngdb);
		return new ResponseEntity<String>("UserManagement '" + id + "' updated", HttpStatus.OK);
	}

}
