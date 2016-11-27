package sevice;

import objectData.ObjectForCoincide;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ультрамар on 27.11.2016.
 */
public class MainService {
    public  static void add(String s){//This class shares String to Strings and give Strings to addToDataBase()

        try {
            String[] isbnParts = s.split(" ");
            if (isbnParts[1].equals("Unknown")) {
                String[] isbnParts1 = s.split("“");
                String f1 = isbnParts[1];
                String f2 = isbnParts1[1].substring(0, isbnParts1[1].length() - 1);
                System.out.println(SecondService.addToDataBase(f1, f2));

            } else {
                String[] isbnParts1 = s.split("“");
                String f1 = isbnParts[1] + " " + isbnParts[2];
                String f2 = isbnParts1[1].substring(0, isbnParts1[1].length() - 1);
                System.out.println(SecondService.addToDataBase(f1, f2));
            }
        }
        catch (Exception e){
            System.out.println("Not complied with the format, sorry");
        }

    }
    public  static void all(){ //This class asking getAllBooks() in cycle

        for (int i = 0; i < SecondService.getAllBooks().size(); i++) {
            System.out.println(SecondService.getAllBooks().get(i));
        }

    }
    public  static void remove(String s,Scanner scan){//This class shares String to Strings and asking two removers to remove the column

            ArrayList<ObjectForCoincide> arrayOfCoincide = SecondService.getAllCoincide(Utila.picker(s));
            if (arrayOfCoincide.size() > 1) {

                Utila.cicleForObjectForCoincide(arrayOfCoincide);
                try {
                    String tt = scan.next();
                    int choice = Integer.parseInt(tt) - 1;
                    System.out.println(SecondService.remover(arrayOfCoincide.get(choice).getId(), arrayOfCoincide.get(choice).getAuthor(), arrayOfCoincide.get(choice).getBookname()));
                } catch (NumberFormatException e) {
                    System.out.println("Would you kindly write a number?");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Would you kindly write a number from list?");
                }

            } else {
                System.out.println(SecondService.remover(Utila.picker(s)));
            }

        }
    public  static void edit(String s, Scanner scan){//This class shares String to Strings and asking two removers to remove the update
        try{

            ArrayList<ObjectForCoincide> arrayOfCoincide = SecondService.getAllCoincide(Utila.picker(s));
            if (arrayOfCoincide.size() > 1) {

                Utila.cicleForObjectForCoincide(arrayOfCoincide);
                System.out.println("Who will be renamed?");
                String nextLine = scan.nextLine();
                System.out.println("What is new name?");
                String nextLine1 = scan.nextLine();
                    System.out.println(SecondService.reNamer(arrayOfCoincide.get(Integer.parseInt(nextLine) - 1).getId(), nextLine1));
                    // add J. Martin “A Song of Ice and Fire”
            } else {
                System.out.println("What is new name?");
                String t = scan.nextLine();
                System.out.println(SecondService.reNamer(arrayOfCoincide.get(0).getId(), t));
            }

        }
        catch (Exception e){
            System.out.println("not complied with the format, sorry");
        }
    }
}


