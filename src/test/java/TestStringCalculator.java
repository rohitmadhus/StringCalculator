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
	

}
