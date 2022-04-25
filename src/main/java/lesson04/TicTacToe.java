package lesson04;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static final int MIN_MAP_SIZE = 3;
    public static final int MAX_MAP_SIZE = 15;
    static int SIZE;
    static int LENGTH_TO_WIN;
    static int turnsCount;
    static int lastTurnLine;
    static int lastTurnCol;
    final static char DOT_EMPTY = '.';
    final static char DOT_HUMAN = 'X';
    final static char DOT_AI = '0';
    public static String SPACE_MAP = " ";
    public static String EXTRA_SPACE_MAP = "";
    public static String HEADER_FIRST_SYMBOL = "#";


    static char[][] MAP;

    static Scanner in = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        do {
            System.out.println("\nTic Tac Toe game started!");
            init();
            printMap();
            playGame();
        } while (isContinueGame());
        in.close();
    }

    private static boolean isContinueGame() {
        System.out.print("\nDo you want play again? (y/n): ");
        return switch (in.next()){
            case "y", "+" -> true;
            default -> false;
        };
    }

    private static void playGame() {
        do {
            humanTurn();
            printMap();
            if (checkWin(DOT_HUMAN)){
                System.out.println("GAME OVER. YOU ARE WINNER!!");
                break;
            }
            if (checkDraw()) {
                break;
            }
            computerTurn();
            printMap();
            if (checkWin(DOT_AI)){
                System.out.println("GAME OVER. YOU ARE LOOSER((");
                break;
            }
            if (checkDraw()) {
                break;
            }
        } while (true);
    }

    private static boolean checkWin(char symbol) {
        return checkLine(symbol) || checkColum(symbol) || checkDownDiagonal(symbol) || checkUpDiagonal(symbol);
    }

    private static boolean checkDraw() {
        if (turnsCount == SIZE * SIZE) {
            System.out.println("\nGAME OVER WITH DRAW!");
            return true;
        }
        return false;
    }

    private static boolean checkDownDiagonal(char symbol) {
        int itemCount = 0;
        int turnI = lastTurnLine;
        int turnJ = lastTurnCol;
        int firstI, firstJ, diagonalLength;



        if (turnJ > turnI) { // верхней половины
            firstI = 0;
            firstJ  = turnJ - turnI;
            diagonalLength = SIZE - firstJ;
        } else { // для нижней половины и для центральной диагонали
            firstI = turnI - turnJ;
            firstJ = 0;
            diagonalLength = SIZE - firstI;
            }

        for (int i = 0; i < diagonalLength; i++) {
            if (MAP[firstI + i][firstJ + i] == symbol) {
                itemCount++;
            } else itemCount =0;
            if (itemCount >= LENGTH_TO_WIN){
                return true;
            }
        }

        return false;
    }

    private static boolean checkUpDiagonal(char symbol) {
        int itemCount = 0;
        int turnI = lastTurnLine;
        int turnJ = lastTurnCol;
        int firstI, firstJ, diagonalLength;



        if (turnI+ turnJ >= SIZE-1) { // для нижней половины и центральной
            firstI = (turnI + turnJ) - SIZE + 1;
            firstJ = SIZE - 1;
            diagonalLength = SIZE - firstI;
        } else { // для верхней половины
            firstI = 0;
            firstJ = turnI + turnJ;
            diagonalLength = firstJ + 1;
        }

            for (int i = 0; i < diagonalLength; i++) {
                if (MAP[firstI + i][firstJ - i] == symbol) {
                    itemCount++;
                } else itemCount = 0;
                if (itemCount >= LENGTH_TO_WIN) {
                    return true;
                }
            }

        return false;
    }

    private static boolean checkLine(char symbol) {
        int itemCount = 0;
        for (int i = 0; i < SIZE; i++) {
            if (MAP[lastTurnLine][i] == symbol) {
                itemCount++;
            } else itemCount =0;
            if (itemCount >= LENGTH_TO_WIN){
                return true;
            }
        }
        return false;
    }

    private static boolean checkColum(char symbol) {
        int itemCount = 0;
        for (int i = 0; i < SIZE; i++) {
            if (MAP[i][lastTurnCol] == symbol) {
                itemCount++;
            } else itemCount =0;
            if (itemCount >= LENGTH_TO_WIN){
                return true;
            }
        }

        return false;
    }



    private static void computerTurn() {
        System.out.println("Computer turn!");
        int lineNumber;
        int colNumber;
        while (true){
            lineNumber = random.nextInt(SIZE);
            colNumber = random.nextInt(SIZE);
            if (ifCellFree(lineNumber, colNumber)){
                System.out.println("He goes to - " + (lineNumber + 1) +  " : " + (colNumber + 1));
                break;
            }
        }
        putTheDot(lineNumber, colNumber, DOT_AI);
        rememberTurn(lineNumber, colNumber);
    }



    private static void humanTurn() {
        System.out.println("Your turn!");
        int lineNumber;
        int colNumber;
        while (true){
            lineNumber = getNumberFromUser("line") - 1;
            colNumber = getNumberFromUser("colum") - 1;
            if (ifCellFree(lineNumber, colNumber)){
                break;
            }
            System.out.println("ERR: This cell is busy already, try again.");
        }
        putTheDot(lineNumber, colNumber, DOT_HUMAN);

        rememberTurn(lineNumber, colNumber);
    }

    private static void rememberTurn(int lineNumber, int colNumber) {
        turnsCount++;
        lastTurnLine = lineNumber;
        lastTurnCol = colNumber;
    }

    private static boolean ifCellFree(int lineNumber, int colNumber) {
        return MAP[lineNumber][colNumber] == DOT_EMPTY;
    }

    private static void putTheDot(int line, int col, char dot) {
        MAP[line][col] = dot;
    }

    private static int getNumberFromUser(String direction) {
        System.out.print("Enter " + direction + " number: ");
        while (true){
            if (in.hasNextInt()){
                int n = in.nextInt();
                if (isValidNumber(n)){
                    return n;
                }
            }
            else {
                in.next();
                System.out.print("ERR: Only integer alloyed, try again: ");
            }
        }
    }

    private static void init() {
        turnsCount = 0;
        SIZE = 0;
        SIZE = getMapSize();

        if (SIZE <= 5) {
            LENGTH_TO_WIN = 3;
        } else if (SIZE <= 9) {
            LENGTH_TO_WIN = 4;
        } else  {
            LENGTH_TO_WIN = 5;
            EXTRA_SPACE_MAP = " ";

        }
        System.out.println("Items to win is: "+ LENGTH_TO_WIN);


        MAP = new char[SIZE][SIZE];
        doMapEmpty();

    }

    private static void doMapEmpty() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static int getMapSize() {
        System.out.print("Enter map size: ");
        while (true){
         if (in.hasNextInt()){
             int n = in.nextInt();
             if (isValidMapSize(n)){
                 return n;
             }
         }
         else {
             in.next();
             System.out.print("ERR: Only integer alloyed, try again: ");
         }

        }
    }

    private static boolean isValidNumber(int n) {
      if (n >=1 && n<= SIZE) {
            return true;
        } else {
          System.out.print("ERR: Number must be from  " + 1 + " till " + SIZE + ", try again: ");
          return false;
      }

    }

    private static boolean isValidMapSize(int n) {
        if (n >= MIN_MAP_SIZE && n <= MAX_MAP_SIZE){
                return true;
            } else{
                System.out.print("ERR: Map size must be from  " + MIN_MAP_SIZE + " till " + MAX_MAP_SIZE + ", try again: ");
                return false;
            }
    }


    private static void printMap() {
        System.out.print(EXTRA_SPACE_MAP + HEADER_FIRST_SYMBOL + SPACE_MAP);
        for (int i = 0; i < SIZE; i++) {
            if (i <10) {
                System.out.print(i + 1 + SPACE_MAP + EXTRA_SPACE_MAP);
            } else {
                System.out.print(i + 1 + SPACE_MAP);
            }
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            String prefix;
            if (SIZE > 9 && i < 9 ) {
                prefix = " ";
            } else prefix = "";

            System.out.print(prefix + (i + 1) + SPACE_MAP + EXTRA_SPACE_MAP);

            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP + EXTRA_SPACE_MAP);
            }
            System.out.println();
        }
        System.out.println();
    }


}
