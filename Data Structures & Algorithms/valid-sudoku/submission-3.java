class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                if(board[r][c] == '.'){
                    continue;
                }
                
                int num = board[r][c] - '1'; //maps 1 - 9 to 0 based index
                int boxIndex = (r / 3) * 3 + (c / 3);

                if(row[r][num] || col[num][c] || box[boxIndex][num]){
                    return false;
                }

                row[r][num] = true;
                col[num][c] = true;
                box[boxIndex][num] = true;
            }
        }
        return true;
    }
}

/*
"For this specific 9×9 board, time and space are both O(1) since the size is fixed. But if we generalize to an N×N board, it becomes O(N²) time and O(N²) space, since we visit every cell once and the tracking arrays scale with the board size."
*/