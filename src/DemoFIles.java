import fileoperation.FileOperationImpl1;
import fileoperation.FileOperations;

import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class DemoFIles {

    public static void main(String[] args) {

        DemoFIles demo = new DemoFIles();

        FileOperations fo = new FileOperationImpl1();

        List<String> poezie;
        poezie = fo.readFromFileAsList("luc.txt");
        //  System.out.println(poezie.size());

        int counter = 0;
        for (String vers : poezie
                ) {

            if (!(vers.isEmpty()))
                counter++;
        }

        System.out.println(counter);


        int cateStrofe = demo.problema2(poezie);
        System.out.println(cateStrofe);

        demo.problema3(poezie);
       //System.out.println(cateCuvinte);

//        int deCateOriSeRepetaCuv = demo.problema4(poezie);
//        System.out.println(deCateOriSeRepetaCuv);

//        int celMaiLungCuvant = demo.problema7(poezie);
//        System.out.println(celMaiLungCuvant);

    }

    int problema2(List<String> poezie) {
        int counterStrofe = 1;
        for (String strofe : poezie) {
            if (strofe.isEmpty()) {
                counterStrofe++;
            }

            if (strofe.startsWith("...")) {
                counterStrofe--;
            }
        }

        return counterStrofe;
    }

    void problema3(List<String> poezie) {

        String[] words = {};
        HashMap<String, Integer> dictionar = new HashMap<>();
        int unice=0;
        int neunice=0;

        for (String s : poezie) {
            words = s.split(" "); // cuv

            for (String cuvant: words) {
                cuvant.replaceAll("[.,?!';:]", "");
                if (dictionar.containsKey(cuvant)) {
                    dictionar.put(cuvant, dictionar.get(cuvant) + 1);

                } else {
                    dictionar.put(cuvant, 1);
                }
            }

            for(String cuvant : words){
                if(dictionar.get(cuvant) > 1)
                {
                    neunice++;
                } else
                {
                    unice++;
                }
            }
        }
        System.out.println("Cuvinte neunice: "+ neunice);
        System.out.println("Cuvinte unice: " + unice);

    }


    int problema4(List<String> poem) {
        int counter = 0;
        for (String vers : poem
                ) {

            StringTokenizer st = new StringTokenizer(vers);      //iau versul curent ca sa-l impart in cuvinte
            while (st.hasMoreElements()) {
                String cuvant = (String) st.nextElement();
                if (cuvant.contains("stele")) {
                    counter++;
                }
            }
        }
        return counter;
    }
}


//    int problema7(List<String> poezie) {
//
//        String[] a ;
//
//        int longestWord = 0;
//        int position = 0;
//
//        for (String s : poezie) {
//
//            a = s.split(" ");
//
//                if(s.codePointAt(position) > longestWord)
//                { // If strSplit[i].length is greater than the word it is compared with...
//                    //longestWord = strSplit[i].length; // ...then longestWord takes this new value
//
//                    longestWord = a.length;
//                    position++;
//                }
//            }
//
//        return longestWord;
//    }







