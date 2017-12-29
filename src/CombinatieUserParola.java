import fileoperation.FileOperationImpl1;
import fileoperation.FileOperations;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CombinatieUserParola {


    public static void main(String[] args) {

        FileOperations fo = new FileOperationImpl1();

//        String poezie;
//        poezie = fo.readFromFile("fisierParole.txt");

        List<String> poezie;
        poezie = fo.readFromFileAsList("fisierParole.txt");

        Scanner scan = new Scanner(System.in);

        System.out.println("da nume:");
        String nume = scan.nextLine();

        System.out.println("da parola");
        String parola = scan.nextLine();


        Map<String, String> pwdStruct = new HashMap<>();

        String[] parts = {};

        for (String line: poezie ) {
            parts = line.split(", ");
            pwdStruct.put(parts[0],parts[1]);
        }

        System.out.println(pwdStruct);

        for (Map.Entry<String, String> entry : pwdStruct.entrySet()) {
            if (nume.equals(entry.getKey()) && parola.equals(entry.getValue())) {
                // daca intra aici inseama ca userul a introdus in u si p ceva ce exista in fisier

                Runtime rt = Runtime.getRuntime();

                try {
                    rt.exec("notepad");
                } catch (IOException ex) {

                    System.out.println(ex);

                }
            }
        }
    }
}
