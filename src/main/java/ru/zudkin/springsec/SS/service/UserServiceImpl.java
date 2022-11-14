package ru.zudkin.springsec.SS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zudkin.springsec.SS.DAO.UserDAO;
import ru.zudkin.springsec.SS.model.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }


    @Transactional
    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.save(user);
    }

    @Transactional
    @Override
    public User find(int id) {
        return userDAO.find(id);
    }

    @Transactional
    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Transactional
    @Override
    public void update(int id, User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.update(id, user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

}
