package genericLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;

public class SetFireFoxProfile {
	
	public static FirefoxProfile FirefoxDriverProfile() throws Exception 
	{
		
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/config.properties");
		prop.load(input);
		FirefoxProfile simpleprofile = new FirefoxProfile();
		simpleprofile.setPreference("browser.download.folderList", 2);
		simpleprofile.setPreference("browser.download.manager.showWhenStarting", false);
		simpleprofile.setPreference("browser.download.dir", prop.getProperty("downloadPath"));
		simpleprofile.setPreference("browser.helperApps.neverAsk.openFile",
				"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		simpleprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		simpleprofile.setPreference("browser.helperApps.alwaysAsk.force", false);
		simpleprofile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		simpleprofile.setPreference("browser.download.manager.focusWhenStarting", false);
		simpleprofile.setPreference("browser.download.manager.useWindow", false);
		simpleprofile.setPreference("browser.download.manager.showAlertOnComplete", false);
		simpleprofile.setPreference("browser.download.manager.closeWhenDone", false);
		return simpleprofile;
	}

}
