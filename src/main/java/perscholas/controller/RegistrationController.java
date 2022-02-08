package perscholas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.form.RegisterBean;

import javax.validation.Valid;

@Controller
//@RequestMapping("registration-url-path") --this will not WORK
public class RegistrationController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/register");

        RegisterBean form = new RegisterBean();
        response.addObject("form", form);

        return response;
    }

    //Register Validation - January 31st lecture - 1:46:42 second recording
    @RequestMapping(value = "/registerSubmit", method = RequestMethod.GET)
    public ModelAndView registerSubmit(@Valid RegisterBean form, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/register");

        System.out.println(form);

        if (errors.hasErrors()) {
            for (FieldError error : errors.getFieldErrors()) {
                System.out.println("error field = " + error.getField() + "message = " + error.getDefaultMessage());
            }
        } else {
                //if there are not errors on the registration form, then the page should redirect to the login page.
                //this is where the new user is saved in user regristration table in the database
                response.addObject("form", form); //--January 31st, 18:04 3rd recording, use ${} to add the objects to the register.jsp
            response.setViewName("redirect:/login");
            }

            return response;
        }
    }


