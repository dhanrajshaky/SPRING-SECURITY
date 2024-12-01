package com.example.securityapp.db.repo;

import com.example.securityapp.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.DocFlavor;
import javax.print.attribute.IntegerSyntax;
import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {


    Optional<UserEntity> findByEmail(String email);
}
