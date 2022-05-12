package arrays.medium;

import java.util.HashSet;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if(board.length == 0){
            return false;
        }

        //init
        int len = board.length;
        // Note : HashSet integer array declaration don't declare
        //with generics
        HashSet<Character>[] rows = new HashSet[len];
        HashSet<Character>[] cols = new HashSet[len];
        HashSet<Character>[] box = new HashSet[len];

        for(int i=0; i< len; i++){
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            box[i] = new HashSet<Character>();
        }

        Character current = ' ';
        int currentBox = 0;
        for(int r=0; r<len; r++){
            for(int c= 0; c<len; c++){

                current = board[r][c];
                if( current == '.'){
                    continue;
                }

                if(rows[r].contains(current)){
                    return false;
                }
                rows[r].add(current);

                if(cols[c].contains(current)){
                    return false;
                }
                cols[c].add(current);

                /**
                 *  This formula is the key to remember or it helps
                 *  how to identify a square sub matrix / inner matrix
                 *  (m,m)overlayed
                 *  with outer matrix or super matrix(n,n)
                 *  where n > m
                 */
                currentBox = (r/3) * 3 + (c/3) ;

                if(box[currentBox].contains(current)){
                    return false;
                }
                box[currentBox].add(current);
            }
        }

        return true;
    }

}
