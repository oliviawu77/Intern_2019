package jbr.springmvc.service;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;




public interface UserService {

  void register(User user);
  void update(User user);
  void delete(User user);  

  User validateUser(Login login);
}
