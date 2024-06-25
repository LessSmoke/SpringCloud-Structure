package com.diit.admin.web.domain;

import lombok.Data;

import java.util.List;

/**
 * @author yjxbz
 */
@Data
public class SysPermission {

    private String id;

    private String userId;

    private String urlPerm;

    private List<String> roles;
}
