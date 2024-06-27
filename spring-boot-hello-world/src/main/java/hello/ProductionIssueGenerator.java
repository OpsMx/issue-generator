package hello;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@Controller
public class ProductionIssueGenerator {

	@GetMapping("/")
	public String classNotFound(HttpServletRequest httpServletRequest){		
		return "issuegenerator.html";
	}
}
