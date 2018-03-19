package testNG_Examples;

import org.testng.annotations.*;

public class PriorityTest {
	
		@Test(priority=5)
		public void test1() {
			System.out.println("priority 5 - test 1");
		}

		@Test(priority=3)
		public void test2() {
			System.out.println("priority 3 - test 2");
		}

		@Test(priority=4)
		public void test3() {
			System.out.println("priority 4 - test 3");
		}
		
		@Test(priority=1)
		public void test4() {
			System.out.println("priority 1 - test 4");
		}
		@Test(priority=2)
		public void test5() {
			System.out.println("priority 2 - test 5");
		}
}
