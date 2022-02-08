package perscholas.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NotNull
@Size(min = 5, max = 14, message = "Username must be between 5 & 14 characters")
@Getter
@Setter
public class LoginBean {
//place LoginBean into the LoginSubmit method to get and set the username and password inputs
    //    THIS METHOD OF GETTING AND SETTING PARAMETER INPUTS CAN REPLACE >> (HttpServletRequest request, @RequestParam String username, @RequestParam String password)
    //@RequestParam is the best way for simpler parameter where there are only a few to get.
    //using a form bean is better for more complicated variable amounts
    private String username;
    private String password;

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
