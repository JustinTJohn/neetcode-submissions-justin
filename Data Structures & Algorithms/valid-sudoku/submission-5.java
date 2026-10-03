class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] row = new boolean[n][m];
        boolean[][] col = new boolean[n][m];
        boolean[][] box = new boolean[n][m];

        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(board[r][c] == '.'){
                    continue;
                }

                int num = board[r][c] - '1'; // to match with the box index 
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
//TC: O(n*m)
//SC: O(n*m)