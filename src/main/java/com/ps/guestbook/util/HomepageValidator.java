package com.ps.guestbook.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("com.ps.guestbook.util.HomepageValidator")
public class HomepageValidator implements Validator {

    private static final String URL_PATTERN = "(http://)?(www\\.)?[A-Za-z0-9]+\\.[a-z]{2,3}";

    private Pattern pattern;
    private Matcher matcher;

    public HomepageValidator() {
        pattern = Pattern.compile(URL_PATTERN);
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (!(o.toString().isEmpty() || o.toString() == null)){
            matcher = pattern.matcher(o.toString());
            if(!matcher.matches()){
                FacesMessage msg =  new FacesMessage("Homepage: Invalid homepage format", "Homepage validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }
}
