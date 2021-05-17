package ncontroller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;
import service.CustomerService;
import vo.Notice;

@Controller
@RequestMapping("/customer/")
public class CustomerController {
	public CustomerController() {
		// TODO Auto-generated constructor stub
		System.out.println("[CustomerController 생성자]");
	}
	private CustomerService customerservice;
	
	@Autowired
	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}
	
	private NoticeDao noticedao;
	
	
	//글 목록 조회
	@RequestMapping("notice.htm")
	public String notices(String pg , String f , String q, Model model) {
		
		List<Notice> list = customerservice.notices(pg, f, q);
		
		model.addAttribute("list", list); // 자동으로 notice.jsp forward
		
		return "customer/notice";
	}
	
	//글 상세 조회
	@RequestMapping("noticeDetail.htm")
	public String noticesDetail(String seq, Model model){
		
		Notice notice =  customerservice.noticeDetail(seq);
		model.addAttribute("notice", notice);
		return "customer/noticeDetail";
	}
	
	//글쓰기 화면(GET)
	@RequestMapping(value = "noticeReg.htm", method=RequestMethod.GET)
	public String noticeReg() {
		return "customer/noticeReg";
	}
	
	//글쓰기 처리(POST)
	@RequestMapping(value="noticeReg.htm",  method = RequestMethod.POST)
	public String noticeReg(Notice n , HttpServletRequest request) {
			String url=null;
			
			try {
				url = customerservice.noticeReg(n, request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				
			  return url;
		}
	
	//글수정하기(화면 > 데이터 뿌려주고)GET
	@RequestMapping(value = "noticeEdit.htm", method=RequestMethod.GET)
	public String noticeEdit(String seq, Model model) {
		
		Notice notice = null;
		try {
			notice = customerservice.noticeEdit(seq);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		model.addAttribute("notice", notice);
		
		return "customer/noticeEdit";
	}
	
	//굴수정(처리) POST
	@RequestMapping(value = "noticeEdit.htm", method=RequestMethod.POST)
	public String noticeEdit(Notice n,  HttpServletRequest request) throws ClassNotFoundException, IOException, SQLException {
		
		return customerservice.noticeEdit(n, request);
	}
	
	//글 삭제하기
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException {
	
		return customerservice.noticeDel(seq);
		
	}
	
	
	//파일 다운로드
	@RequestMapping("download.htm")
	public void download(String p, String f, HttpServletRequest request, HttpServletResponse response) throws IOException {
		customerservice.download(p, f, request, response);
	}
	
	
	
	
}
