package hello;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
public class GreetingIssueRestController {
				
	private static final String OPERATION_DONE_SUCCESSFULLY = "Operation done successfully ";

    private static Integer count = 0; 

	@GetMapping("/logs")
	public ResponseEntity<String> logs(HttpServletRequest httpServletRequest, @RequestParam("type") String type) {
		HttpStatus httpStatus = generateLogs(type);
		if (count == 0) {
			count = count + 1;
			return new ResponseEntity<>(OPERATION_DONE_SUCCESSFULLY, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (count == 10) {
			count = 0;
		} else {
			count = count + 1;
		}
		
		return new ResponseEntity<>(OPERATION_DONE_SUCCESSFULLY, httpStatus);
	}

	@GetMapping("/issue")
	public ResponseEntity<String> issueLogs(HttpServletRequest httpServletRequest, @RequestParam("type") String type){		
		HttpStatus httpStatus =  generateIssues(type);
		return new ResponseEntity<>(OPERATION_DONE_SUCCESSFULLY, httpStatus);
	}
	
	@GetMapping("/customlog")
	public ResponseEntity<String> customLogs(HttpServletRequest httpServletRequest, @RequestParam("type") String type, @RequestParam("msg") String msg) {
		customLogs(type, msg);
		return new ResponseEntity<>(OPERATION_DONE_SUCCESSFULLY,HttpStatus.OK);
	}
	
	private void customLogs(String type, String msg) {
        if(IssueMessageUtils.CRITICAL.equalsIgnoreCase(type)){
        	log.error("issuegen.bus.managed.beans.LogUtils - FATAL {}", msg);
            return;
        }
        
        if (IssueMessageUtils.DEBUG.equalsIgnoreCase(type)){
        	log.debug("issuegen.bus.managed.beans.LogUtils - {}", msg);
            return;
        }
        
        if (IssueMessageUtils.ERROR.equalsIgnoreCase(type)){
        	log.error("issuegen.bus.managed.beans.LogUtils - {}", msg);
           return;
        }
        
        if (IssueMessageUtils.WARN.equalsIgnoreCase(type)){
        	log.warn("issuegen.bus.managed.beans.LogUtils - {}", msg);
            return;
        }  
          
        log.info("issuegen.bus.managed.beans.LogUtils - {}", msg);
    }
	
	private HttpStatus generateLogs(String type) {
        if(IssueMessageUtils.CRITICAL.equalsIgnoreCase(type)){
        	log.error("issuegen.bus.managed.beans.MPayBusiness - FATAL rest call response is empty!");
            return HttpStatus.SERVICE_UNAVAILABLE;
        }
        
        if (IssueMessageUtils.DEBUG.equalsIgnoreCase(type)){
        	log.debug(IssueMessageUtils.getDebugMsg());
            return HttpStatus.OK;
        }
        
        if (IssueMessageUtils.ERROR.equalsIgnoreCase(type)){
        	log.error("issuegen.agent.util.method.MPayBusiness - Assert : userName is missing.");
           return HttpStatus.INSUFFICIENT_STORAGE;
        }
        
        if (IssueMessageUtils.WARN.equalsIgnoreCase(type)){
        	log.warn("issuegen.bus.managed.beans.MPayBusiness - Response is empty string. No data returned. SessionInfoCode value might be expired.");
            return HttpStatus.NO_CONTENT;
        }  
          
        log.info(IssueMessageUtils.getInfoMsg());
        return HttpStatus.OK;
    }
	
	private HttpStatus generateIssues(String type){
		
		if("DB_ERROR".equalsIgnoreCase(type)) {
			log.error(IssueMessageUtils.getDbError());
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
        
        if("OUT_OF_MEMORY".equalsIgnoreCase(type)) {
        	log.error("issuegen.bus.managed.beans.MPayBusiness - memory execeded", new OutOfMemoryError("GC overhead limit exceeded"));
        	return HttpStatus.INSUFFICIENT_STORAGE;
        }
        
        if("STACK_OVERFLOW_ERROR".equalsIgnoreCase(type)) {
        	log.error("issuegen.bus.managed.beans.MPayBusiness - stack overflow error occured", new StackOverflowError("Stack overflow occured"));
        	return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        
        if("FILE_NOT_FOUND".equalsIgnoreCase(type)) {
        	log.error("issuegen.bus.managed.beans.MPayBusiness - File not found", new FileNotFoundException("File not found"));
        	return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        
        if("ARRAY_INDEX_OUT_OF_BOUND".equalsIgnoreCase(type)) {
        	log.error("issuegen.bus.managed.beans.MPayBusiness - Array index out of range", new ArrayIndexOutOfBoundsException(6));
        	return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        
        if("NULL_POINTER".equalsIgnoreCase(type)) {
        	log.error("issuegen.bus.managed.beans.MPayBusiness - Null pointer exception occured", new NullPointerException());
        	return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        
        if("STRING_INDEX_OUT_OF_BOUND".equalsIgnoreCase(type)) {
        	log.error("issuegen.bus.managed.beans.MPayBusiness - String index out of range", new StringIndexOutOfBoundsException("String index out of range"));
        	return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        
        if("NO_CLASS_DEF_FOUND".equalsIgnoreCase(type)) {
        	log.error("issuegen.bus.managed.beans.SSOAgentFilter - No class def found", new NoClassDefFoundError("No class def found A"));
        	return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        
        if("NO_SUCH_METHOD_FOUND".equalsIgnoreCase(type)) {
        	log.error("issuegen.bus.managed.beans.MPayBusiness - No such method found", new NoSuchMethodError("Method not found"));
        	return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        
        if("NUMBER_FORMAT".equalsIgnoreCase(type)) {
        	log.error("issuegen.bus.managed.beans.JourneyPlannerMB - Number format exception occured", new NumberFormatException("Number format exception"));
        	return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        
        if("ILLEGAL_ARGUMENT".equalsIgnoreCase(type)) {
        	log.error("issuegen.bus.managed.beans.MPayBusiness - Illegal argument exception occured", new IllegalArgumentException("Illegal argument exception"));
        	return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        
        if("CLASS_NOT_FOUND".equalsIgnoreCase(type)){
        	log.error("issuegen.bus.managed.beans.MPayBusiness - class not found in classpath", new ClassNotFoundException("class not found in classpath"));
        	return HttpStatus.INTERNAL_SERVER_ERROR;
        } 
        
        return HttpStatus.OK;
    }
	
	@GetMapping("/warn")
	public ResponseEntity<String> warningLogs(HttpServletRequest httpServletRequest, @RequestParam("type") String issue){		
		generateWarning(issue);
		return new ResponseEntity<>(OPERATION_DONE_SUCCESSFULLY,HttpStatus.OK);
	}
	
	private void generateWarning(String type) {
		
		if("GARBAGE_COLLECTION".equalsIgnoreCase(type)) {
			log.warn("issuegen.bus.managed.beans.JourneyPlannerMB - Garbage collection takes too long");
			return;
		}
		
		if("DEPRECATED_API".equalsIgnoreCase(type)) {
			log.warn("issuegen.bus.managed.beans.MicroAppResponse - API WarningLogs is deprecated. It will be removed in future versions, use generateWarning API instead");
			return;
		}
		
		if("VERSION".equalsIgnoreCase(type)) {
			log.warn("issuegen.bus.managed.beans.MPayBusiness - Future versions will require Java 13; your Java version does not meet this requirement");
			return;
		}
		
		if("DB_WARN".equalsIgnoreCase(type)) {
			log.warn(IssueMessageUtils.getDbWarning());
		}
	}
}
