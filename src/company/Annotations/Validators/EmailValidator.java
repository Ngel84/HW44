package company.Annotations.Validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    public static void validate(String email){

        Pattern p = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");
        Matcher m = p.matcher(email);
        if (!m.find()){
            throw new RuntimeException("E-mail wrong");
                    }
    }
}