package com.service;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import com.entity.UserInfo;
import com.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserInfo> getUsers() {
        return userRepository.findAllByActiveOrderByIdDesc(true);
    }
    //    @Override
    public void addUser(UserInfo userInfo) {

        userRepository.save(userInfo);
    }


    public UserInfo getUser(Integer id) throws ChangeSetPersister.NotFoundException {
        return userRepository.findByIdAndActive(id, true).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    //    @Override
    public UserInfo updateUser(Integer id, UserInfo request) throws ChangeSetPersister.NotFoundException {
        UserInfo userFromDb = getUser(id);
        userFromDb.setUsername(request.getUsername());
        userFromDb.setDescription(request.getDescription());
        userFromDb.setActive(request.isActive());
        return userRepository.save(userFromDb);
    }



}
