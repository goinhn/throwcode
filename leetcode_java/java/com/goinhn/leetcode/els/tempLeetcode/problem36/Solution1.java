public class Solution1 {
    private char[] row = new char[9];
    private char[] col = new char[9];
    private char[] box = new char[9];

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            row = new char[9];
            col = new char[9];
            box = new char[9];

            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.' && row[Integer.parseInt(String.valueOf(board[i][j]))-1] == board[i][j]){
                    return false;
                }else if(board[i][j] != '.'){
                    row[Integer.parseInt(String.valueOf(board[i][j]))-1] = board[i][j];
                }

                if(board[j][i] != '.' && col[Integer.parseInt(String.valueOf(board[j][i]))-1] == board[j][i]){
                    return false;
                }else if(board[j][i] != '.'){
                    col[Integer.parseInt(String.valueOf(board[j][i]))-1] = board[j][i];
                }

                if(board[i/3+j%3][i*3+j%3] != '.' && box[i%3+(j%3)*3] == board[i/3+j%3][i*3+j%3]){
                    return false;
                }else if(board[i/3+j%3][i*3+j%3] != '.'){
                    box[i%3+(j%3)*3] = board[i/3+j%3][i*3+j%3];
                }
            }
        }

        return true;
    }

    public static void main(String[] args){
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(new com.goinhn.leetcode.Solution1().isValidSudoku(board));


    }
}