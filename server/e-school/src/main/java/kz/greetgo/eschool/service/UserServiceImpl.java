package kz.greetgo.eschool.service;

import kz.greetgo.eschool.model.AppUser;
import kz.greetgo.eschool.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private UserMapper userMapper;
    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public AppUser findByUserName(String userName){
        return userMapper.findByUserName(userName);
    }
}
