package com.document.dmdemo.serviceImpl;

import com.document.dmdemo.model.UserInfo;
import com.document.dmdemo.repo.UserInfoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserInfoService implements UserDetailsService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User  not found with email: " + email));
        return new org.springframework.security.core.userdetails.User(userInfo.getEmail(), userInfo.getPassword(), 
            new ArrayList<>()); // Add roles if needed
    }
}