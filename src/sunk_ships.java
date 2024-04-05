
public class sunk_ships {

	public static void main(String[] args) {
		
		char[][] board = {
				{'.', '.', 'S', 'S', 'S', '.', '.', '*', '*', '*'},
			    {'.', '.', '.', '*', '*', '*', '.', '.', '.', '.'},
			    {'.', '.', '.', '.', '*', '*', '.', '*', 'S', 'S'},
			    {'.', 'S', '*', '.', '.', '.', '.', '.', '.', '.'},
			    {'.', '.', '.', '.', '.', 'S', 'S', '*', 'S', '.'},
			    {'.', '.', '.', '*', '*', '*', '*', '.', '.', '.'},
			    {'.', '*', '*', '.', '.', '.', '*', 'S', 'S', '*'},
			    {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
			    {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
			    {'.', '.', '.', 'S', '*', '*', '.', '.', '.', '.'}
		};
		
		int number_sunk = sunk_ship(board);
		System.out.println("The number of sunk ships is: " + number_sunk);

	}

	private static int sunk_ship(char[][] board) {
		
		int number_sunk = 0;
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				
				if(board[i][j] == '*') {
					
					char previous_char = (j > 0) ? board[i][j - 1] : '.';				// access previous char
					
					if(previous_char == '.') {
						
						while((j+1) < board[i].length && (board[i][j + 1] == '*' || board[i][j + 1] == '.')) {
							
							char next_char = ((j+1) < board[i].length) ? board[i][j + 1] : '.';			// get next character of the board
							
							if(next_char == '.' || (next_char == '*' && (j+1) == board[i].length-1)) {
								number_sunk++;
								break;																	// increase the number of sunk ships and break from the loop
							}
							j++;
						}
						
					}
				}
				
			}
		}
		
		return number_sunk;
	}

}
