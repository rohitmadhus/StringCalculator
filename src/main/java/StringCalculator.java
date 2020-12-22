import java.util.ArrayList;

public class StringCalculator {
	
	public String FindDelimiters(String numbers){
		ArrayList<String> arr = new ArrayList<String>();
		String regexChar = "*+?^$";

		StringBuffer s = new StringBuffer();
		for(int i=2;i<= numbers.indexOf("\n");i++ ){
			if(numbers.charAt(i)=='[') {
				s.setLength(0);
				for(int j=i+1;j<=numbers.indexOf("\n");j++) {
					if(numbers.charAt(j)==']') {
						break;
					}
					if(regexChar.contains(Character.toString(numbers.charAt(j)))) {
						s.append("\\");
					}
					s.append(numbers.charAt(j));
				}
				arr.add(s.toString().trim());
				i = i + s.length()-1;
			}			
		}
		s.setLength(0);
	    for (int counter = 0; counter < arr.size(); counter++) { 
	        s = s.append(arr.get(counter));
	        if(counter != arr.size()-1 ){
	            s = s.append('|');
	        }
	       		
	    } 
		return s.toString();	
	}
	
	public int Add(String numbers) {
		int sum = 0;
		int count = 0;
		ArrayList<Integer> negtiveNumbers = new ArrayList<Integer>();
		String[] operands;
		if(numbers.trim().length() == 0 || !((int)numbers.trim().charAt(numbers.trim().length()-1) >= 48 && (int)numbers.trim().charAt(numbers.trim().length()-1) <= 57)) {
			return 0;
		}
		else if(numbers.length()>=2 && numbers.trim().subSequence(0,2).equals("//")) {
			String delimiter;
			int i = numbers.indexOf("\n");
			if(numbers.charAt(2) == '[' && numbers.charAt(3) != '\\' && numbers.charAt(4) != 'n') {
				delimiter = FindDelimiters(numbers);			
			}
			else {
				delimiter = Character.toString(numbers.trim().charAt(2));				
			}
			operands = numbers.trim().substring(i+1).split(delimiter);
		    
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
