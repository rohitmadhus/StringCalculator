
public class StringCalculator {
	
	public int Add(String numbers) {
		int sum = 0;
		String[] operands;
		if(numbers.trim().length() == 0) {
			return 0;
		}
		else if(numbers.length()>=2 && numbers.trim().subSequence(0,2).equals("//")) {
			char delimiter = numbers.trim().charAt(2);
			operands = numbers.trim().substring(4).split(Character.toString(delimiter));

		}
		else if(numbers.contains(",")) {
		    operands = numbers.trim().split(",");
		}
		else if(numbers.contains(";")) {
		    operands = numbers.trim().split(";");
		}
		else {
			return Integer.parseInt(numbers.trim());
		}	
		for(int i=0;i<operands.length;i++) {
			sum = sum + Integer.parseInt(operands[i].trim());
		}
		return sum;
	}


}
