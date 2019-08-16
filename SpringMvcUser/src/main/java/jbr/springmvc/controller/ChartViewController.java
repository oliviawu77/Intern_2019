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

import jbr.springmvc.model.Employee;
import jbr.springmvc.model.EmployeeList;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;

@Controller
public class ChartViewController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/chart", method = RequestMethod.GET)
  public ModelAndView showUsers(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("viewChart");
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:jbr/config/user-beans.xml");
    UserDaoImpl userDao = (UserDaoImpl) context.getBean("userDao");    
    mav.addObject("employeelist", userDao.getEmployeeList());
    mav.addObject("Avg_Employee", userDao.AvgSteps_Employee());
    mav.addObject("Avg_Boss", userDao.AvgSteps_Boss());
    mav.addObject("Avg_NoShift", userDao.AvgSteps_Noshifts());
    mav.addObject("Avg_Shift", userDao.AvgSteps_shifts());
    return mav;
  }
  
  @RequestMapping(value = "/viewUser", method = RequestMethod.GET)
  public ModelAndView showUserChart(HttpServletRequest request, HttpServletResponse response) {
	    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:jbr/config/user-beans.xml");
	    UserDaoImpl userDao = (UserDaoImpl) context.getBean("userDao"); 	  
    ModelAndView mav = new ModelAndView("viewUser");
    String ID = request.getParameter("id");
    mav.addObject("employee", userDao.getEmployee(ID));

    Employee emp = userDao.getEmployeeInformation(ID);
    mav.addObject("ID", emp.getId());
    mav.addObject("Job_grade", emp.getJob_grade());
    mav.addObject("Job_position", emp.getJob_position());
    mav.addObject("Work_shift", emp.getWork_shift());

    return mav;
  }  

}
