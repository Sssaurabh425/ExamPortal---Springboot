package com.exam.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //Creating User
    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
        User local = this.userRepository.findByUsername(user.getUsername());
        if(local!=null)
        {
            System.out.println(("User is already there !!"));
            try {
                throw new Exception("User Already Present!!");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else{
            //user create
            //adding all userRoles(list) in database using roleRepository
            for(UserRole ur:userRoles)
            {
                roleRepository.save(ur.getRole());
            }

            //Associating user with all roles
            user.getUserRoles().addAll(userRoles);
            //saving user associated with role in database using userRepository
            local = this.userRepository.save(user);


        }
        return local;
    }


    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }


    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
    
}
