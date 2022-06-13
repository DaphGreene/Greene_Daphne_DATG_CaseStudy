package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.UserInfo;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo,Long> {

    List<UserInfo> findAllByActiveOrderByIdDesc(boolean active);

    Optional<UserInfo> findByIdAndActive(Integer id, boolean active);
}
