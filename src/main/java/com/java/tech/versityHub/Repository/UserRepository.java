package com.java.tech.versityHub.Repository;

import com.java.tech.versityHub.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

      UserEntity findByEmailAndPassword(String email, String password);
      Integer getCountByEmail(String email);
//
//    UserEntity findBy(Long ID );
}
