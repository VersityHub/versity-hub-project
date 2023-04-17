package com.java.tech.versityHub.Repository;

import com.java.tech.versityHub.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
