package com.alfian.latihanspring.controllers;

import java.util.List;

import com.alfian.latihanspring.models.dto.LoginDto;
import com.alfian.latihanspring.models.dto.MahasiswaDto;
import com.alfian.latihanspring.models.dto.StatusMessageDto;
import com.alfian.latihanspring.models.entity.DetailUser;
import com.alfian.latihanspring.models.entity.User;
import com.alfian.latihanspring.repository.DetailUserRepository;
import com.alfian.latihanspring.repository.UserRepository;
import com.alfian.latihanspring.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DetailUserRepository detailUserRepository;
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> regist(@RequestBody MahasiswaDto mahasiswaDto) {
        StatusMessageDto<User> result = new StatusMessageDto<>();
        try {
            return userService.regist(mahasiswaDto);
        } catch (Exception e) {
            // TODO: handle exception
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        if (loginDto.getUsername().equals(userRepository.findUsernameByUsername(loginDto.getUsername()))) {
            return ResponseEntity.badRequest().body("username telah ada.");
        }

        // String username = userRepository.findUsernameByUsername(dto.getUsername());
        return ResponseEntity.ok("berhasil");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, @RequestBody MahasiswaDto mahasiswaDto) {
        StatusMessageDto<User> result = new StatusMessageDto<>();

        try {
            return userService.edit(id, mahasiswaDto);
        } catch (Exception e) {
            // TODO: handle exception
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        List<User> user = userRepository.findAll();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get-detail/{id}")
    public ResponseEntity<?> getDetail(@PathVariable Integer id) {
        User user = userRepository.findById(id).get();
        DetailUser detailUser = detailUserRepository.findById(user.getId() + 1).get();

        return ResponseEntity.ok(detailUser);
    }
}
