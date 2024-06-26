package com.diit.admin.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.diit.admin.starter.dto.UserAuthDTO;
import com.diit.admin.web.domain.SysPermission;
import com.diit.admin.web.domain.SysUser;

public interface ISysUserService extends IService<SysUser> {

    UserAuthDTO getByUsername(String username);
}
