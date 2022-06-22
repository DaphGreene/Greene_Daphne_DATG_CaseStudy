package com.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.entity.UserInfo;
import com.entity.UserRoleToPrivilege;
import com.entity.UserToRole;
import com.repository.UserAccountRepository;
import com.security.CustomUserDetails;

@Component
public class DatabaseUserDetailsService implements UserDetailsService {

    private final
    UserAccountRepository userAccountRepository;

    public DatabaseUserDetailsService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userAccount = userAccountRepository.findByUsername(username);
        if (userAccount == null) {
            throw new UsernameNotFoundException("User with username [" + username + "] not found in the system");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();

        for (UserToRole userToRole : userAccount.getUserToRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userToRole.getRole().getRoleName()));
            for (UserRoleToPrivilege userRoleToPrivilege : userToRole.getRole().getUserRoleToPrivileges()) {
                authorities.add(new SimpleGrantedAuthority(userRoleToPrivilege.getPrivilege().getPrivilegeName()));
            }
        }

       return new CustomUserDetails(userAccount.getUsername(), userAccount.getPassword(), userAccount.isActive(), authorities);
    }
}
