package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpFinder {
    private final String PATTERN = "[\\d]+[.][\\d]+[.][\\d]+[.][\\d]+";
    private File file;
    private String string;

    public IpFinder(File file) {
        this.file = file;
    }

    public IpFinder(String string) {
        this.string = string;
    }

    public IpFinder(File file, String string) {
        this.file = file;
        this.string = string;
    }


    public void findIpInFile() {
        checkInput(Source.FILE);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {


                Pattern pattern = Pattern.compile(PATTERN);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {

                    System.out.println(matcher.group());


                }
            }
        } catch (IOException ioException) {
            System.out.println("Файл не найден.");
        }
    }


    public void findIpInString() {
        checkInput(Source.STRING);
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {

            System.out.println(matcher.group());

        }


    }

    private void checkInput(Source source) {
        try {
            if (!((!Objects.isNull(this.string) && source.equals(Source.STRING))
                    ||(!Objects.isNull(this.file) && source.equals(Source.FILE)))) {

                throw new IllegalAccessException();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


    private enum Source {
        STRING,
        FILE
    }
}
