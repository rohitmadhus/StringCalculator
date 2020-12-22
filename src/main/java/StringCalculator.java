import java.util.ArrayList;

public class StringCalculator {
	
	public int Add(String numbers) {
		int sum = 0;
		int count = 0;
		ArrayList<Integer> negtiveNumbers = new ArrayList<Integer>();
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
			operands = new String[] {numbers.trim()};
		}
		
		try {
		for(int i=0;i<operands.length;i++) {	
			if(Integer.parseInt(operands[i].trim()) < 0) {
			negtiveNumbers.add(Integer.parseInt(operands[i].trim()));
			count++;
			}
			else if(Integer.parseInt(operands[i].trim()) > 1000) {
				operands[i] = "0";
			}
			else {
			sum = sum + Integer.parseInt(operands[i].trim());
			}
		}
		if(count >= 1) {
			throw new MyException("negatives not allowed" + negtiveNumbers);
		}
		}
		catch(MyException e) {
			System.out.println(e.getMessage()); 	
		}
		return sum;
	}


}
