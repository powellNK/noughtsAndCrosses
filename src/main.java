import java.util.Scanner;


public class main {


    public enum Player {
        CROSSES('X'),
        NOUGHTS('0'),
        EMPTY('-');

        private final char value;

        Player(char value) {
            this.value = value;
        }

        public char getValue() {
            return value;
        }
    }

    private static int userInputCheck(String message) {
        Scanner reader = new Scanner(System.in);
        int digit;
        while (true) {
            System.out.print(message);
            try {
                digit = Integer.parseInt(reader.next());
                if (digit >= 0 && digit <= 2) {
                    break;
                }
                System.out.println("Число вне диапазона (1-3)");
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
        return digit;
    }

    static void fillStartBoard(Player[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = Player.EMPTY;
            }
        }
    }

    static void printBoard(Player[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col].getValue() + " ");
            }
            System.out.println();
        }
    }

    static int checkSumOfSeries(Player[][] board,int row, int col){
        int sumOfSeries = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[j].length; j++) {
                if (board[row][col] == Player.CROSSES){
                    sumOfSeries++;
                }
                else if(board[row][col] == Player.NOUGHTS){
                    sumOfSeries--;
                }
            }
        }

        return sumOfSeries;
    }

    public static void main(String[] args) {
        Player[][] board = new Player[3][3];

        fillStartBoard(board);
//        int[][] moveMade = new int[9][2];

        Player activePlayer = Player.CROSSES;
        boolean isPlay = true;
        int counter = 0;
//        int[] lastMove = new int[2];
        while (isPlay) {
            printBoard(board);
            int coordRow, coordCol;
            if (activePlayer == Player.CROSSES) {
                System.out.println("Ход игрока1 (Х):");

            } else {
                System.out.println("Ход игрока2 (О):");
            }
            do {
                coordRow = userInputCheck("Строка: ");
                coordCol = userInputCheck("Столбец: ");
            }while(board[coordRow][coordCol]!=Player.EMPTY);

//            lastMove[0] = coordRow;
//            lastMove[1] = coordCol;
//            moveMade[counter][0] = coordRow;
//            moveMade[counter][1] = coordCol;
            if (activePlayer == Player.CROSSES) {
                board[coordRow][coordCol] = Player.CROSSES;
                activePlayer = Player.NOUGHTS;
            } else {
                board[coordRow][coordCol] = Player.NOUGHTS;
                activePlayer = Player.CROSSES;
            }
//            System.out.println(lastMove[0] + " " + lastMove[1]);
            counter++;

            for (int row = 0; row < board.length; row++) {
                int sumOfSeriesRow = 0;
                int sumOfSeriesCol = 0;
                int sumOfSeriesdiagonal = 0;

                for (int col = 0; col < board[0].length; col++) {
                    // проверка по горизонтали
                    if (board[row][col] == Player.CROSSES) {
                        sumOfSeriesRow++;
                    } else if (board[row][col] == Player.NOUGHTS) {
                        sumOfSeriesRow--;
                    }
                    // проверка по вертикали
                    if (board[col][row] == Player.CROSSES) {
                        sumOfSeriesCol++;
                    } else if (board[col][row] == Player.NOUGHTS) {
                        sumOfSeriesCol--;
                    }
                    // проверка по диагнонали
                    if (board[col][col] == Player.CROSSES) {
                        sumOfSeriesdiagonal++;
                    } else if (board[col][col] == Player.NOUGHTS) {
                        sumOfSeriesdiagonal--;
                    }

                    if (counter == 9 || sumOfSeriesRow == 3 || sumOfSeriesRow == -3 || sumOfSeriesCol == 3 || sumOfSeriesCol == -3 || sumOfSeriesdiagonal == 3 || sumOfSeriesdiagonal == -3) {
                        isPlay = true;
                    }
                }
            }

        }
//        System.out.println("Сделанные ходы: ");
//        for (int i=0; i< moveMade[0].length;i++){
//            for (int j=0; j< moveMade.length;j++){
//                System.out.print(moveMade[j][i]+" ");
//            }
//            System.out.println();
//        }


    }
}
