class Solution {
    public boolean isValidSudoku(char[][] board) {
        //Row
        for(int row = 0; row < board.length; row++){
            HashSet<Character> seen = new HashSet<>();
            for(int col = 0; col <board[0].length; col++){              
                if(board[row][col] == '.')continue;
                if(seen.contains(board[row][col])){
                    return false;
                }
                seen.add(board[row][col]);
            }
        }
        //Col
        for(int col = 0; col < board[0].length; col++){
            HashSet<Character> seen = new HashSet<>();
            for(int row = 0; row <board.length; row++){              
                if(board[row][col] == '.')continue;
                if(seen.contains(board[row][col])){
                    return false;
                }
                seen.add(board[row][col]);
            }
        }
        //Box
        for(int i = 0; i < 9; i++){
            HashSet<Character> seen = new HashSet<>();
            for(int row = 0; row < 3; row++){
                for(int col = 0; col < 3; col++){
                    int row_ = row + (i/3)*3;
                    int col_ = col + (i%3)*3;
                    if(board[row_][col_] == '.')continue;
                    if(seen.contains(board[row_][col_]))return false;
                    seen.add(board[row_][col_]);
                }
            }
        }
        return true;
    }
}
