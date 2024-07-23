package com.example.nikita.dema.bases.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IOMain {
    public static void main(String[] args) {
        try {
            String someText = "fdfdsfsdfsdf";
            File myObj = new File("/home/dmytro/dev/projects/nikita/src/main/java/com/example/nikita/dema/bases/io/test.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
