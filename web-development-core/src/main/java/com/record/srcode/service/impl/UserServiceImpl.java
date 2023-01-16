package com.record.srcode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.record.srcode.mapper.UserMapper;
import com.record.srcode.po.User;
import com.record.srcode.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author lifez
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2022-08-05 22:07:00
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

}




