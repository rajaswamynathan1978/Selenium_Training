package testNG_Examples;

import org.testng.annotations.Test;

public class DependencyTest {
			@Test(dependsOnMethods = { "method2" }) 
		public void method1() {
			System.out.println("This is method 1");
		}

		@Test
		public void method2() {
			System.out.println("This is method 2");
}
}
