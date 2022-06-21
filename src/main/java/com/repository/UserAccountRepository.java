package com.repository;

import com.entity.UserInfo;

public interface UserAccountRepository {

    public UserInfo findByUsername(String username);

}
