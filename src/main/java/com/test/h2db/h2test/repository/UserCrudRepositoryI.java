package com.test.h2db.h2test.repository;

import com.test.h2db.h2test.model.UserDto;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepositoryI extends CrudRepository<UserDto, Long> {

}
