package jbr.springmvc.service;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.model.Employee;

public interface UserService {

  void register(User user);
  void update(User user);
  void delete(User user);
  void updateEmployee(Employee employee);

  User validateUser(Login login);
}
