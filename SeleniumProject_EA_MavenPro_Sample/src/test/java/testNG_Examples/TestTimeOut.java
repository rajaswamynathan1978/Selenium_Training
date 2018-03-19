package testNG_Examples;

import org.testng.annotations.*;

public class TestTimeOut {

	@Test(timeOut = 5000) // time in mulliseconds
	public void testThisShouldPass() throws InterruptedException {
		Thread.sleep(4000);
	}

	@Test(timeOut = 5000)
	public void testThisShouldFail() {
		while (true);
	}

}