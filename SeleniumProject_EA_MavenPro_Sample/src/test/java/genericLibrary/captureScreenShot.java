package genericLibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import stepDefinition.FaceBook;

public class captureScreenShot extends FaceBook {
	final static Logger mylog = Logger.getLogger("abc");
	public static void captureScreenShot_(String methodName)
	{
		 File scrFile = ((TakesScreenshot)FaceBook.e_driver).getScreenshotAs(OutputType.FILE);
            try {
				FileUtils.copyFile(scrFile, new File(FaceBook.screenShotFolderPath+methodName+".png"));
				mylog.info("***Placed screen shot in "+FaceBook.screenShotFolderPath+methodName+" ***");
				//FaceBook.e_driver.close();
			} catch (IOException e) {
				mylog.info(e.getMessage());
				e.printStackTrace();
			}
		
	}

}
