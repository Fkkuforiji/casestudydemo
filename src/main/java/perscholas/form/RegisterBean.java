package perscholas.form;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Getter
@Setter
public class RegisterBean {
    @NotEmpty(message = "Email is required.")
    @Pattern(regexp = "^.+@.+$", message = "Invalid email format")
    //^^ requires an @ sign. Changing the input type to "email" in the register
    // jsp also creates this restraint for force include an @ sign
    private String email;

    @Length(min = 3, max = 10, message = "First Name must be between 3 and 10 characters in length!")
    //look up jsr 303 annotation list for more ways to customize error constraints - January 31st - 2:10:00
    private String firstName;
    private String lastName;
    private String password;


    @Min(value = 3, message = "Age cannot be younger than 3")
    @Max(value = 5, message = "Age cannot be older than 5")
    private Integer age;
    private String confirmPassword;

    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
