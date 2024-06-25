package com.diit.admin.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.diit.admin.web.domain.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    List<SysPermission> listPermRoles();
}
