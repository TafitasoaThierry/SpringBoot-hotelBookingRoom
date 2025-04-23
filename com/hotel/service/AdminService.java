package com.hotel.service;

import com.hotel.model.Admin;
import com.hotel.repository.AdminRepository;

import jakarta.el.ELException;

import java.util.List;
import java.util.Optional;

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

    public Optional<Admin> getAdminById(String id) {
        return this.adminRepository.findById(id);
    }

    public String deleteAdmin(String id) {
        Optional<Admin> adminToDelete = this.adminRepository.findById(id);
        if(adminToDelete.isPresent()) {
            this.adminRepository.deleteById(id);
            return "admin deleted";
        }else {
            return id.toString() + " isn't in admin list";
        }
    }

    public Admin updateAdmin(String id, Admin newAdminInfo) {
        if(this.adminRepository.findById(id).isPresent()) {
            Admin adminInfo = this.adminRepository.findById(id).get();
            adminInfo.setName(newAdminInfo.getName());
            adminInfo.setSurName(newAdminInfo.getSurName());
            adminInfo.setEmail(newAdminInfo.getEmail());
            adminInfo.setPhone(newAdminInfo.getPhone());
            adminInfo.setPassWord(newAdminInfo.getPassWord());
    
            return this.adminRepository.save(adminInfo);
        }else {
            throw new  ELException(id.toString() + " isn't in admin list");
        }
    }

    public String sendMail() {
        return "";
    }
}