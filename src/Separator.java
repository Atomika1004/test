import java.util.ArrayList;
import java.util.Arrays;

public class Separator {
    int[] arr;

    public Separator(int[] arr) {
        this.arr = arr;
    }

    public int[] even() {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <arr.length; i++) {
            if (arr[i] % 2 == 0) {
                res.add(arr[i]);
            }
        }
        Integer[] array = res.toArray(new Integer[0]);
        int[] resArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            resArr[i] = array[i];
        }
        return resArr;
    }
    public int[] odd() {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <arr.length; i++) {
            if (arr[i] % 2 != 0) {
                res.add(arr[i]);
            }
        }
        Integer[] array = res.toArray(new Integer[0]);
        int[] resArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            resArr[i] = array[i];
        }
        return resArr;
    }

    public static void main(String[] args) {
        Separator separator = new Separator(new int[] {1,2,3,4,5,6,7,8,9});
        System.out.println(separator.even().toString());
    }
}
