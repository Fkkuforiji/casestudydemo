package perscholas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//normally this code would go into the logincontroller but it is in a separate file for learning purposes
@Controller
 class RegistrationController {

 @RequestMapping (value = "/register", method = RequestMethod.GET)
 public ModelAndView register() throws Exception {
  ModelAndView response = new ModelAndView();
  response.setViewName("Registration/register");

 return response;
 }

 @RequestMapping (value = "/registerSubmit", method = RequestMethod.GET)
 public ModelAndView registerSubmit() throws Exception{
  ModelAndView response = new ModelAndView();
  response.setViewName("/Registration/register");
  return response;
 }
}
