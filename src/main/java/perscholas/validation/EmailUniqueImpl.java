package perscholas.validation;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//January 31st, Recording 3, 1:19:00, Email Validation
public class EmailUniqueImpl implements ConstraintValidator<EmailUnique, String> {

    public static final Logger LOG = LoggerFactory.getLogger(EmailUniqueImpl.class);

    @Override
    public void initialize(EmailUnique constraintAnnotation) {

    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        /* custom validation should validate 1 and 1 thing only
        since a check for a not null or not empty already occur in the form bean
        we want this function to return true in that case which will prevent the
        error message for this validation from displaying
        when the incoming value is null or empty.
        this is a good design pattern and should be implemented as the first thing in
        all custom validations */
        if (StringUtils.isEmpty(value) ){
            return true;
            //if the email is a@b.com then the email is not unique and the error message with display
        }
        //boolean passes = ! StringUtils.equals(value, "a@b.com" -- if i put passes in the below return statement it means the same thing
        return ( ! StringUtils.equals(value, "a@b.com") );
        //if the email entered is not a@b.com, then the method will pass and we will go to
        //login page
    }
}
