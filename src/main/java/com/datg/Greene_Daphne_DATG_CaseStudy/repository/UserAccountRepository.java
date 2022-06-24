package com.datg.Greene_Daphne_DATG_CaseStudy.repository;

import com.datg.Greene_Daphne_DATG_CaseStudy.entity.User;

public interface UserAccountRepository {

    public User findByUsername(String username);

}
