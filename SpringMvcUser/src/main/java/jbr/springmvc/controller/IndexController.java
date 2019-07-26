package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.service.UserService;

@Controller
public class IndexController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public ModelAndView showHome(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("home");
    return mav;
  }
}
