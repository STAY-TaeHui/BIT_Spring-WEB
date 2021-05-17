package kosta.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kosta.vo.Employee;


@Controller
public class AjaxController {

	//org.springframework.web.servlet.view.json.MappingJackson2JsonView
	//@Autowired
	//private View jsonview;
	
	@RequestMapping(value="response.kosta",method=RequestMethod.POST)
	public @ResponseBody Employee add(HttpServletRequest request, HttpServletResponse response)
	{//return type : Employee( JSON객체로 변환된 객체)
		//@ResponseBody가 있다면 메소드에서 리턴되는 값은 VIEW를 통하지 않는다.
		System.out.println("Response ");
		
		Employee employee = new Employee();
		employee.setFirstname(request.getParameter("firstName"));
		employee.setLastname(request.getParameter("lastName"));
		employee.setEmail(request.getParameter("email"));
		System.out.println(employee.getFirstname());
		return employee;  //{"firstname":"aa","lastname":"bb","email":"cc"}
	}
	
	@RequestMapping(value="response2.kosta",method=RequestMethod.POST)
	public @ResponseBody Employee add(@RequestBody Employee emp) //@RequestBody (비동기: 객체 형태로 받아요) 
	{								//RequestBody : 요청 파라미터를 객체로 받기
		System.out.println("response");
		System.out.println(emp.toString());
		
		return emp;
	}
	
	@RequestMapping(value="response3.kosta",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> Detail() //@RequestBody (비동기: 객체 형태로 받아요) 
	{ 	
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("result", "data");
		map.put("hello", "world");
		return map;
	}
	// {"result":"data","hello":"world"}
	
}

/*
public @ResponseBody Map<String,String> add(HttpServletRequest request, HttpServletResponse response)
{
	Map<String,String> map = new HashMap<>();
	map.put("result","success");
	return map;
}
*/


