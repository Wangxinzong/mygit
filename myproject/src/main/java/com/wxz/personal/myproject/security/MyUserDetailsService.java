package com.wxz.personal.myproject.security;

import com.wxz.personal.myproject.controller.LoginUser;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //模拟数据库数据
        LoginUser loginUser = new LoginUser();
        if(!s.equals(loginUser.getUsername())){
            throw new UsernameNotFoundException("用户不存在");
        }
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("admin"));
        return new User(loginUser.getUsername(),loginUser.getPassword(),list);
    }
}
