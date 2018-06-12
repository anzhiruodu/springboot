package com.lishenming.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetaisService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * AuthorityUtils.commaSeparatedStringToAuthorityList("admin")将逗号隔开的字符串转为一个集合的
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查找用户信息
        logger.info("用户登录："+username);
        return new User(username,"123", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
