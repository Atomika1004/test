public class SeaBord {
    private String[][] field = {
            {".",".",".",".",".",".",".",".",".",".",},
            {".",".",".",".",".",".",".",".",".",".",},
            {".",".",".",".",".",".",".",".",".",".",},
            {".",".",".",".",".",".",".",".",".",".",},
            {".",".",".",".",".",".",".",".",".",".",},
            {".",".",".",".",".",".",".",".",".",".",},
            {".",".",".",".",".",".",".",".",".",".",},
            {".",".",".",".",".",".",".",".",".",".",},
            {".",".",".",".",".",".",".",".",".",".",},
            {".",".",".",".",".",".",".",".",".",".",}
    };

    public SeaBord () {
        field = new String[10][10]; // инициализируем и заполняем его в
        //конструкторе
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j] = ".";
            }
        }
    }

    public String[][] getField() {
        for (int i = 0; i <field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        return field;
    }

    public void shoot(int line, int column, String issue) {
        if(line < 0 || column < 0 || line > 9 || column > 9) {
            return;
        }
        if ( issue.equals("m")) {
            field[line][column] = "#";
        }
        if ( issue.equals("h")) {
            field[line][column] = "x";
        }
        if ( issue.equals("d")) {
            field[line][column] = "x";
            if (field[line][column + 1].equals("x") || field[line][column - 1].equals("x")) {
                killGorizont(line, column);
            }
            else if (field[line - 1][column].equals("x") || field[line + 1][column].equals("x")){
                killVertical(line,column);
            }
            else {
                killOne(line,column);
            }
        }
    }



    private void killGorizont(int line, int column) {
        int countX = 0;
        boolean isFirstX = false;
        int indexFirstX = 0;
        for (int i = 0; i < field.length; i++) {
            if (!isFirstX && field[line][i].equals("x")) {
                indexFirstX = i;
                isFirstX = true;
            }
            if (field[line][i].equals("x")) {
                countX++;
            }
        }
        if (indexFirstX > 0 && countX + indexFirstX < 9) {
            field[line][column - indexFirstX - 1] = "#";
            field[line][indexFirstX + countX] = "#";
            int j = 0;
            for (int i = indexFirstX - 1; i < countX + 2; i++) {
                field[line - 1][column - 1 - indexFirstX + j] = "#";
                field[line + 1][column - 1 - indexFirstX + j] = "#";
                j++;
            }
        }
        else if (indexFirstX + countX < 10){
            field[line][indexFirstX + countX] = "#";
            int j = 0;
            for (int i = indexFirstX; i < countX - 1; i++) {
                field[line - 1][column - 1 - indexFirstX + j] = "#";
                field[line + 1][column - 1 - indexFirstX + j] = "#";
                j++;
            }
        }
        else {
            field[line][indexFirstX - 1] = "#";
            int j = 0;
            System.out.println(indexFirstX);
            for (int i = indexFirstX; i < field.length + 1; i++) {
                field[line - 1][indexFirstX - 1  + j] = "#";
                field[line + 1][indexFirstX - 1 + j] = "#";
                j++;
            }
        }
    }

    private void killVertical(int line, int column) {
        int countY = 0;
        boolean isFirstX = false;
        int indexFirstY = 0;
        for (int i = 0; i < field.length; i++) {
            if (!isFirstX && field[i][column].equals("x")) {
                indexFirstY = i;
                isFirstX = true;
            }
            if (field[i][column].equals("x")) {
                countY++;
            }
        }
        if (indexFirstY > 0 && countY + indexFirstY < 9) {
            field[indexFirstY - 1][column] = "#";
            field[indexFirstY + countY][column] = "#";
            int j = 0;
            for (int i = indexFirstY - 1; i < countY + 3; i++) {
                field[line - indexFirstY + j][column - 1] = "#";
                field[line - indexFirstY + j][column + 1] = "#";
                j++;
            }
        }
        else if (indexFirstY + countY < 10){
            field[indexFirstY + countY][column] = "#";
            int j = 0;
            for (int i = indexFirstY; i < countY + 1; i++) {
                field[indexFirstY + j][column - 1] = "#";
                field[indexFirstY + j][column + 1] = "#";
                j++;
            }
        }
        else {
            field[indexFirstY - 1][column] = "#";
            int j = 0;
            for (int i = indexFirstY; i < field.length + 1; i++) {
                field[indexFirstY + j - 1][column - 1] = "#";
                field[indexFirstY +j - 1][column + 1] = "#";
                j++;
            }
        }
    }

    public void killOne (int line, int column) {
        if (line != 0 || column != 0) {
            for (int i = line - 1; i < 4; i++) {
                field[i][column + 1] = "#";
                field[i][column - 1] = "#";
            }
            field[line - 1][column ] = "#";
            field[ line + 1][column] = "#";
        }
        else if (line == 0) {
            for (int i = line; i < 4; i++) {
                field[i][column + 1] = "#";
                field[i][column - 1] = "#";
            }
            field[ line + 1][column] = "#";
        }
        else if (column == 0) {
            for (int i = column; i < 4; i++) {
                field[i][column + 1] = "#";
                field[i][column - 1] = "#";
            }
            field[line - 1][column ] = "#";
        }
    }

    public String check(int line, int column) {
        return field[line][column];
    }

    public static void main(String[] args) {
        SeaBord board = new SeaBord();
//        board.shoot(0, 0, "m");
//        board.shoot(2, 1, "h");
//        board.shoot(6, 9, "h");
//        board.shoot(2, 2, "d");
        board.shoot(0, 0, "d");
        board.shoot(8, 3, "h");
        board.shoot(6, 9, "h");

//        board.shoot(2, 8, "d");
        board.getField();
    }
}


