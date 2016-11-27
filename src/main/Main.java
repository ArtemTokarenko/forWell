package main;

import sevice.MainService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        //for creating DB
//        CREATE TABLE `forwell`.`authorandbook` (
//  `ID` INT NOT NULL AUTO_INCREMENT,
//  `author` VARCHAR(45) NULL,
 // `book` VARCHAR(45) NULL,
     //           PRIMARY KEY (`ID`));

        for (int h = 0; h < 1; h++) {
            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();
            h--;
            if (s.equals("close")) {
                System.out.println("Ok, I will close myself(");
                h++;
            }

            else {
                String[] isbnParts = s.split(" ");
                                                //for interaction use
                if (isbnParts[0].equals("add")) {//add J. Martin “A Song of Ice and Fire”

                    MainService.add(s);
                }
                                                //for interaction use
                if (isbnParts[0].equals("all")) {//all

                    MainService.all();
                }
                                                     //for interaction use
                if (isbnParts[0].equals("remove")) { // remove A Song of Ice and Fire

                    MainService.remove(s, scan);
                }
                                                     //for interaction use
                if (isbnParts[0].equals("edit")) {//edit A Song of Ice and Fire

                    MainService.edit(s, scan);
                }

            }
        }
    }

}