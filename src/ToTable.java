import java.util.Arrays;

public class ToTable {
    private int[] date;
    private int x,y;

    public ToTable(int[] date, int x, int y) {
        this.date = date;
        this.x = x;
        this.y = y;
    }

    public int[][] resize() {
        int[][] res = new int[x][y];
        int cnt = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0 ; j < y; j++) {
                res[i][j] = date[cnt++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ToTable a = new ToTable(new int[] {1, 2, 3, 4, 5, 6}, 3, 2);
        int[][] arr = a.resize();
        System.out.println("Hello world");
    }
}
