package com.ps.guestbook.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("com.ps.guestbook.validator.TextValidator")
public class TextValidator implements Validator {

    private static final String HTML_PATTERN = "^(?!<[^>]*>).*$";

    private Pattern pattern;
    private Matcher matcher;

    public TextValidator() {
        pattern = Pattern.compile(HTML_PATTERN);
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        matcher = pattern.matcher(o.toString());

        if(!matcher.matches()){
            FacesMessage msg =  new FacesMessage("Text: Invalid Text format", "Invalid Text format");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
