package company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main2 {
    private static final String FILE_NAME = "C:\\Users\\Uglevi\\IdeaProjects\\HW_44_Annotations\\DB\\Users.txt";

    public static void main(String[] args) throws Exception {

        ArrayList<User> users;
        FileInputStream fileIn = new FileInputStream(FILE_NAME);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        users = (ArrayList<User>) in.readObject();
        System.out.println("Input user name");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String request = reader.readLine();

        for (User user : users) {
            if (request.equalsIgnoreCase(user.getUserName())) {
                System.out.println(user);
                return;
            }
        }
        System.out.println("User not found");
        }


    }
