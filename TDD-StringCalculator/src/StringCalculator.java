
public class StringCalculator {
	int add(String numbers) {
		if(numbers == "") return 0;
		else {
			String tokens[] = numbers.split(",");
			if(tokens.length < 2) return 0;
			else {
				return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[1]);
			}
		}
	}
}
