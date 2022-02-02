package perscholas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
//the C in MVC
public class IndexController {
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    /* the / and /index are the assigned link names for the web pages that we can view by including in our local
    host url. ex. localhost:8080/ or localhost:8080/index*/
    public ModelAndView index(HttpServletRequest request, HttpSession session) throws Exception {
        //What is HTTPServlet request?
        //HttpSession tells the browser to create a unique session for the user
        //index is the String View name for the jsp file that will be viewed.
        //ModelAndView is not mapped to a string
        ModelAndView response = new ModelAndView();
        response.setViewName("index");
Object username = session.getAttribute("username");
//gets the objects string input and creates an object of username in the current unique session and stores
        System.out.println("Trying to get user from session and got " + username);
        //this prints in the console, not on the webpage, sort of testing to see if we get the outcome we need

      /*  Cookie[] cookies = request.getCookies();

        if(cookies !=null) {
            for(int i = 0; i < cookies.length; i++) {
                String name = cookies[i].getName();
                String value = cookies[i].getValue();
                System.out.println("Cookie : " + name + " = " +value);
            }
        }
        This prints the session ID for the current session*/

        return response;
    }
    @RequestMapping(value = "/indexSubmit", method = RequestMethod.GET)
    public ModelAndView indexSubmit(HttpServletRequest request, HttpSession session) throws Exception {
/*/indexSubmit value is the url View name and is the methodID that connects the index.jsp page, to the indexSubmit jsp
the Yellow indexSubmit can be anything
Model is an object that stores values that need to be sent to the jsp file. Store in strings.
HttpSession "session" sets a session variable name for the user in a current use session, where the functions done
in a session are committed to memory for that specific session. Once the session is closed,
the memory is session. step 1: put HttpSession session in*/

       String username = request.getParameter("username");
       //This string username is coming from the Username named "username" in the Index.jsp file
        String firstName = request.getParameter("firstName");
        //This string username is coming from the First Name named "firstName" in the Index.jsp file
        String email = request.getParameter("email");
        String birthdate = request.getParameter("birthdate");
        System.out.println("username = " + username);
        //This prints out the input received in the username form on the webpage.
        //before we had sout("username = " + request.getParameter("username);
        //String username is defined as username from index, and used in the print out statement
        System.out.println("First Name = " + firstName);
        System.out.println("Email = " + email);
        System.out.println("birthdate = " + birthdate);

        session.setAttribute("username", username);
        /*sets the string input of username and saves the objects input as the username object
        in the session. Like a getter and setter, but it's not a constructor*/
        ModelAndView response = new ModelAndView();
        response.addObject("username",username);
        response.addObject("firstName",firstName);
        response.addObject("email", email);
        response.addObject("birthdate", birthdate);
        /*response is the String name for the model object variable, this can be named anything. addObject adds a specific object
        from the object defined in index and makes it available to render in the indexSubmit page.
        now, the username and firstname inputted into the form, are available to display
        on indexSubmit page*/
        response.setViewName("indexSubmit");
        //this response view routes to a viewing a webpage named indexSubmit, rather than the index.
        //for this to route to indexSubmit, a jsp file must be created.

        return response;
    }

}
