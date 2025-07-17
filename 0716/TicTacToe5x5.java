import java.util.Scanner;

public class TicTacToe5x5 {
    private static final int BOARD_SIZE = 5;
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    
    private char[][] board;
    private char currentPlayer;
    private Scanner scanner;
    
    public TicTacToe5x5() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        currentPlayer = PLAYER_X;
        scanner = new Scanner(System.in);
        initializeBoard();
    }
    
    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }
    
    private void printBoard() {
        System.out.println();
        System.out.print("  ");
        for (int j = 0; j < BOARD_SIZE; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private boolean isValidMove(int row, int col) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
            System.out.println("錯誤：座標超出範圍，請輸入 0-4 之間的數字。");
            return false;
        }
        
        if (board[row][col] != EMPTY) {
            System.out.println("錯誤：此位置已被佔用，請選擇其他位置。");
            return false;
        }
        
        return true;
    }
    
    private void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
        System.out.println("玩家 " + currentPlayer + " 在位置 (" + row + ", " + col + ") 放置棋子");
    }
    
    private boolean checkWin() {
        // 檢查行
        for (int i = 0; i < BOARD_SIZE; i++) {
            boolean win = true;
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] != currentPlayer) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        
        // 檢查列
        for (int j = 0; j < BOARD_SIZE; j++) {
            boolean win = true;
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (board[i][j] != currentPlayer) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        
        // 檢查主對角線
        boolean win = true;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][i] != currentPlayer) {
                win = false;
                break;
            }
        }
        if (win) return true;
        
        // 檢查反對角線
        win = true;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][BOARD_SIZE - 1 - i] != currentPlayer) {
                win = false;
                break;
            }
        }
        if (win) return true;
        
        return false;
    }
    
    private boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void switchPlayer() {
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }
    
    public void playGame() {
        System.out.println("=== 5x5 井字遊戲 ===");
        printBoard();
        
        while (true) {
            System.out.print("玩家 " + currentPlayer + " 請輸入位置 (row col): ");
            
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                
                if (isValidMove(row, col)) {
                    makeMove(row, col);
                    printBoard();
                    
                    if (checkWin()) {
                        System.out.println("玩家 " + currentPlayer + " 獲勝！");
                        break;
                    }
                    
                    if (isBoardFull()) {
                        System.out.println("平手！");
                        break;
                    }
                    
                    switchPlayer();
                }
            } catch (Exception e) {
                System.out.println("錯誤：請輸入有效的整數。");
                scanner.nextLine(); // 清除輸入緩衝區
            }
        }
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        TicTacToe5x5 game = new TicTacToe5x5();
        game.playGame();
    }
}