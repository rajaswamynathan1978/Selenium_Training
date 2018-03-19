package log4j;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;

import org.apache.log4j.*;

public class LogLevel {
	   private static org.apache.log4j.Logger log = Logger.getLogger(LogLevel.class);
	   public static void main(String[] args) {
	      log.setLevel(Level.WARN);
	      
	      Handler handlerObj = new ConsoleHandler();
	      
	      //handlerObj.setLevel(WARN);
	      log.trace("Trace Message!");
	      log.debug("Debug Message!");
	      log.info("Info Message!");
	      log.warn("Warn Message!");
	      log.error("Error Message!");
	      log.fatal("Fatal Message!");
	   }
}
