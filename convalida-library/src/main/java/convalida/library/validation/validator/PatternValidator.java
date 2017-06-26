package convalida.library.validation.validator;

import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import java.util.regex.Pattern;

import convalida.library.validation.Validator;

/**
 * @author Wellington Costa on 21/06/2017.
 */
public class PatternValidator extends AbstractValidator implements Validator {

    private String pattern;

    public PatternValidator(TextInputLayout layout, String errorMessage, String pattern) {
        super(layout, errorMessage);
        this.pattern = pattern;
    }

    public PatternValidator(EditText editText, String errorMessage, String pattern) {
        super(editText, errorMessage);
        this.pattern = pattern;
    }

    @Override
    boolean isNotValid(String value) {
        return !Pattern.matches(pattern, value);
    }

    @Override
    void executeValidation(String value) {
        if (isNotValid(value)) {
            setError();
        } else {
            clearError();
        }
    }

}
