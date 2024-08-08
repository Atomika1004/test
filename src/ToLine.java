public class ToLine {
    private int[][] date;

    public ToLine(int[][] date) {
        this.date = date;

    }

    public int[] resize() {
        int[] res = new int[date.length * date[0].length];
        int cnt = 0;
        for (int i = 0; i < date.length; i++) {
            for (int j = 0 ; j < date[0].length; j++) {
                res[cnt++] = date[i][j];
            }
        }
        return res;
    }
}
