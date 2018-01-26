package company;

import company.Annotations.DisplayName;
import company.Annotations.Validators.Email;
import company.Annotations.Validators.Length;
import company.Annotations.Validators.NotBlank;
import company.Annotations.Validators.EmailValidator;
import company.Annotations.Validators.LengthValidator;
import company.Annotations.Validators.NotBlankValidators;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main {
    private static final String FILE_NAME = "C:\\Users\\Uglevi\\IdeaProjects\\HW_44_Annotations\\DB\\Users.txt";

    public static void main(String[] args) throws Exception {
        ArrayList<User> userList = new ArrayList<>();
        do {
                userList.add(inputUser());
           } while (!isExit());
        serialize(userList);
    }


    private static void serialize(ArrayList<User> userList) throws Exception {
        FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(userList);
        out.close();
        fileOut.close();


    }

    private static boolean isExit() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();
        if (answer.equalsIgnoreCase("exit")) {
            return true;
        }
        return false;
    }

    private static User inputUser() throws IOException, IllegalAccessException {
              User user = new User();
              Field[] userField = User.class.getDeclaredFields();
            for (Field field : userField) {
                field.setAccessible(true);
                System.out.println("Input please " + getFieldName(field));
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String answer = reader.readLine();
                if (field.isAnnotationPresent(NotBlank.class)) {
                    notBlankProcessing(field, user);
                }
                if (field.isAnnotationPresent(Email.class)){
                    EmailProcessing(field, user);
                }
                if (field.isAnnotationPresent(Length.class)){
                    lengthProcessing(field, user);
                }
                field.set(user, answer);

               }
   //
        //     validator(user);
                 return user;
}

    private static void notBlankProcessing(Field field, Object user) throws IllegalAccessException {
        if (field.getAnnotation(NotBlank.class) != null) {
              Object o = field.get(user);
            NotBlankValidators.validate((String) o);
        }
    }

    private static void lengthProcessing(Field field,  Object user) throws IllegalAccessException {
        boolean annotationPresent = field.isAnnotationPresent(Length.class);

        if (annotationPresent) {
            Length length = field.getAnnotation(Length.class);
           Object o = field.get(user);
            LengthValidator.validate((String) o, length.minLength(), length.maxLength());
        }
    }
    private static void EmailProcessing(Field field, User user) throws IllegalAccessException {
        boolean annotationPresent = field.isAnnotationPresent(Email.class);
        if (annotationPresent){
            Email email = field.getAnnotation(Email.class);
            Object o = field.get(user);
            EmailValidator.validate(user.getEmail());

        }
    }


    private static Object getFieldName(Field field) {
        boolean annotationPresent = field
                .isAnnotationPresent(DisplayName.class);
        if (annotationPresent) {
            DisplayName annotation = field
                    .getAnnotation(DisplayName.class);
            return annotation.printValue();
        }
        return field.getName();
    }

}

