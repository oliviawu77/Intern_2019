package jbr.springmvc.dao;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public interface UserDao {

  void register(User user);
  void update(User user);
  void delete(User user);
  
  User validateUser(Login login);
}
