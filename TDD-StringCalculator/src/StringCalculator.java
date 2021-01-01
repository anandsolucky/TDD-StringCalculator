
public class StringCalculator {
	int add(String numbers) {
		int sum = 0;
		if(numbers == "") {
			return 0;
		} else {
			String tokens[] = numbers.split(",|\n");
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
	
}
