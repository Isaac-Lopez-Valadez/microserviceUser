package com.sysComp.microserviceUser.web.contoller;

import com.sysComp.microserviceUser.domain.UserDto;
import com.sysComp.microserviceUser.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/all")
    public ResponseEntity<?> getActiveUsers () {
        return ResponseEntity.ok(userService.getActiveUsers());
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable String username) {
        return  ResponseEntity.ok(userService.getUserByUserName(username));
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int userID) {
        userService.deleteUser(userID);
        return ResponseEntity.noContent().build();
    }

}
