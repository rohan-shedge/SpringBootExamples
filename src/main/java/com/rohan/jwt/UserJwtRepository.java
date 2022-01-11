package com.rohan.jwt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJwtRepository extends JpaRepository<UserModel, Long> {
    //username , it will return the user of given username
    public UserModel findByUsername(String username);
}
