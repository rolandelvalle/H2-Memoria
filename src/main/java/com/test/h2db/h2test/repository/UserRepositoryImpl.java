package com.test.h2db.h2test.repository;

import com.test.h2db.h2test.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryDaoI{

    @Autowired
    private UserCrudRepositoryI userCrudRepositoryI;

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userFounded = new ArrayList<>();
        userCrudRepositoryI.findAll().forEach(user -> userFounded.add(user));
        return userFounded;
    }

    @Override
    public UserDto findUserById(Long idUser) {
        return userCrudRepositoryI.findById(idUser).get();
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return userCrudRepositoryI.save(userDto);
    }

    @Override
    public boolean updateUser(Long idUser, UserDto userDto) {
        UserDto userFound = findUserById(idUser);
        if(userFound != null){
            userFound.setName(userDto.getName());
            userFound.setLastName(userDto.getLastName());
            userFound.setAge(userDto.getAge());
            userFound.setEmail(userDto.getEmail());
            userFound.setDateBirth(userDto.getDateBirth());
            userCrudRepositoryI.save(userFound);

            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteUser(Long idUser) {
        UserDto userFound = findUserById(idUser);
        if(userFound != null){
            userCrudRepositoryI.delete(userFound);
            return true;
        }else{
            return false;
        }
    }
}
