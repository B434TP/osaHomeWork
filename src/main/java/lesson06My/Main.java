package lesson06My;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String s1 = "Abc";
        String s2 = "Abc";
        String s3 = "abc";
        String s4 = "abC";

        System.out.println(s1 == s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.toUpperCase());
        System.out.println(s3);
        System.out.println(s3.substring(0,1).toUpperCase() + s3.substring(1).toLowerCase());
        System.out.println(s4.startsWith("a"));

        File inFile = new File("src/main/java/lesson06My/in.txt");


        System.out.println(inFile.getAbsolutePath());

//        var is = new BufferedInputStream(new FileInputStream(inFile));
        var is = new String(new FileInputStream(inFile).readAllBytes()).split("\n");

//        int size = is.available();
//        System.out.println(size);
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < size; i++) {
//            sb.append((char) is.read());
//        }
//        System.out.println(sb);
//
        for (int i = 0; i < is.length; i++) {
            System.out.println(is[i]);
        }



        File abIn = new File("src/main/java/lesson06My/ab.txt");
        File cOut = new File("src/main/java/lesson06My/c.txt");

        if (!cOut.exists()) {
            cOut.createNewFile();
        }

        Scanner sc = new Scanner(abIn);
        PrintWriter pw = new PrintWriter(cOut);

        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();

        pw.println(a.add(b));
        pw.close();

        sc.close();
    }
}
