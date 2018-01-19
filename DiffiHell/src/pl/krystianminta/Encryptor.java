package pl.krystianminta;

import java.math.BigInteger;
import java.util.*;

public class Encryptor {

    private int g;
    private int n;

    Encryptor(int n, int g) {
        this.g = g;
        this.n = n;
    }

    public void printResult(int first, int second) {
        BigInteger firstPublicKey = BigInteger.valueOf(g).modPow(BigInteger.valueOf(first), BigInteger.valueOf(n));
        System.out.println("Klucz publiczny nr1: " + firstPublicKey);

        BigInteger secondPublicKey = BigInteger.valueOf(g).modPow(BigInteger.valueOf(second), BigInteger.valueOf(n));
        System.out.println("Klucz publiczny nr2: " + secondPublicKey);

        BigInteger firstSharedKey = secondPublicKey.modPow(BigInteger.valueOf(first), BigInteger.valueOf(n));
        System.out.println("Klucz współdzielony nr1: " + firstSharedKey);

        BigInteger secondSharedKey = firstPublicKey.modPow(BigInteger.valueOf(second), BigInteger.valueOf(n));
        System.out.println("Klucz współdzielony nr2: " + secondSharedKey);
    }

    public static int generateN() {
        int generatedN;
        Random random = new Random();
        do{
            generatedN = random.nextInt(250);
        }while(!isPrime(generatedN) || !isPrime((generatedN-1)/2));

        return generatedN;
    }

    private static boolean isPrime(int number) {

        if(number < 3) {
            return false;
        }

        for(int i = 2; i < number/2; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRelativelyPrime(int first, int second) {

        if(first == second) {
            return false;
        }

        int smaller;
        if(first<second) {
            smaller = first;
        } else {
            smaller = second;
        }

        for(int i=2; i<=smaller; i++) {
            if(first % i == 0 && second % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static List<Integer> generatePrimitiveRootsModN(int n) {

        List<Integer> relativelyPrimeNumbers = new ArrayList<>();
        List<Integer> resultNumbers = new ArrayList<>();
        int tempNumber;
        boolean tempBool;
        for(int i=1; i<n; i++) {
            if(isRelativelyPrime(i, n)) {
                relativelyPrimeNumbers.add(i);
            }
        }

        Map<Integer, Boolean> foundCheck = new HashMap<>();


        for(int i=1; i<n; i++) {

            for(Integer integer : relativelyPrimeNumbers) {
                foundCheck.put(integer, false);
            }

            tempBool = true;

            for(int j=1; j<n*2; j++) {
                tempNumber = BigInteger.valueOf(i).modPow(BigInteger.valueOf(j), BigInteger.valueOf(n)).intValue();
                if(relativelyPrimeNumbers.contains(tempNumber)) {
                    foundCheck.put(tempNumber, true);
                }
            }

            for(boolean bool : foundCheck.values()) {
                if(!bool) {
                    tempBool = false;
                }
            }

            if(tempBool) {
                resultNumbers.add(i);
            }

        }



        return resultNumbers;
    }

}
