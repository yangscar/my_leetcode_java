public class Solution {
    public void solve(char[][] board) {
        if (board.length < 1) return;
        final int m = board.length;
        final int n = board[0].length;
        Deque<Pos> stack = new ArrayDeque<Pos>();
        
        for (int i = 0; i < m; ++i){
            stack.offerLast(new Pos(i,0));
            stack.offerLast(new Pos(i,n-1));
        }
        
        for (int i = 0; i < n; ++i){
            stack.offerLast(new Pos(0,i));
            stack.offerLast(new Pos(m-1,i));
        }
       
        while(!stack.isEmpty()){
            Pos pos = stack.removeFirst();// or removeLast(); Both are OK!
            int x = pos.x;
            int y = pos.y;
            if (isOutOfBound(x,y,m,n) || board[x][y] != 'O') continue;
            board[x][y] ='+';
            stack.offerLast(new Pos(x-1,y));
            stack.offerLast(new Pos(x+1,y));
            stack.offerLast(new Pos(x,y-1));
            stack.offerLast(new Pos(x,y+1));
        } 
        
        
        for (int i=0; i<m; ++i)
            for (int j=0; j<n; ++j){
                if (board[i][j] =='O')
                    board[i][j]='X';
                else if (board[i][j]=='+')
                    board[i][j]='O';
            }
        
        
    }
    
    
    
    private boolean isOutOfBound(int x, int y, int rows, int columns){
        return x < 0 || y< 0 || x >= rows || y >=columns;
    }
    private class Pos {
        int x;
        int y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
