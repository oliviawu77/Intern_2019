package jbr.springmvc.controller;

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
public class UserEditController {
  @Autowired
  public UserService userService;

  @RequestMapping(value = "/edit", method = RequestMethod.GET)
  public ModelAndView showUpdate(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("userEdit");
    mav.addObject("user", new User());

    return mav;
  }

  @RequestMapping(value = "/UserEditProcess", method = RequestMethod.POST)
  public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("user") User user, @ModelAttribute("login") Login login) {
	  
	  	userService.update(user);

	  	return new ModelAndView("login");
  }
}