import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.*;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {

	//Object for my test
	private TestDemo testDemo = new TestDemo();
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	//Test for addPositive
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException)
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		else
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
	}

	//Test arguments for combos of a+b being postive, negative or zero
	public static Stream<Object> argumentsForAddPositive() {
		return Stream.of(
				arguments(2,4,6,false),
				arguments(0,0,0,true),
				arguments(22,0,22,true),
				arguments(0,34,34,true),
				arguments(-22,0,-22,true),
				arguments(0,-34,-34,true),
				arguments(-5,-8,-13,true),
				arguments(-2,10,8,true),
				arguments(11,-88,77,true)			
				);
	}
	
	@Test
	//Test for randomNumberSquared
	//Mock test using the random nubmer of 5
	void assertThatNumberSquaredIsCorrect() {
		//Mock the class, using spy method
		TestDemo mockDemo = spy(testDemo);
		
		//Return 5 as the random number. Mocking the method
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared=mockDemo.randomNumberSquared();
		
		//Test 5*5=25
		assertThat(fiveSquared).isEqualTo(25);
	}
	

}
