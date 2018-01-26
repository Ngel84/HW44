package company.Annotations.Validators;

public class NotBlankValidators {

    public static void validate(String s){
        if (s==null || s.isEmpty() || s.contains(" ")) {
            throw new RuntimeException("The field is not filled");
        }
    }

}
