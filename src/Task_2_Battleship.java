import java.util.Scanner;

public class Task_2_Battleship {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please input a valid character: ");
		String input = scanner.next();
		char character = 0;
		
		if(!input.isEmpty()) {
			character = input.charAt(0);
		}
	
		boolean value = isValid(character);

		if(value) {
			System.out.println("VALID");
		}
		else {
			System.out.println("INVALID");
		}
		scanner.close();
	}
	
	static boolean isValid (char character) {
		
		if(character == '.' || character == 'S' || character == '*') {
			return true;
		}
		else return false;
	}

}
