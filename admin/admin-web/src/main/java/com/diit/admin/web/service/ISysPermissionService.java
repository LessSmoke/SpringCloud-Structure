package com.diit.admin.web.service;

import com.diit.admin.web.domain.SysPermission;

import java.util.List;

public interface ISysPermissionService {

    public boolean refreshPermRolesRules();

    public List<SysPermission> listPermRoles();
}
