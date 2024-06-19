package com.diit.auth.security.details.user;

import com.diit.auth.common.enums.PasswordEncoderTypeEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service("SysUSerDetailsServiceImpl")
@Slf4j
@RequiredArgsConstructor
public class SysUserDetailsServiceImpl implements UserDetailsService {

    /**
     * 获取用户信息方法
     * @param username
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // todo 后面需要修改成从管理端获取用户信息
        SysUserDetails userDetails = loadUser(username);
        if(!userDetails.isEnabled()){
            throw new DisabledException("该用户已被禁用！");
        }else if(!userDetails.isAccountNonExpired()){
            throw new AccountExpiredException("该账户已经过期！");
        }else if(!userDetails.isAccountNonLocked()){
            throw new LockedException("该账户已被锁定！");
        }
        return userDetails;
    }

    /**
     * 这个地方是在没有后台管理端的时候，用来代替管理端提供信息的方法
     * @param username
     * @return
     */
    private SysUserDetails loadUser(String username){
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("admin"));
        return SysUserDetails.builder()
                .userId(1L)
                .enabled(true)
                .authorities(authorities)
                .password(PasswordEncoderTypeEnum.BCRYPT.getPrefix() + new BCryptPasswordEncoder().encode("123456")).build();
    }
}
