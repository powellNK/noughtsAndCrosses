import java.util.Scanner;

public class main {
    private static int userInputCheck(String message) {
        Scanner reader = new Scanner(System.in);
        int digit;
        while (true) {
            System.out.print(message);
            try {
                digit = Integer.parseInt(reader.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
        return digit;
    }
    public static void main(String[] args) {
        String[][] board = new String[4][4];
        System.out.println();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = "-";
            }
            board[0][row] = "" + row;
            board[row][0] = "" + row;
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }

        Scanner reader = new Scanner(System.in);
//        int[][] moveMade = new int[9][2];

        boolean PlayerMove = true;
        boolean GameOver = false;
        int counter = 0;
//        int[] lastMove = new int[2];
        while (GameOver == false) {
            if (PlayerMove){
                System.out.println("Ход игрока1 (Х):");

            }else{
                System.out.println("Ход игрока2 (О):");
            }
            int coordRow = userInputCheck("Строка: ");
            int coordCol = userInputCheck("Столбец: ");
//            lastMove[0] = coordRow;
//            lastMove[1] = coordCol;
//            moveMade[counter][0] = coordRow;
//            moveMade[counter][1] = coordCol;
            if (PlayerMove) {
                board[coordRow][coordCol] = "X";
                PlayerMove = false;
            } else {
                board[coordRow][coordCol] = "O";
                PlayerMove = true;
            }
//            System.out.println(lastMove[0] + " " + lastMove[1]);
            counter++;

            for (int row = 0; row < board.length; row++) {
                int sumOfSeriesRow = 0;
                int sumOfSeriesCol= 0;
                int sumOfSeriesdiagonal = 0;

                for (int col = 0; col < board[0].length; col++) {
                    System.out.print(board[row][col] + " ");
                    // проверка по горизонтали
                    if (board[row][col] == "X"){
                        sumOfSeriesRow++;
                    }else if(board[row][col] == "O"){
                        sumOfSeriesRow--;
                    }
                    // проверка по вертикали
                    if (board[col][row] == "X"){
                        sumOfSeriesCol++;
                    }else if(board[col][row] == "O"){
                        sumOfSeriesCol--;
                    }
                    // проверка по диагнонали
                    if (board[col][col] == "X"){
                        sumOfSeriesdiagonal++;
                    }else if(board[col][col] == "O"){
                        sumOfSeriesdiagonal--;
                    }

                    if (counter == 9 || sumOfSeriesRow==3 || sumOfSeriesRow==-3 || sumOfSeriesCol ==3 || sumOfSeriesCol ==-3 || sumOfSeriesdiagonal ==3 || sumOfSeriesdiagonal ==-3) {
                        GameOver = true;
                    }
                }
                System.out.println();
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
