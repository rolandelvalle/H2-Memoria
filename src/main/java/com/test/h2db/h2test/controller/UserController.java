package com.test.h2db.h2test.controller;

import com.test.h2db.h2test.model.UserDto;
import com.test.h2db.h2test.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserServiceI userServiceI;

    @Autowired
    public UserController(UserServiceI userServiceI){
        this.userServiceI = userServiceI;
    }

    @GetMapping
    public ResponseEntity <List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(userServiceI.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <UserDto> findUserById(@PathVariable("id") Long idUser){
        return new ResponseEntity<>(userServiceI.findUserById(idUser), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userServiceI.createUser(userDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable("id") Long idUser, @RequestBody UserDto userDto){
        boolean isUpdated = userServiceI.updateUser(idUser, userDto);
        if(isUpdated){
        return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long idUser){
        boolean isDelete = userServiceI.deleteUser(idUser);
        if(isDelete){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
