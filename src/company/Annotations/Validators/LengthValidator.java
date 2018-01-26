package company.Annotations.Validators;

public class LengthValidator  {

    public static void validate(String s,
                                int min,
                                int max) {

        if (s.length() <= max &&
                s.length() >= min) {
            throw new RuntimeException("Length is not valid. Length does not match");
        }


    }
}


