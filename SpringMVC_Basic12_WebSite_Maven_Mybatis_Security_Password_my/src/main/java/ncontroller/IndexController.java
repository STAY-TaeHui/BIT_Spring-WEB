package ncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index.htm")
	public String index() {
		System.out.println("THIS IS INDDEX");
		return "index";   //  /WEB-INF/views/index.jsp

	}
}
