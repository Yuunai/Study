package pl.krystianminta;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Encryptor encryptor = null;

        int n;
        int g;
        List<Integer> list;
        Random random = new Random();

        do{

            n = Encryptor.generateN();

            System.out.println(n);

            list = Encryptor.generatePrimitiveRootsModN(n);

            if(list.size() != 0) {
                g =  list.get(random.nextInt(list.size()));
                encryptor = new Encryptor(n, g);
            }

        }while(encryptor == null);

        encryptor.printResult(97, 233);

    }
}
