import java.util.ArrayList;

public class Extra_question extends valid_board {
	public static void main(String[] args) {
		
		char[][] board = {
				{'.', '.', '.', 'S', 'S', '*', '*', '.', 'S', 'S'},
				{'.', '.', '.', 'S', 'S', '.', '.', '.', 'S', 'S'},
				{'.', '.', 'S', 'S', 'S', '*', '*', '.', '.', '.'},
				{'.', '.', '.', '*', '*', '*', '*', '.', '*', '*'},
				{'.', '.', '.', 'S', 'S', '.', '.', '.', 'S', 'S'},
				{'.', '.', 'S', '*', 'S', '*', '*', '.', '.', '.'},
				{'.', '.', '.', 'S', 'S', 'S', '*', '.', 'S', 'S'},
				{'.', '.', '.', 'S', 'S', 'S', '.', '.', '*', 'S'},
				{'.', '.', 'S', 'S', 'S', '*', '*', '.', '.', '.'},
				{'.', '*', '*', '*', '*', '.', '.', '.', '.', '.'}
		};
		
		String[] ship_type = {"Carrier", "Battleship", "Cruiser", "Destroyer"};
		
	
		
		ArrayList<Double> damage_report = damageReport(board);
		
		if (damage_report == null) {												// error message
		    System.out.println("The board is invalid");
		} else {
		    for (int i = 0; i < damage_report.size(); i++) {
		    	
		    	Double damage = damage_report.get(i);
		        String ship = ship_type[i];
		        
		        if (damage == null) {												// error message
		            System.out.println("No ship has found on the board");
		        } else {
		            System.out.println(ship + " average damage: " + damage + "%");
		        }
		    }
		}
	}
	
	// ship damage report 
	static ArrayList<Double> damageReport(char[][] board) {
		
		ArrayList<Double> damage = new ArrayList<>();
		
		int board_validation = boardValidation(board);									// inherit from valid_board

		if(board_validation != 0) {														// for valid board, boardValidation() the return value will be 0
			return null;
		}
		
		int carrier_ships = 0, battleship_ships = 0, cruiser_ships = 0, destroyer_ships = 0;
		double carrier_damage = 0, battleship_damage=0, cruiser_damage = 0, destroyer_damage = 0;
		double carrier_AvgDamage = 0, battleship_AvgDamage=0, cruiser_AvgDamage = 0, destroyer_AvgDamage = 0;
		
		boolean shipFound = false;
		
		
		for(int i=0; i<board.length; i++) {
			int j=0;
			while(j<board[i].length) {
				
				if(board[i][j] == 'S' || board[i][j] == '*') {
					shipFound = true;
					int start = j;
					String ship = " ";

					while(j < board[i].length && (board[i][j] == 'S' || board[i][j] == '*')) {
						ship += board[i][j];
						j++;
					}
					
					int end = j-1;
					int shipLength = end - start + 1;
					
					// count each ship types and their total individual damage
					if(shipLength == 5) {
						carrier_ships++;
						carrier_damage += damageCount(ship, 5);
					}
					else if (shipLength == 4) {
						battleship_ships++;
						battleship_damage += damageCount(ship, 4);
					}
					else if (shipLength == 3) {
						cruiser_ships++;
						cruiser_damage += damageCount(ship, 3);
					}
					else if (shipLength == 2) {
						destroyer_ships++;
						destroyer_damage += damageCount(ship, 2);
					}
				}
				else {
					j++;
				}
			}
		}
		
		// no ship on the board
		if(!shipFound) {
			damage.add(null);
		}
		
		
		// count the average damage of all individual ships
		if(carrier_ships != 0) {
			carrier_AvgDamage = carrier_damage / carrier_ships;
		} 
		else carrier_AvgDamage = 0;
		
		if(battleship_ships != 0) {
			battleship_AvgDamage = battleship_damage / battleship_ships;
		} 
		else battleship_AvgDamage = 0;
		
		if(cruiser_ships != 0) {
			cruiser_AvgDamage = cruiser_damage / cruiser_ships;
		} 
		else cruiser_AvgDamage = 0;
		
		if(destroyer_ships != 0) {
			destroyer_AvgDamage = destroyer_damage / destroyer_ships;
		} 
		else destroyer_AvgDamage = 0;
		
		// add all average damage to the damage
		damage.add(Double.parseDouble(String.format("%.2f", carrier_AvgDamage)));
		damage.add(Double.parseDouble(String.format("%.2f", battleship_AvgDamage)));
		damage.add(Double.parseDouble(String.format("%.2f", cruiser_AvgDamage)));
		damage.add(Double.parseDouble(String.format("%.2f", destroyer_AvgDamage)));
		
		
		return damage;
	}
	
	// to count individual ship damage
	static double damageCount(String ship, int shipLength) {
		
		double totalDamage=0;
		int damagePart = 0;
		
		for(int i=0; i<ship.length(); i++) {
			if(ship.charAt(i) == '*') {
				damagePart++;
			}
		}
		
		totalDamage = ((double) damagePart / shipLength) * 100;
		return totalDamage;
	}
	
}
