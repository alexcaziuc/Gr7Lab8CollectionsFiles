/*
9. se da un fisier text de forma
ionel, password1
maria, password2
crina, password3

cerinta este sa se poata lansa notepad.exe doar daca userul introduce o combinatie user/parola dintre cele de mai sus
se poate folosi un Map/HashMap
de ex pt gasit in map se poate folosi un cod ca si acesta
String u , p ; // user si parola citite de la tastatura
Map<String,String> pwdStruct = new HashMap<String,String>();
/// aici punem din fisier in map
//apoi cand cautam facem cam asa
 for (Map.Entry<String, String> entry : pwdStruct.entrySet()) {
                if(u.equals(entry.getKey()) && p.equals(entry.getValue())) {
                // daca intra aici inseama ca userul a introdus in u si p ceva ce exista in fisier
}
 */

import fileoperation.FileOperationImpl1;

import java.io.IOException;
import java.util.*;

public class UserPassMatch {
    public static void main(String[] args) {
        List<String> myFile = new FileOperationImpl1().readFromFileAsList("fisierParole.txt");

        UserPassMatch obj = new UserPassMatch();
        Map<String, String> loginInFile = obj.createLogInFile(myFile);

        obj.launchNotepad(loginInFile);
    }

    private String input(String label) {
        Scanner in = new Scanner(System.in);
        System.out.print(label);

        String inputFromUser = in.nextLine();
        while (inputFromUser.equals("")) {
            System.out.print(label);
            inputFromUser = in.nextLine();
        }
        return inputFromUser;
    }

    private Map<String, String> createLogInFile(List<String> myFile) {
        Map<String, String> loginInFile = new HashMap<>();

        for (String s : myFile) {
            s = s.replaceAll(",", "");
            String[] column = s.split(" ", 2);
            String user = column[0];
            String password = column[1];
            loginInFile.put(user, password);
        }
        return loginInFile;
    }
    
    private boolean logInCheck(Map<String, String> map) {
        boolean loggedIn = false;

        String user = input("Username: ");
        String password = input("Password: ");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (user.equals(entry.getKey()) && password.equals(entry.getValue())) {
                loggedIn = true;
            }
        }
        return loggedIn;
    }

    private void launchNotepad(Map<String, String> map) {
        boolean loggedIn = logInCheck(map);

        if (loggedIn) {
            Runtime rt = Runtime.getRuntime();

            try {
                rt.exec("notepad");
            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("User or password incorrect!");
        }
    }
}