
public class StringCalculator {
	
	public int Add(String numbers) {
		int sum = 0;
		if(numbers.trim().length() == 0) {
			return 0;
		}
		String[] operands = numbers.trim().split(",");
		for(int i=0;i<operands.length;i++) {
			sum = sum + Integer.parseInt(operands[i].trim());
		}
		return sum;
	}

}
