public class TicTacToe {
    static int cnt = 0;
    boolean isEnd = false;
    private String[][] board = {
            {"-","-","-"},
            {"-","-","-"},
            {"-","-","-"}
    };

    public void newGame() {
        cnt = 0;
        isEnd = false;
        board = new String[][] {
                {"-","-","-"},
                {"-","-","-"},
                {"-","-","-"}
        };
    }

    public String[][] getField () {
        for (int i = 0; i < board.length; i++) {
            System.out.print("[");
            for (int j = 0; j <board.length; j++) {
                System.out.print(board[i][j]);
                if (j != board.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
        return board;
    }
    public String makeMove (int x, int y) {
        if (isEnd) {
            return "Game was ended";
        }
        if (x <= 0 || x >= board.length || y <= 0 || y >= board.length) {
            return null;
        }
        if (!board[x - 1][y - 1].equals("-")) {
            return "Cell " + x + ", " + y + " is already occupied";
        }
        cnt++;
        if (cnt % 2 == 0) {
            board[x-1][y-1] = "O";
        }
        else {
            board[x-1][y-1] = "X";
        }
        String check = checkGame();
        if (check != null) {
            isEnd = true;
            if (check.equals("Player X won") || check.equals("Player O won") || check.equals("Draw")) {
                return check;
            }
        }
        return "Move completed";
    }

    public String checkGame() {
        if(checkX()) {
            return "Player X won";
        }
        else if (checkO()) {
            return "Player O won";
        }
        else if (checkDraw()){
            return "Draw";
        }
        else {
            return null;
        }
    }

    public boolean checkDraw() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkX () {
        if (board[0][0].equals("X") && board[0][1].equals("X") && board[0][2].equals("X")) {
            return true;
        }
        else if (board[1][0].equals("X") && board[1][1].equals("X") && board[1][2].equals("X")) {
            return true;
        }
        else if (board[2][0].equals("X") && board[2][1].equals("X") && board[2][2].equals("X")) {
            return true;
        }

        else if (board[0][0].equals("X") && board[1][0].equals("X") && board[2][0].equals("X")) {
            return true;
        }
        else if (board[0][1].equals("X") && board[1][1].equals("X") && board[2][1].equals("X")) {
            return true;
        }
        else if (board[0][2].equals("X") && board[1][2].equals("X") && board[2][2].equals("X")) {
            return true;
        }
        else if (board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X")) {
            return true;
        }
        else if (board[2][0].equals("X") && board[1][1].equals("X") && board[0][2].equals("X")) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkO () {
        if (board[0][0].equals("O") && board[0][1].equals("O") && board[0][2].equals("O")) {
            return true;
        }
        else if (board[1][0].equals("O") && board[1][1].equals("O") && board[1][2].equals("O")) {
            return true;
        }
        else if (board[2][0].equals("O") && board[2][1].equals("O") && board[2][2].equals("O")) {
            return true;
        }

        else if (board[0][0].equals("O") && board[1][0].equals("O") && board[2][0].equals("O")) {
            return true;
        }
        else if (board[0][1].equals("O") && board[1][1].equals("O") && board[2][1].equals("O")) {
            return true;
        }
        else if (board[0][2].equals("O") && board[1][2].equals("O") && board[2][2].equals("O")) {
            return true;
        }
        else if (board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")) {
            return true;
        }
        else if (board[2][0].equals("O") && board[1][1].equals("O") && board[0][2].equals("O")) {
            return true;
        }
        else {
            return false;
        }
    }


    public static void main(String[] args) {
        TicTacToe board = new TicTacToe();
        board.getField();
        System.out.println(board.makeMove(1, 1));
        board.getField();
        System.out.println(board.makeMove(1, 1));
        System.out.println(board.makeMove(1, 2));
        board.getField();
        System.out.println(board.makeMove(2, 1));
        System.out.println(board.makeMove(2, 2));
        System.out.println(board.makeMove(3, 1));
        System.out.println(board.makeMove(2, 2));
        board.getField();
    }
}


//public class TicTacToe {
//   String[][] field;
//   String nowPlayer;
//
//   public TicTacToe() {
//       // создаем новую игру
//       newGame();
//   }
//
//   void newGame() {
//       // пересоздаем игру
//       field = new String[][]{{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
//       nowPlayer = "X";
//   }
//
//   String[][] getField() {
//       return field;
//   }
//
//   String makeMove(int x, int y) {
//       x -= 1;
//       y -= 1;
//       // проверяем ситуацию на поле
//       String check = this.checkGame();
//
//       // если не вернулось null, значит игра уже завершена (см checkField())
//       if (check != null) return "Game was ended";
//
//       // если клетка занята
//       if (!field[x][y].equals("-")) return "Cell " + (x + 1) + ", " + (y + 1) + " is already occupied";
//
//       // если же нет, то ставим X/0 и проверяем, что стало с полем после этого хода
//       field[x][y] = nowPlayer;
//       check = checkGame();
//
//       // если не вернулось null, значит этот ход завершил игру
//       if (check != null) {
//           if (check.equals("X")) return "Player X won";
//           else if (check.equals("0")) return "Player 0 won";
//           else return "Draw";
//       }
//
//       // иначе переключаем игрока на следующего
//       nowPlayer = nowPlayer.equals("X") ? "0" : "X";
//       return "Move completed";
//   }
//
//   String checkGame() {
//       // проверяем, есть ли 3 выставленных в ряд крестика или нолика
//       for (int i = 0; i < 3; i++) {
//           boolean check = true;
//           for (int j = 0; j < 3; j++) {
//               if (field[i][j].equals("0") || field[i][j].equals("-")) check = false;
//           }
//           if (check) return "X"; // если нашли 3 Х в ряд, то победа за Х
//       }
//       // тоже самое для 0
//       for (int i = 0; i < 3; i++) {
//           boolean check = true;
//           for (int j = 0; j < 3; j++) {
//               if (field[i][j].equals("X") || field[i][j].equals("-")) check = false;
//           }
//           if (check) return "0"; // если нашли 3 0 в ряд, то победа за 0
//       }
//
//       // проверяем, есть ли 3 выставленных в столбик крестика или нолика
//       for (int i = 0; i < 3; i++) {
//           boolean check = true;
//           for (int j = 0; j < 3; j++) {
//               if (field[j][i].equals("0") || field[j][i].equals("-")) check = false;
//           }
//           if (check) return "X"; // если нашли 3 Х в столбик, то победа за Х
//       }
//       // тоже самое для 0
//       for (int i = 0; i < 3; i++) {
//           boolean check = true;
//           for (int j = 0; j < 3; j++) {
//               if (field[j][i].equals("X") || field[j][i].equals("-")) check = false;
//           }
//           if (check) return "0"; // если нашли 3 0 в столбик, то победа за 0
//       }
//
//
//       // проверяем диагонали
//       String[] diagonal = {field[0][0], field[1][1], field[2][2]};
//       String[] diagonal2 = {field[0][2], field[1][1], field[2][0]};
//
//       boolean check = true;
//       for (int i = 0; i < 3; i++) {
//           if (diagonal[i].equals("0") || diagonal[i].equals("-")) check = false;
//       }
//       if (check) return "X"; // если не нашли 0 в диагонали то победа за Х
//       else {                 // иначе все тоже самое для 0
//           check = true;
//           for (int i = 0; i < 3; i++) {
//               if (diagonal[i].equals("X") || diagonal[i].equals("-")) check = false;
//           }
//           if (check) return "0"; // если в диагонали только 0, то за ними победа
//       }
//
//       // аналогично для 2 ой диагонали
//       check = true;
//       for (int i = 0; i < 3; i++) {
//           if (diagonal2[i].equals("0") || diagonal2[i].equals("-")) check = false;
//       }
//       if (check) return "X"; // если не нашли 0 в диагонали то победа за Х
//       else {                 // иначе все тоже самое для 0
//           check = true;
//           for (int i = 0; i < 3; i++) {
//               if (diagonal2[i].equals("X") || diagonal2[i].equals("-")) check = false;
//           }
//           if (check) return "0"; // если в диагонали только 0, то за ними победа
//       }
//
//       // если никто не победил
//       for (int i = 0; i < 3; i++) {
//           for (int j = 0; j < 3; j++) {
//               if (field[i][j].equals("-")) return null; // если еще есть пустые поля, то игра продолжается
//           }
//       }
//       return "D"; // иначе возвращаем ничью
//   }
//}checkX