// Решение с skillFactory (туполобые ебанаты дают на рекурсию решение)
//public class SeaBoard {
//   /* Итак, план решения:
//   если с с методами getField() и check() все +- понятно,
//   то как быть со сбитым кораблем?
//   Мы предлагаем следующее:
//   1 Давайте записывать попадание не как "x", а как "X", а сбитые
//   корабли как "x",
//   а при возвращении значений, просто заменять все "X", на "x"
//   Тогда, как только пришла команда о сбитие корабля, мы легко обойдем
//   участок сбития (см метод "sink()").
//    */
//   private String[][] field; // создаем приватное поле
//
//   public SeaBoard() {
//       field = new String[10][10]; // инициализируем и заполняем его в
//       //конструкторе
//       for (int i = 0; i < 10; i++) {
//           for (int j = 0; j < 10; j++) {
//               field[i][j] = ".";
//           }
//       }
//   }
//
//   String[][] getField() {
//       String[][] result = new String[10][10];
//       for (int i = 0; i < 10; i++) {
//           for (int j = 0; j < 10; j++) {
//               if (field[i][j].equals("X")) result[i][j] = "x"; // как и
//               //говорилось в начале
//               else result[i][j] = field[i][j];                 //
//               //искусственно заменяем X на x
//           }
//       }
//       return result; // создаем геттер для поля
//   }
//
//   String check(int line, int column) {
//       if (field[line][column].equals("X")) return "x"; // тоже
//       //искусственно заменяем X на x
//       return field[line][column]; // метод чек, для проверки полей
//   }
//
//   void shoot(int line, int column, String issue) {
//       if (issue.equals("m")) field[line][column] = "#"; // если
//       //промахнулись, то просто ставим промах
//       else if (issue.equals("h")) field[line][column] = "X"; // если
//       //попали, но не потопили, то ставим X
//       else {
//           field[line][column] = "X"; // если же этим выстрелом корабль
//           //был потоплен, то ставим попадание
//           sink(line, column);        // и обрабатываем уничтожение в методе sink
//       }
//   }
//
//   private void sink(int line, int column) {
//       int[][] commands = new int[][]  // массив всех возможных полей,
//               //которые надо поменять
//               {{line - 1, column}, {line + 1, column}, // вокруг
//               //клетки, в которую попали
//               {line, column - 1}, {line, column + 1},
//               {line - 1, column - 1}, {line - 1, column + 1},
//               {line + 1, column - 1}, {line + 1, column + 1}};
//
//       for (int[] i : commands) {
//           if (0 <= i[0] && i[0] <= 9 && 0 <= i[1] && i[1] <= 9 &&
//               field[i[0]][i[1]].equals(".")) {
//               field[i[0]][i[1]] = "#"; // если координаты лежат внутри
//                                 //поля и в них не стреляли, то меняем их
//           }
//       }
//
//       field[line][column] = "x"; // после того, как обработали это
//                                  //поле, заменяем его на потопленное
//
//       for (int[] i : commands) {
//           if (0 <= i[0] && i[0] <= 9 && 0 <= i[1] && i[1] <= 9 && field[i[0]][i[1]].equals("X")) {
//               sink(i[0], i[1]); // и ищем следующее, прилежащее к
//                                 //нашему полю и так же обрабатываем его
//           }
//       }
//       // таким образом мы рекурсивно обойдем все прилежащие поля, к
//       //полю, которое подбили и прилежащие к ним.
//   }
//}
//
//class Main {
//   public static void main(String[] args) {
//       SeaBoard board = new SeaBoard();
//       board.shoot(0, 0, "m");
//       board.shoot(2, 0, "h");
//       board.shoot(6, 9, "h");
//       board.shoot(2, 1, "d");
//       for (int i = 0; i < board.getField().length; i++) {
//           for (int j = 0; j < board.getField()[0].length; j++) {
//               System.out.print(board.getField()[i][j] + " ");
//           }
//           System.out.println();
//       }
//   }
//}