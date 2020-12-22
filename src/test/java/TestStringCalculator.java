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
		Assert.assertEquals(test.Add("//;\n1;2;3;4;5"),15);	
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
	
	

}
