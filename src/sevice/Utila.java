package sevice;

import objectData.ObjectForCoincide;

import java.util.ArrayList;

/**
 * Created by Ультрамар on 27.11.2016.
 */
public class Utila {//This class was made for reduce code
    public static void cicleForObjectForCoincide(ArrayList<ObjectForCoincide> arrayOfCoincide) {
        System.out.println("we have few books with such name please choose one by typing a number of book:");
        for (int i = 0; i < arrayOfCoincide.size(); i++) {
            String g = arrayOfCoincide.get(i).getAuthor();
            String k = arrayOfCoincide.get(i).getBookname();
            System.out.println(i + 1 + ". " + g + " " + k);
        }
    }
    public static String picker(String s) {
        String[] isbnParts1 = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < isbnParts1.length; i++) {
            builder.append(isbnParts1[i]);
            if (i + 1 < isbnParts1.length) {
                builder.append(" ");
            }
        }
        String completedString = builder.toString();
        return completedString;
    }
}
