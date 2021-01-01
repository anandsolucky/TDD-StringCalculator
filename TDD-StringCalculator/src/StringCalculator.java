import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	int add(String numbers) {
		int sum = 0;
		if(numbers == "") {
			return 0;
		} else {
			String tokens[] = getTokens(numbers);
			if(tokens.length < 2) {
				return 0;
			} else {
				for(String number: tokens) {
					sum += toNum(number);
				}
			}
			return sum;
		}
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
