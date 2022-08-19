package backtracking.medium;

public class WordSearch {

    private char[][] board = null;

    public boolean exist(char[][] b, String word) {
        this.board = b;

        for(int i =0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){

                if(backTrack(word,i,j, 0))                    {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean backTrack(String word, int row, int col, int index){

        if(index == word.length()){
            return true;
        }

        // Pair pair = new Pair(row, col);

        if(row <0 || row >= board.length
                ||col < 0 || col >= board[row].length
                || board[row][col]!='#'
                || board[row][col] != word.charAt(index)
        ){
            return false;
        }

        boolean top = false;
        boolean bottom = false;
        boolean left = false;
        boolean right = false;
        char c = board[row][col];
        // visited.add(pair);
        // if(row-1 >= 0 ){
        top = backTrack(word,row-1,col, index+1);


        // }

        // if(row+1 < board.length){
        bottom = backTrack(word, row+1, col, index+1);


        // }

        // if(col-1 >= 0 ){
        left = backTrack(word,row, col-1, index+1);


        // }

        // if(col+1 < board[row].length){
        right = backTrack(word, row, col+1, index+1);

        // }

        // visited.remove(pair);
        board[row][col] = c;


        return top||bottom||left||right;
    }

//      private boolean dfs(int r, int c, int i, int rows, int cols, char[][] board, String word){
//         if (i == word.length()) {
//             return true;
//         }
//         if (r < 0 || r >= rows || c < 0 || c >= cols || word.charAt(i) != board[r][c] ||
//                 board[r][c] == '#') {
//             return false;
//         }
//         char ch = board[r][c];
//         board[r][c] = '#';
//         boolean result;
//         result = dfs(r + 1, c, i + 1, rows, cols, board, word) ||
//                 dfs(r, c + 1, i + 1, rows, cols, board, word) ||
//                 dfs(r - 1, c, i + 1, rows, cols, board, word) ||
//                 dfs(r, c - 1, i + 1, rows, cols, board, word);
//         board[r][c] = ch;
//         return result;
//     }

//     public boolean exist(char[][] board, String word) {
//         int rows = board.length, cols = board[0].length;
//         for (int r = 0; r < rows; r++) {
//             for (int c = 0; c < cols; c++) {
//                 if (dfs(r,c, 0, rows, cols, board, word)) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
}
