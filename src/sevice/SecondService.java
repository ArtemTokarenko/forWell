package sevice;

import connectionToDB.ConnectionToDB;
import objectData.ObjectForCoincide;
import consta.Constant;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SecondService {//From this class we just call database

    public static String addToDataBase(String author, String bookname) {
        ConnectionToDB connectionToDB = new ConnectionToDB();
        int isSuccess = 0;
        try {
            isSuccess = connectionToDB.getConnection().executeUpdate("INSERT INTO " + Constant.TableName + " (`author`, `book`) VALUES (\'" + author + "\',\'" + bookname + "\')");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String stringBook = "Book";
        if (isSuccess == 1) {
            return stringBook + author + " \"" + bookname + "\"" + " was added";
        } else {

            return stringBook + author + " \"" + bookname + "\"" + " was not added";
        }

    }

    public static String remover(String bookname) {
        ConnectionToDB connectionToDB = new ConnectionToDB();
        int isSuccess = 0;
        try {
            connectionToDB.getConnection().executeUpdate("SET SQL_SAFE_UPDATES = 0");
            isSuccess = connectionToDB.getConnection().executeUpdate("DELETE FROM " + Constant.TableName + " WHERE book=" + "\'" + bookname + "\'");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String stringBook = "Book";
        if (isSuccess == 1) {
            return stringBook + " \"" + bookname + "\"" + " was removed";
        } else {

            return stringBook + " \"" + bookname + "\"" + " book not exist";
        }

    }

    public static String remover(Integer ID, String author, String book) {
        ConnectionToDB connectionToDB = new ConnectionToDB();
        ResultSet resultSet = null;
        try {
            connectionToDB.getConnection().executeUpdate("SET SQL_SAFE_UPDATES = 0");
            connectionToDB.getConnection().executeUpdate("DELETE FROM " + Constant.TableName + " WHERE ID=" + "\'" + ID + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "Book" + author + " \"" + book + "\"" + " was removed";
    }

    public static String reNamer(Integer ID, String bookname) {
        ConnectionToDB connectionToDB = new ConnectionToDB();
        ResultSet resultSet = null;
        try {
            connectionToDB.getConnection().executeUpdate("SET SQL_SAFE_UPDATES = 0");
            connectionToDB.getConnection().executeUpdate("UPDATE " + Constant.TableName + " SET book =" + "\'" + bookname + "'" + " WHERE ID=" + "\'" + ID + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "Book vas renamed";
    }

    public static List<String> getAllBooks() {
        ArrayList<String> listOfBooks = new ArrayList<>();

        ConnectionToDB connectionToDB = new ConnectionToDB();
        ResultSet resultSet = null;
        try {
            resultSet = connectionToDB.getConnection().executeQuery("SELECT * FROM " + Constant.TableName);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            while (resultSet.next()) {
                listOfBooks.add(resultSet.getRow() + ". " + resultSet.getString("author")
                        + "\t" + resultSet.getString("book"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfBooks;
    }

    public static ArrayList<ObjectForCoincide> getAllCoincide(String book) {
        ConnectionToDB connectionToDB = new ConnectionToDB();
        ResultSet resultSet = null;
        try {
            resultSet = connectionToDB.getConnection().executeQuery("SELECT * FROM " + Constant.TableName + " WHERE book=" + "\'" + book + "\'");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<ObjectForCoincide> arrayList = new ArrayList<ObjectForCoincide>();
        Integer count = 0;

        try {
            while (resultSet.next()) {
                ObjectForCoincide objectForCoincide = new ObjectForCoincide();
                objectForCoincide.setAuthor(resultSet.getString("author"));
                objectForCoincide.setBookname(resultSet.getString("book"));
                objectForCoincide.setId(Integer.parseInt(resultSet.getString("ID")));
                arrayList.add(count, objectForCoincide);
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrayList;
    }


}