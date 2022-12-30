package com.test.h2db.h2test.repository;

import com.test.h2db.h2test.model.UserDto;

import java.util.List;

public interface UserRepositoryDaoI {
    List<UserDto> getAllUsers();
    UserDto findUserById(Long idUser);
    UserDto createUser(UserDto userDto);
    boolean updateUser(Long idUser, UserDto userDto);
    boolean deleteUser(Long idUser);
}
