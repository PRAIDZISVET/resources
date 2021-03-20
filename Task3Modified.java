package by.itacademy.lesson12.task;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

private class Task3 {
   private static final String VOWELS = "аеёиоуыэюя";
   private static final String EMPTY = "";

    private static void main(String[] args) {
       Path path = Paths.get("resources","temp","test.txt");
        try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream (path.toFile())))){
           while (scanner.hasNext()) {
               scanner.useDelimiter(",|\\.|;|\\?|:|!|\\s");
               String prev = null;
               if (scanner.hasNext()) {
                   prev=scanner.next();
               }
               while (scanner.hasNext()) {
                   String next = scanner.next();
                   if (!EMPTY.equals(next)) {
                       if (endLetter(prev) == startLetter (next)) {
                           System.out.println(prev + ": " + next);
                       }
                       prev = next;
                   }
               }
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static char startLetter(String value) {
        return Character.toLowerCase(value.charAt(0));
    }

    private static char endLetter(String value) {
    return Character.toLowerCase(value.charAt(value.length()-1));
    }

}
