package hello;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager.Log4jMarker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
public class TestLogExceptions {

    Logger logger = LogManager.getLogger();
    Marker mark = new Log4jMarker("FATAL");
	
	@Test
	public void test() {
//		log.error("class not found in classpath", new ClassNotFoundException("TestingApp"));
		
		logger.fatal(mark, "fatal error stopping");
	}
	
	@Test
	public void testWarn() {
		List<String> names = namesFromLibrary();
		names.get(0);
	}
	
	private static List namesFromLibrary() {
	    return Arrays.asList("Java", "Clojure");
	}
}
