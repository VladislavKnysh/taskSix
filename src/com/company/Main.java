package com.company;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        IpFinder ipInString = new IpFinder("5470expression.ESPRESSION REGULAR. \n" +
                "127.0.0.1\n" +
                "10.128.17.14\n" +
                "10.130.24.1\n" +
                "asfsfsdf\n" +
                "asff \n" +
                "12312 FSADFSADF\n" +
                "1Q2EDASDA\n");
        ipInString.findIpInString();

        IpFinder ipInFile= new IpFinder(new File("text.txt"));
        ipInFile.findIpInFile();
        ipInFile.findIpInString();
    }
}
