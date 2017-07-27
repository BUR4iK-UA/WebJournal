package net.bur4ik.WebJournal.service;

import net.bur4ik.WebJournal.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public boolean authorization(String login, String pass) {
        return userDao.authorization(login, pass);
    }
}
