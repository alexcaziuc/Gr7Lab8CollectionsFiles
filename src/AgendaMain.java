import fileoperation.FileOperationImpl1;
import fileoperation.FileOperations;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class AgendaMain {

    FileOperations fo = new FileOperationImpl1();

    List<Person> agenda = new ArrayList<>();

    private void listAll() {
        for (Person p: agenda
             ) {

            System.out.println(p.getName());
            System.out.println(p.getPhone());
            System.out.println("------------");

        }
    }

    private void add(String name, String phone) {

        Person p = new Person();
        p.setName(name);
        p.setPhone(phone);

        agenda.add(p);

    }

    private void remove(int index) {


        agenda.remove(index);

    }


    private String find(String name) {

        String number = "0";
        for (Person p: agenda
                ) {

            if(p.getName().equalsIgnoreCase(name)) {
                number = p.getPhone();
            }
        }

        return number;
    }


    private void salveaza(List<String> listaAgenda)
    {

        fo.writeFile("agenda.txt", listaAgenda);


    }

    private void salveazaFaraLista(String content)
    {

        fo.writeFile("altaagenda.txt", content);
    }


    public static void main(String[] args) {

        AgendaMain am = new AgendaMain();
        am.listAll();

        am.add("ionel", "547566435765");
        am.add("alina", "68678658");

        List<String> listOfStrings = new ArrayList<>();

        listOfStrings.add(0, "ionel, 655656565");
        listOfStrings.add(1, "gigel, 4454545454");
        listOfStrings.add(2,"costel, 4274957843574395");
        listOfStrings.add(3,"mihai, 312321312");


        am.salveaza(listOfStrings);

        am.salveazaFaraLista("ionel, 6555343242");

        String telefon = am.find("alina");

        System.out.println("tel:"+telefon);


//        am.listAll();
//
//        am.remove(1);
//
//        am.listAll();


    }
}
