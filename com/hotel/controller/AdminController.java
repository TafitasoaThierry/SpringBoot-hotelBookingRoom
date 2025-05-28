package com.hotel.controller;

import java.util.List;

import com.hotel.model.Admin;
import com.hotel.service.AdminService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
@CrossOrigin()
public class AdminController {
	final AdminService adminService;

	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	/*
	 * use Admin service
	 */
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin newAdmin) {
		return ResponseEntity.ok(this.adminService.addAdmin(newAdmin));
	}

	@GetMapping("/getAdminList")
	public ResponseEntity<List<Admin>> getadminList() {
		return ResponseEntity.ok(this.adminService.getAdminList());
	}

	@DeleteMapping("/deleteAdmin/{matricule}")
	public ResponseEntity<String> deleteAdmin(@PathVariable String matricule) {
		return ResponseEntity.ok(this.adminService.deleteAdmin(matricule));
	}

	@PutMapping("/updateAdmin/{matricule}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable String matricule, @RequestBody Admin newAdminInfo) {
		return ResponseEntity.ok(this.adminService.updateAdmin(matricule, newAdminInfo));
	}
}
