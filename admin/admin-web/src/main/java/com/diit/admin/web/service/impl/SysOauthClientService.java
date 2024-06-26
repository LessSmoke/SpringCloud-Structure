package com.diit.admin.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.diit.admin.web.domain.SysOauthClient;
import com.diit.admin.web.mapper.SysOauthClientMapper;
import com.diit.admin.web.service.ISysOauthClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysOauthClientService extends ServiceImpl<SysOauthClientMapper, SysOauthClient> implements ISysOauthClientService {
}
