package com.boxflux.tool.web.domain.test.service.impl;

import com.boxflux.tool.web.config.cache.BoxCache;
import com.boxflux.tool.web.domain.test.entity.User;
import com.boxflux.tool.web.domain.test.mapper.UserMapper;
import com.boxflux.tool.web.domain.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangguanglin on 2019/6/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @BoxCache
    public User getUser(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
