import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NegativeNumberException extends Exception {
	NegativeNumberException(String msg) {
		super(msg);
	}
}

public class StringCalculator {
	int add(String numbers) throws NegativeNumberException {
		boolean containsNegative = false;
		ArrayList<Integer> negativeNumbers = new ArrayList<>();
		int sum = 0;
		if(numbers == "") {
			return 0;
		} 
		
		String tokens[] = getTokens(numbers);
		if(tokens.length < 2) {
			return 0;
		} else {
			for(String number: tokens) {
				if(toNum(number) < 0) {
					containsNegative = true;
					negativeNumbers.add(toNum(number));
				} else {
					sum += toNum(number);	
				}
				
			}
		}
		if(containsNegative) {
			StringBuilder sb = new StringBuilder();
			sb.append("Exception - Negative number is not allowed");
			sb.append("\nThe Negative numbers are: ");
			
			// adding all negative numbers in the msg
			for(int negativeNum: negativeNumbers) sb.append(negativeNum + ","); 
			sb.deleteCharAt(sb.length() - 1); // to remove last comma
			throw new NegativeNumberException(sb.toString()); 
		}
		return sum;
	}

	private int toNum(String number) {
		return Integer.parseInt(number);
	}
	private String[] getTokens(String numbers) {
		// if custom delimiter is added in the line
		if(numbers.startsWith("//")) {
			// regex to divide delimiter and numbers
			Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(numbers);
			matcher.matches();
			String customDelimeter = matcher.group(1);
			numbers = matcher.group(2);
			return numbers.split(customDelimeter);
		} else { // default delimiter
			return numbers.split(",|\n");
		}
	}
	
}
