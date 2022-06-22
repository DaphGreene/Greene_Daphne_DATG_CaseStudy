package com.repository;

import com.entity.User;

public interface UserAccountRepository {

    public User findByUsername(String username);

}
