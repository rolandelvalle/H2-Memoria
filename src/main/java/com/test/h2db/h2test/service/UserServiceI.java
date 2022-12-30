package com.test.h2db.h2test.service;

import com.test.h2db.h2test.model.UserDto;

import java.util.List;

public interface UserServiceI {
    List<UserDto> getAllUsers();
    UserDto findUserById(Long idUser);
    UserDto createUser(UserDto userDto);
    boolean updateUser(Long idUser, UserDto userDto);
    boolean deleteUser(Long idUser);
}
