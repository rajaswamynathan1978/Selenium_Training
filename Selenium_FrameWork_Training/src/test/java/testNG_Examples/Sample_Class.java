package testNG_Examples;

import org.testng.annotations.Test;


public class Sample_Class {
	@Test(groups={"Sedan Car"})
	public void samples_() {
		System.out.println("I am from Sample Class - Sedan Car Group");

	}
	
	@Test(groups={"Scooter"})
	public void samples_1() {
		System.out.println("I am from Sample Class - Scooter Group");

	}

}
