import java.util.Arrays;

public class Squirrel {
    private int[] nuts;


    public Squirrel(int[] nuts) {
        this.nuts = nuts;
    }

    public int getNuts(int index) {

        return nuts[index];
    }

    public int maxNuts () {
        int res = 0;
        int i = 0;
        if (nuts == null || nuts.length == 0) {
            return 0;
        }
        int n = nuts.length;
        if (n == 1) {
            return Math.max(nuts[0], 0);
        }
        for (; i < nuts.length - 1; i++) {
            if (nuts[i] >= 0) {
                res += nuts[i];
            }
            else {
                if (i + 1 < nuts.length && nuts[i] <= nuts[i + 1]) {
                    res += nuts[i + 1];
                    i++;
                }
                else {
                    res += nuts[i];
                }
            }
        }
        return Math.max(0, res);
    }

    public static void main(String[] args) {
//        Squirrel s = new Squirrel(new int[] {2, -3});
//        System.out.println(s.maxNuts());
//
//        Squirrel s2 = new Squirrel(new int[] {1, -2, 3, 1, -1, -4, 2, 3});
//        System.out.println(s2.maxNuts());

        Squirrel s3 = new Squirrel(new int[] {2, 5, -3, -1, 1, -2, -4, 7, 3, -2, -2, 1, -1});
        System.out.println(s3.maxNuts());


        Squirrel s4 = new Squirrel(new int[] {-2, 2, 4, -6, -2, -1, -2, 1, 1, -1, 1, -2});
        System.out.println(s4.maxNuts());


        Squirrel s5 = new Squirrel(new int[] {1, -2, 4, 6, 3, -2, -2, -3, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1});
        System.out.println(s5.maxNuts());
    }
}


//public class Squirrel {
//    private int[] nuts;
//
//    public Squirrel(int[] nuts) {
//        this.nuts = nuts;
//    }
//
//    public int getNuts(int index) {
//        return nuts[index];
//    }
//
//    ///*
//    public int maxNuts() {
//        int maxOfNuts = 0, len = nuts.length;
//        if (len > 1) {
//            int i = 0;
//            //Проверяем, можно ли подобрать орешки с первого
//            if (nuts[i] > 0)
//                maxOfNuts += nuts[i];
//            //Проверяем, можно ли подобрать орешки со второго до последнего-предпоследнего
//            for (; i < len - 2; i++) {
//                if (nuts[i + 1] < 0 && nuts[i + 1] <= nuts[i + 2])
//                    i++;//перепрыгиваем через пень
//                maxOfNuts += nuts[i + 1];
//                if (maxOfNuts < 0)
//                    maxOfNuts = 0;
//            }
//            // Смотрим, стоит ли прыгать на последний пень
//            if (i == len - 2 && nuts[i + 1] > 0) {
//                maxOfNuts += nuts[i + 1];
//            }
//            return maxOfNuts;
//        } else if (nuts[0] >= 0)
//            return nuts[0];
//        else
//            return 0;
//    }
//    //*/
//}