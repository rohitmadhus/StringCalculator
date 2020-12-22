import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStringCalculator {
	private StringCalculator test;
  
	@Before
	public void setUp() {
		test = new StringCalculator();
	}
	
	@Test
	public void emptyInput() {
		Assert.assertEquals(test.Add(" "),0);
		
	}
	
	@Test
	public void oneOperand() {
		Assert.assertEquals(test.Add("1"),1);	
	}
	@Test
	public void twoOperand() {
		Assert.assertEquals(test.Add("1,2"),3);
		
	}
	@Test
	public void multipleOperand() {
		Assert.assertEquals(test.Add("1,2,3,4,5,6,7,8,9,10"),55);	
	}
	@Test
	public void withDynamicDelimiter() {
		Assert.assertEquals(test.Add("//;\n1"),1);	
	}
	@Test
	public void withDynamicDelimiterWithMultipleOperator() {
		Assert.assertEquals(test.Add("//;\n1;2;3;4;5;1001"),15);	
	}
	@Test
	public void withDefaultDelimiter() {
		Assert.assertEquals(test.Add("1;2;3;4;5"),15);	
	}
	@Test
	public void withDynamicDelimiterGreaterThan() {
		Assert.assertEquals(test.Add("//>\n1>2>3>4>5"),15);	
	}
	@Test
	public void withDynamicDelimitersingleOperand() {
		Assert.assertEquals(test.Add("//>\n1"),1);	
	}
	
	@Test(expected = MyException.class)
	public void negativeSingleOperand() {
		test.Add("-1");	
	}
	
	@Test(expected = MyException.class)
	public void negativeMultipleOperand() {
		test.Add("5,-1,-8,9,7");	
	}
	
	@Test(expected = MyException.class)
	public void negativeMultipleOperandWithdelimiter() {
		test.Add("//>\n1>2>-3>4>5");	
	}
	@Test
	public void greaterWithOneOperandWithDelimiter() {
		Assert.assertEquals(test.Add("//>\n1001"),0);	
	}
	@Test
	public void greaterWithOneOperandWithDelimiterWithNoOperand() {
		Assert.assertEquals(test.Add("//>\n"),0);	
	}
	@Test
	public void greaterWithOneOperand() {
		Assert.assertEquals(test.Add("1001"),0);	
	}
	@Test
	public void delimiterSetWithSingleOperand() {
		Assert.assertEquals(test.Add("//[***]\n1"),1);	
	}

	@Test
	public void delimiterSetWithOperands() {
		Assert.assertEquals(test.Add("//[***]\n1***2***3"),6);	
	}
	
	@Test(expected = MyException.class)
	public void delimiterSetWithNegativeOperands() {
		test.Add("//[***]\n1***-2***3");
	}
	@Test
	public void delimiterSetWithNoOperands() {
		Assert.assertEquals(test.Add("//[***]\n"),0);	
	}
	@Test
	public void delimiterSetWithNoOperandsAndNoNextLine() {
		Assert.assertEquals(test.Add("//[***]"),0);	
	}
	@Test
	public void multipleDelimiterWithMultipleOperands() {
		Assert.assertEquals(test.Add("//[*][%]\n1*2%3"),6);	
	}
	@Test
	public void multipleDelimiterDifferentSetsWithMultipleOperands() {
		Assert.assertEquals(test.Add("//[****][%][$$$]\n1****2$$$3"),6);	
	}
	@Test(expected = MyException.class)
	public void multipleDelimiterDifferentSetsWithMultipleOperandsNegativeValue() {
		test.Add("//[****][%][$$$]\n1****-2$$$3");
	}
	@Test
	public void multipleDelimiterDifferentSetsWithMultipleOperandsValueAbovethousand() {
		Assert.assertEquals(test.Add("//[****][%][$$$]\n1002****2$$$3"),5);	
	}
	
	
	


}
