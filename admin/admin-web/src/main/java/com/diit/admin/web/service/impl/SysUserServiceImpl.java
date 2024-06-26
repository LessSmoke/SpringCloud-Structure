package com.diit.admin.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.diit.admin.starter.dto.UserAuthDTO;
import com.diit.admin.web.domain.SysUser;
import com.diit.admin.web.mapper.SysUserMapper;
import com.diit.admin.web.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Override
    public UserAuthDTO getByUsername(String username) {
        return null;
    }
}
