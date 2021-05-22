package ncontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import service.JoinService;
import vo.Emp;

@RestController
@RequestMapping("/joinus/")
public class AjaxController {
	 @Autowired
		private JoinService service;

	 Emp emp = new Emp();
	 
		@RequestMapping(value = "idcheck.do", method = RequestMethod.GET)
		public @ResponseBody int idCheck(@RequestParam("userid") String userid) {
		   System.out.println("This is idcheck.htm");
		   int result = service.idCheck(userid);
		   
		  

		   return result;

}
}
