package com.my.springbootintegratemybatis.Service;

import com.my.springbootintegratemybatis.model.User;
import com.my.springbootintegratemybatis.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public int addUser(User user) {
        return this.userRepository.addUser(user);
    }

    @Transactional
    public int addUserWithException(User user) {
        this.throwException();
        return this.userRepository.addUser(user);
    }

    @Transactional
    public int modifyUser(User user) {

        return this.userRepository.updateById(user);
    }

    @Transactional
    public int modifyUserWithException(User user) {
        this.throwException();
        return this.userRepository.updateById(user);
    }

    private void throwException() {
        String a = null;
        a.substring(0, 2);
    }
}
