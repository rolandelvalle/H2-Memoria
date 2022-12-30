package com.test.h2db.h2test.service;

import com.test.h2db.h2test.model.UserDto;
import com.test.h2db.h2test.repository.UserRepositoryDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceI{

    @Autowired
    private UserRepositoryDaoI userRepositoryDaoI;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepositoryDaoI.getAllUsers();
    }

    @Override
    public UserDto findUserById(Long idUser) {
        return userRepositoryDaoI.findUserById(idUser);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return userRepositoryDaoI.createUser(userDto);
    }

    @Override
    public boolean updateUser(Long idUser, UserDto userDto) {
        return userRepositoryDaoI.updateUser(idUser, userDto);
    }

    @Override
    public boolean deleteUser(Long idUser) {
        return userRepositoryDaoI.deleteUser(idUser);
    }
}
