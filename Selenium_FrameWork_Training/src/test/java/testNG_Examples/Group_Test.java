package testNG_Examples;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class Group_Test {
	
	@BeforeGroups(groups = { "Car" })
	public void BeforeGroupTest()
	{
		System.out.println("Before Group");
		
	}
	
	@AfterGroups(groups = { "Scooter" })
	public void AfterGroupTest()
	{
		System.out.println("After Group");
		
	}
	 
	  @Test (groups = { "Car" })
	 
	  public void Car1() {
	 
		  System.out.println("Batch Car - Test car 1");
	 
	  }
	 
	  @Test (groups = { "Car" })
	 
	  public void Car2() {
	 
		  System.out.println("Batch Car - Test car 2");
	 
	  }
	 
	  @Test (groups = { "Scooter" })
	 
	  public void Scooter1() {
	 
		  System.out.println("Batch Scooter - Test scooter 1");
	 
	  }
	 
	  @Test (groups = { "Scooter" })
	 
	  public void Scooter2() {
	 
		  System.out.println("Batch Scooter - Test scooter 2");
	 
	  }
	 
	  @Test (groups = { "Car", "Sedan Car" })
	 
	  public void Sedan1() {
	 
		  System.out.println("Batch Sedan Car - Test sedan 1");
	 
	  }
}