package hello;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger; 

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
public class GreetingController {

    static PropertiesUtil proUtil = new PropertiesUtil(); 
    static Properties properties = proUtil.getInstance();
    Logger log= Logger.getLogger(this.class.getName()); 

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "delay", defaultValue = "0") Integer delay) {

        String query;
        StringBuffer sb = new StringBuffer();
        String query2;
        StringBuffer sb2 = new StringBuffer();

        ClassLoader cl = GreetingController.class.getClassLoader();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(cl.getResource("testpage.html").openStream()));
            while ((query = br.readLine()) != null)
                sb.append(query);
            br.close();

            if(delay > 0) {
            	Random r = new Random();
            	delay = r.nextInt((delay - delay/2) + 1) + delay/2;
                
                Thread.sleep(delay);
            }
            
            log.info("issuegen.agent.util.method.MPayBusiness - categoryOneServices start");
            String watchdog = properties.getProperty("app.dog.image");
            

            BufferedReader br2 = new BufferedReader(new InputStreamReader(cl.getResource(watchdog).openStream()));
            while ((query2 = br2.readLine()) != null)
                sb2.append(query2);
            br2.close();
            log.info("issuegen.agent.util.method.MPayBusiness - categoryOneServices end");

        } catch (Exception e) {
            log.error("issuegen.agent.util.method.MPayBusiness - error found", e);
        }
        return sb.length() > 0 ? sb.toString().replace("##dogimage##", sb2.toString()) : " No page found";
    }

    @RequestMapping("/barkingcats")
    public ResponseEntity barkingCatsCount(){
        try {
            calculateBarkingCats();
        } catch (Exception ex){
            log.error("issuegen.agent.util.method.MPayBusiness - error found while counting barking cats {}",ex.getMessage(),ex);
        }
        return new ResponseEntity("No Barking cats!", HttpStatus.BAD_REQUEST);
    }

    public int calculateBarkingCats(){
        throw new UnsupportedOperationException("Cats can not bark");
    }

    @RequestMapping("/issues")
    public ResponseEntity generateIssues(HttpServletRequest httpServletRequest, @RequestParam("issue") String issue){
            generateIssues(issue);
            return new ResponseEntity("Operation done successfully",HttpStatus.OK);
    }

    private void generateIssues(String issue){
        if("CRITICAL".equals(issue)){
            log.error("issuegen.agent.util.method.MPayBusiness - FATAL rest call response is empty!");
        } else if ("ERROR".equals(issue)){
           log.error("issuegen.agent.util.method.MPayBusiness - Assert : userName is missing.");
        } else if ("WARN".equals(issue)){
            log.warn("issuegen.agent.util.method.MPayBusiness - Response is empty string. No data returned. SessionInfoCode value might be expired.");
        } else if ("DEBUG".equals(issue)){
            log.debug(IssueMessageUtils.getDebugMsg());
        }else {
            log.info(IssueMessageUtils.getInfoMsg());
        }
    }


    @RequestMapping("/dogcount")
    public String dogCount() {
        log.info("issuegen.agent.util.method.MPayBusiness - pagerServices start");
        log.info("issuegen.agent.util.method.MPayBusiness - pagerServices end");
        return "{ \"dogCount\": 20 }";
    }

    @RequestMapping("/catcount")
    public String catCount() {
    	log.info("issuegen.agent.util.method.MPayBusiness - analyticServices start");
        log.info("issuegen.agent.util.method.MPayBusiness - analyticServices end");
        return "{ \"catCount\": 16 }";
    }
}
