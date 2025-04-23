package com.hotel.controller;

import java.util.List;
import java.util.Optional;

import com.hotel.model.Admin;
import com.hotel.service.AdminService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel/admin")
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
    public ResponseEntity<List<Admin>> getAdminList() {
        return ResponseEntity.ok(this.adminService.getAdminList());
    }

    @GetMapping("/getAdminById/{id}")
    public ResponseEntity<Optional<Admin>> getAdminById(@PathVariable String id) {
        return ResponseEntity.ok(this.adminService.getAdminById(id));
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable String id) {
        return ResponseEntity.ok(this.adminService.deleteAdmin(id));
    }

    @PutMapping("/updateAdmin/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable String id, @RequestBody Admin newAdminInfo) {
        return ResponseEntity.ok(this.adminService.updateAdmin(id, newAdminInfo));
    }
}
