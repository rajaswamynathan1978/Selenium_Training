package testNG_Examples;

import org.testng.annotations.Test;

public class HelloWorld {

	@Test(groups={"Car"})
	public void testTestAnnotation() {

		System.out.println("Hello World From TestNG Annotation @Test");
		//throw new IllegalArgumentException("Final speed can not be less than zero");

	}

}