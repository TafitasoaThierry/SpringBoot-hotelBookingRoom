package com.hotel.service;

import com.hotel.model.Admin;
import com.hotel.repository.AdminRepository;

import jakarta.el.ELException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AdminService {
	final AdminRepository adminRepository;

	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	public Admin addAdmin(Admin newAdmin) {
		return this.adminRepository.save(newAdmin);
	}

	public List<Admin> getAdminList() {
		return this.adminRepository.findAll();
	}

	public String deleteAdmin(String matricule) {
		if(this.adminRepository.findById(matricule).isPresent()) {
			this.adminRepository.deleteById(matricule);
			return "admin deleted";
		}else {
			return matricule.toString() + " isn't in admin list";
		}
	}

	public Admin updateAdmin(String matricule, Admin newAdminInfo) {
		if(this.adminRepository.findById(matricule).isPresent()) {
			Admin adminInfo = this.adminRepository.findById(matricule).get();
			return this.adminRepository.save(adminInfo);
		}else {
			throw new ELException(matricule.toString() + " isn't in admin list");
		}
	}
}
