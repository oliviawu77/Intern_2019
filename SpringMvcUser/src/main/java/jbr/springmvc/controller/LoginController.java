package jbr.springmvc.controller;

import jbr.springmvc.dao.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;

@Controller
public class LoginController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Login());

    return mav;
  }

  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("login") Login login) {
    ModelAndView mav = null;

    User user = userService.validateUser(login);
   
    if (null != user) {
      ApplicationContext context = new ClassPathXmlApplicationContext("classpath:jbr/config/user-beans.xml");
      UserDaoImpl userDao = (UserDaoImpl) context.getBean("userDao");
      
      mav = new ModelAndView("welcome");
      mav.addObject("name", user.getName());
      String sex = user.getSex();
      if(sex.equals("male")) {
    	  mav.addObject("sex_msg", "Mr. ");
      }
      else if(sex.equals("female")) {
    	  mav.addObject("sex_msg", "Ms. ");
      }
      mav.addObject("userlist", userDao.getUserList());
    } else {
      mav = new ModelAndView("login");
      mav.addObject("message", "Error!");
    }
    return mav;
  }

}
