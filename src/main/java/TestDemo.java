import java.util.Random;

public class TestDemo {
	
	
	//If both parameters are positive (greater than zero, return the sum of the parameters. 
	//If either parameter is zero or negative, throw an IllegalArgumentException with the message
	public int addPositive(int a,int b) {
		if(a>0&&b>0)
			return a+b;
		else
			throw new IllegalArgumentException("Both parameters must be positive!");
	}
	
	//This method obtains a random int between 1 and 10 and then returns the square of the number
	public int randomNumberSquared() {
		int n = getRandomInt();
		return n*n;
		
	}
	
	//Generates random number between 1&10
	public int getRandomInt() {
		  Random random = new Random();
		  return random.nextInt(10) + 1;
		}

	
	
}
