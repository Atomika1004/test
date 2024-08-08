public class LimitingRectangle {
    private int points[][];

    public LimitingRectangle(int[][] points) {
        this.points = points;
    }

    public int getWidth () {
        int max = 0;
        int min = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                max = Math.max(max,points[i][0]);
                min = Math.min(min,points[i][0]);
            }
        }
        return max - min;
    }
    public int getHeight () {
        int max = 0;
        int min = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                max = Math.max(max,points[i][1]);
                min = Math.min(min,points[i][1]);
            }
        }
        return max - min;
    }
    public String getBorders() {
        int maxX = 0;
        int minX = 0;
        int minY = 0;
        int maxY = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                maxX = Math.max(maxX,points[i][0]);
                minX = Math.min(minX,points[i][0]);
                maxY = Math.max(maxY,points[i][1]);
                minY = Math.min(minY,points[i][1]);
            }
        }
        StringBuilder res = new StringBuilder();
        res.append(minY).append(", ").append(maxY).append(", ").append(minX).append(", ").append(maxX);

        return res.toString();
    }


}
