import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[][] points = {
                {1,5,3,5,3},
                {4,8,1,3,6},
                {9,5,2,6,7},
                {3,6,1,7,3},
                {7,2,4,6,1}
        };
        String[] players = {"Саша", "Игорь", "Миша", "Коля", "Владимир"};
        int[] summPoints = new int[5];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                summPoints[i] += points[i][j];
            }
            System.out.println("Имя игрока: " + players[i] + "\n" + "Cумма баллов: " + summPoints[i]);
        }
        //System.out.println(Arrays.toString(summPoints));
    }
}
