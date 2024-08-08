import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrectName = false;
        while (!isCorrectName) {
            String name = scanner.nextLine(); //Считывает строку из System.in
            isCorrectName = checkName(name);
            if (!isCorrectName) {
                System.out.println("Введите корректное имя!");
            } else {
                System.out.println(formatName(name));
            }
        }
    }

    private static String formatName(String name) {
        String[] arr = name.split(" ");

        String str = "";
        for (String s: arr) {
             str +=s;
        }
        return str;
    }

    private static void sortByLength(String[] words) {
        //Написать код здесь
    }

    private static boolean checkName(String name) {
        //Написать код здесь
        String[] arr = name.split(" ");
        if (arr.length == 3) {
            return true;
        } else {
            return false;
        }
    }
}
