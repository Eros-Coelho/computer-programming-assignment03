/*
Name: Eros Lima Coelho
ID Number: 3151957
Date of Submission: 14/04/2024
*/

package griffith;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

//    Task 1 Function: Creating a function that tells the user if their grade is distinction, merit, pass or fail

    static String award(int value) {
        String integer = "";

//        As seen in  class, this code stores an integer, and depending where it lands, it returns a string saying what the code needs

        if (value >= 70 && value <=100){
            integer = "Distinction";
        } else if (value >= 63 && value <=69){
            integer = "Merit 1";
        } else if (value >= 55 && value <= 62){
            integer = "Merit 2";
        } else if (value >= 40 && value <=54){
            integer = "Pass";
        } else if (value <=39){
            integer = "Fail";
        } else {
            integer = "Invalid number!";
        }

        return integer;
    }

//    Task 2 Function: The program first stores 2 integers, hour and minute, and separates them using parseInt, checks if the hour is greater than 13, if so, subtract 12 from it and add pm

    public static void timeConverter(String time) {

        //      Separates the integers hour and minute with a ":" so the user can put the time in one input only
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

//          If the hour integer is 13 or greater, the program will subtract 12 from it, then print the new "hour:minute pm"
        if (hour >= 13) {
            System.out.println((hour - 12) + ":" + minute + "pm");

//          If hour is already 12 or lesser, the program will print the same hour as the input, ":" and minutes + am
        } else if (hour <= 12) {
            System.out.println(hour + ":" + minute + "am");
        }
    }

//    Task 3 Function:

    public static void drawSquares(int numOfRows, int numOfColumns) {
        //Looping through number of rows
        for (int i = 0; i < numOfRows; i++) {
            System.out.print("\n");
            // Looping through number of columns and drawing tops of squares
            for (int j = 0; j < numOfColumns; j++) {
                System.out.print(" _ ");
            }
            // Switching to nextline to draw rest of square
            System.out.print("\n");

            // Looping through numOfColumns once again in order to draw the rest of the squares
            for (int j = 0; j < numOfColumns; j++) {
                System.out.print("|_|");
            }
        }
    }

//    Task 4 Function: Takes user input and says if the date  given is valid considering the format DD/MM/YYYY

    public static void validDate(String date) {

        Scanner scanner = new Scanner(System.in);

        int valid = 0;

//        Using while loop, since the amount of times the loop is going to run depends on user input
//        int valid set to zero, it will only increase if the user has put in a valid date, otherwise it will simply ask them to try again
        while (valid == 0) {

//            Splitting the string for date in 3, days, months and years
            String[] parts = date.split("/");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

//            If the user input has an invalid day, or month or year, the program will ask them to try again
            if (day < 1 || day > 31) {
                System.out.println("Invalid date!");
                System.out.print("Please enter a valid date (DD/MM/YYYY): ");
                scanner.nextLine();
            } else if (month < 1 || month > 12) {
                System.out.println("Invalid date!");
                System.out.print("Please enter a valid date (DD/MM/YYYY): ");
                scanner.nextLine();
            } else if (year < 0) {
                System.out.println("Invalid date!");
                System.out.print("Please enter a valid date (DD/MM/YYYY): ");
                scanner.nextLine();
//                Finally, if the date is valid, the int valid will increase to 1, finishing the loop
            } else {
                System.out.println("Valid date!");
                valid++;
            }
        }
    }

//    Task 5 Function:

    public static boolean anagramCheck(String first, String second) {

        if (first.length() != second.length()) {
            return false;
        }
        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();

        Arrays.sort(firstArray);
        Arrays.sort(secondArray);

        return Arrays.equals(firstArray, secondArray);
    }

    public static boolean anagramCheck(char[] first, char[] second) {

//        first check if the length of both words is the same; if not, they can't be anagrams
        if (first.length != second.length) {
            return false;
        }
//        using a for loop to check individually each letter of the words, if they are in any way different, the program will return false
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        Task 1:

        System.out.print("Please enter your grade: ");
        int value = scanner.nextInt();

//        simply calling out on the function, with the integer entered by the user

        System.out.println(award(value));

//        Task 2: Time converter. Converting time in 24h format to am / pm

        System.out.print("Please enter the time in 24h format (i.e. 13:30): ");
        String time = scanner.nextLine();

        timeConverter(time);


//        Task 3:

//Getting inputs from the user and assigning them to variables
        System.out.println("Enter the numbero f columns: ");
        int columns = scanner.nextInt();

        System.out.println("Enter the number of rows: ");
        int rows = scanner.nextInt();

        drawSquares(rows, columns);

//            Task 4: Asks the user to give the program a date on DD/MM/YYYY format; if the date given is invalid, the program will say so and ask for the user to try again

        System.out.print("Please enter a valid date (DD/MM/YYYY): ");
        String date = scanner.nextLine();

        validDate(date);

//        Task 5: using public static boolean anagramCheck, the code will tell us if the two words given are or not anagrams of each other, using if and for loop

//        Strings to be checked
        String first = "cat";
        String second = "act";

//        converting both words to lowercase
        first = first.toLowerCase();
        second = second.toLowerCase();

//        converting strings into character arrays and then sorting them
        char[] first_array = first.toCharArray();
        char[] second_array = second.toCharArray();

        Arrays.sort(first_array);
        Arrays.sort(second_array);

//        using the anagramCheck function, the program will check if the arrays are the same, if so it will say the words are anagrams
        if (anagramCheck(first_array, second_array)) {
            System.out.println(first + " and " + second + " are anagrams!");
        } else {
            System.out.println(first + " and " + second + " are not anagrams!");
        }
        scanner.close();
    }
}