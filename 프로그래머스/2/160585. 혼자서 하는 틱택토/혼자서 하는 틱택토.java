class Solution {
    
    static int cntO;
    static int cntX;
    static boolean O;
    static boolean X;
    
    public int solution(String[] board) {
        int answer = -1;
        
        countOX(board);
        check(board);
        
        
        if(O==true && X==true) return 0;
        else if(O == true && X != true){
            int chk = cntO - cntX;
            if(chk == 1) return 1;
            else return 0;
        }
        else if(O!=true && X == true){
            int chk = cntX - cntO;
            if(chk == 0) return 1;
            else return 0;
        }
        else if(O != true && X != true){
            if(cntO == cntX) return 1;
            if(cntO-cntX == 1) return 1;
            else return 0;
        }
        
        
        
        return answer;
    }
    
    static void check(String[] board){
        if(board[0].charAt(0)=='O'&& board[0].charAt(1)=='O' && board[0].charAt(2)=='O') O = true;
         if(board[1].charAt(0)=='O'&& board[1].charAt(1)=='O' && board[1].charAt(2)=='O') O = true;
         if(board[2].charAt(0)=='O'&& board[2].charAt(1)=='O' && board[2].charAt(2)=='O') O = true;
         if(board[0].charAt(0)=='O'&& board[1].charAt(0)=='O' && board[2].charAt(0)=='O') O = true;
         if(board[0].charAt(1)=='O'&& board[1].charAt(1)=='O' && board[2].charAt(1)=='O') O = true;
         if(board[0].charAt(2)=='O'&& board[1].charAt(2)=='O' && board[2].charAt(2)=='O') O = true;
         if(board[0].charAt(0)=='O'&& board[1].charAt(1)=='O' && board[2].charAt(2)=='O') O = true;
         if(board[0].charAt(2)=='O'&& board[1].charAt(1)=='O' && board[2].charAt(0)=='O') O = true;
        
        
        if(board[0].charAt(0)=='X'&& board[0].charAt(1)=='X' && board[0].charAt(2)=='X') X = true;
         if(board[1].charAt(0)=='X'&& board[1].charAt(1)=='X' && board[1].charAt(2)=='X') X = true;
         if(board[2].charAt(0)=='X' && board[2].charAt(1)=='X' && board[2].charAt(2)=='X') X = true;
         if(board[0].charAt(0)=='X'&& board[1].charAt(0)=='X' && board[2].charAt(0)=='X') X = true;
         if(board[0].charAt(1)=='X'&& board[1].charAt(1)=='X' && board[2].charAt(1)=='X') X = true;
         if(board[0].charAt(2)=='X'&& board[1].charAt(2)=='X' && board[2].charAt(2)=='X') X = true;
         if(board[0].charAt(0)=='X'&& board[1].charAt(1)=='X' && board[2].charAt(2)=='X') X = true;
         if(board[0].charAt(2)=='X'&& board[1].charAt(1)=='X' && board[2].charAt(0)=='X') X = true;
        
        
        
    }
    
    static void countOX(String[] board){
        
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length(); j++){
                if(board[i].charAt(j) == 'O') cntO++;
                if(board[i].charAt(j) == 'X') cntX++;
            }
        }
        
        
        
    }
    
    
}