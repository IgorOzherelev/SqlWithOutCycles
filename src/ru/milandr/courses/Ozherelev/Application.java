package ru.milandr.courses.Ozherelev;

import java.sql.*;
import java.util.*;
import java.util.stream.IntStream;

public class Application {
    private static String databaseFirst;
    private static String databaseFirstLogin;
    private static String databaseFirstPassword;
    private static String databaseSecond;
    private static String databaseSecondLogin;
    private static String databaseSecondPassword;
    private static String databaseFirstTable;
    private static String databaseSecondTable;
    private static String regexSymbol = ",";

    private static Connection databaseFirstConnection;
    private static Connection databaseSecondConnection;

    private static Statement databaseFirstStatement;
    private static Statement databaseSecondStatement;

    private static ResultSet firstResultSet;
    private static ResultSet secondResultSet;


    private static boolean compareLists(List<?> firstList, List<?>secondList){

        boolean flag;
        int sizeFirst = firstList.size();
        int sizeSecond = secondList.size();

        if (sizeFirst != sizeSecond){
            flag = false;
        }

        else{
            flag = goThroughList(firstList, secondList, 0);
        }

        return flag;
    }

    private static boolean goThroughList(List<?> firstList, List<?>secondList, int i){

        int sizeList = firstList.size();
        List<?> swapperList = firstList;
        boolean flag = true;

        if (sizeList == 0)
        {
            System.out.println("Empty tables");
            System.exit(-1);
        }

        if ((i >= sizeList) && (sizeList != 0)){
            return flag;
        }

        else{

            if (!secondList.get(i).equals(swapperList.remove(i))){
                flag = false;
                return flag;
            }
            i++;
            goThroughList(firstList, secondList, i);
        }

        return flag;
    }

    private static int getLastRowIndex(ResultSet resultSet){

        int index;
        try {
            resultSet.last();
            index = resultSet.getRow();
            resultSet.beforeFirst();
        }
        catch (SQLException error){
            error.printStackTrace();
            return -1;
        }

        return index;
    }

    private static List<Map<String, String>> getListFromResultSet(ResultSet resultSet, List<String> columnNames){

        int size = getLastRowIndex(resultSet);
        List<Map<String, String>> outList = new ArrayList<>();

        IntStream firstStream = IntStream.range(0, size);

        firstStream.forEach(iter -> {
            try {
                if (resultSet.next())
                {
                    Map<String, String> map = new HashMap<>();
                    outList.add(map);

                    IntStream secondStream = IntStream.range(0, columnNames.size());

                    secondStream.forEach(index -> {
                        try {
                            map.put(columnNames.get(index), resultSet.getString(index + 1));
                        }
                        catch (SQLException e)
                        {
                            e.printStackTrace();
                        }
                    });
                }
            }
            catch (SQLException error) {
                error.printStackTrace();
            }
        });

        return outList;

    }

    private static void fillInfoAboutFirst(Scanner in){

        System.out.println("Enter name of first database");
        databaseFirst = in.nextLine();
        System.out.println("Enter login for " + databaseFirst);
        databaseFirstLogin = in.nextLine();
        System.out.println("Enter password for " + databaseFirst);
        databaseFirstPassword = in.nextLine();
        System.out.println("Enter name of the table in the first database");
        databaseFirstTable = in.nextLine();
    }

    private static void fillInfoAboutSecond(Scanner in){

        System.out.println("Enter name of second database");
        databaseSecond = in.nextLine();
        System.out.println("Enter login for " + databaseSecond);
        databaseSecondLogin = in.nextLine();
        System.out.println("Enter password for " + databaseSecond);
        databaseSecondPassword = in.nextLine();
        System.out.println("Enter name of the table in the second database");
        databaseSecondTable = in.nextLine();
    }


    public static void main (String[] args) throws SQLException {

        Scanner in = new Scanner(System.in);

        fillInfoAboutFirst(in);
        fillInfoAboutSecond(in);

        System.out.println("Enter column names separated by , ");

        String inputtedColumnNames = in.nextLine();
        List<String> columnNames = Arrays.asList(inputtedColumnNames.split(regexSymbol));

        String databaseFirstUrl = "jdbc:postgresql://localhost:5432/" + databaseFirst;
        String databaseSecondUrl = "jdbc:postgresql://localhost:5432/" + databaseSecond;

        try{

            databaseFirstConnection = DriverManager.getConnection(
                    databaseFirstUrl, databaseFirstLogin, databaseFirstPassword);

            databaseSecondConnection = DriverManager.getConnection(
                    databaseSecondUrl,
                    databaseSecondLogin, databaseSecondPassword);

            databaseFirstStatement = databaseFirstConnection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            databaseSecondStatement = databaseSecondConnection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            firstResultSet = databaseFirstStatement.executeQuery("SELECT " + inputtedColumnNames + " FROM " + databaseFirstTable);
            secondResultSet = databaseSecondStatement.executeQuery("SELECT " +
                   inputtedColumnNames + " FROM " + databaseSecondTable);

            List databaseFirstList = getListFromResultSet(firstResultSet, columnNames);
            List databaseSecondList = getListFromResultSet(secondResultSet, columnNames);

            System.out.println(compareLists(databaseFirstList, databaseSecondList));

        } catch (SQLException error) {
            error.printStackTrace();
        }

        finally{

            databaseFirstConnection.close();
            databaseSecondConnection.close();
        }
    }
}
