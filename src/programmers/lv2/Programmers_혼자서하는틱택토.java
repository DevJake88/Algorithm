package programmers.lv2;

public class Programmers_혼자서하는틱택토 {
	public static void main(String[] args) {
		Programmers_혼자서하는틱택토 test = new Programmers_혼자서하는틱택토();
		String[] board = {"O.X", ".O.", "..X"};
		int result = test.solution(board);
		System.out.println(result);
	}
	
	public int solution(String[] board) {
        int answer = 1;
        int oSum = 0;
        int xSum = 0;
        
        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[i].length(); j++) {
        		char c = board[i].charAt(j);
        		if(c == 'O') oSum++; 
        		else if(c == 'X') xSum++;
        	}
        }
        
        // "O"를 표시할 차례인데 "X"를 표시
        // O의 갯수가 X보다 2개 더 많으면
        if(oSum > xSum + 1) return 0;
        
        // "X"를 표시할 차례인데 "O"를 표시
        // X의 갯수가 O보다 많으면
        if(xSum > oSum) return 0;
        
        // O가 이겼는데 게임이 진행된경우
        if(isWin(board, 'O') && oSum == xSum) return 0;
        
        // X가 이겼는데 게임이 진행된경우
        if(isWin(board, 'X') && oSum == xSum+1) return 0;
        
        return answer;
    }
	
	public boolean isWin(String[] board, char flag) {
		// 가로
		for(int i=0; i<3; i++) {
			if(board[i].charAt(0) == flag && board[i].charAt(1) == flag && board[i].charAt(2) == flag) {
				return true;
			}
		}
		
		// 세로
		for(int i=0; i<3; i++) {
			if(board[0].charAt(i) == flag && board[1].charAt(i) == flag && board[2].charAt(i) == flag) {
				return true;
			}
		}
		
		// 11시 대각선
		if(board[0].charAt(0) == flag && board[1].charAt(1) == flag && board[2].charAt(2) == flag) {
			return true;
		}
		
		// 1시 대각선
		if(board[0].charAt(2) == flag && board[1].charAt(1) == flag && board[2].charAt(0) == flag) {
			return true;
		}
		
		return false;
	}
}
