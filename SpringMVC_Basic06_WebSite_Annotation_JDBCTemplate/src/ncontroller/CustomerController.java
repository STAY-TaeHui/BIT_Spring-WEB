package ncontroller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;
import vo.Notice;

@Controller
@RequestMapping("/customer/")
public class CustomerController {
	public CustomerController() {
		// TODO Auto-generated constructor stub
		System.out.println("[CustomerController 생성자]");
	}
	
	private NoticeDao noticedao;
	
	@Autowired
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	
	/*
	  1. method안에서 return type [String] >> 리턴값이 뷰의 주소
	  
	  2. public ModelAndView notices .... > ModelAndView 객체 생성 > 데이터, 뷰 설정 > return 
	  
	  3. public String notices(Model model) >> 내부적으로 Model객체의 주소가 들어온다. >> Model을 통해 forward를 할수 있다.
	  
	  
	
	*/
	
	/*
	@RequestMapping("/customer/notice.htm")                             // /customer/notice.htm?pg=1&f="title"
	public ModelAndView notices(String pg , String f , String q) {
		
		//default 값 설정
		int page = 1;
		String field="TITLE";
		String query = "%%";
		
		if(pg != null   && ! pg.equals("")) {
			page  = Integer.parseInt(pg);
		}
		
		if(f != null   && ! f.equals("")) {
			field = f;
		}

		if(q != null   && ! q.equals("")) {
			query = q;
		}
		
		//DAO 작업
		List<Notice> list = null;
		try {
						list = noticedao.getNotices(page, field, query);
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		} catch (SQLException e) {
					e.printStackTrace();
		}
		
		
		//Spring  적용
		ModelAndView   mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("notice.jsp");
		return mv;
	}
	*/
	/*
	@RequestMapping("customer/notice.htm")
	public ModelAndView notices(@RequestParam(value ="pg",defaultValue = "1")String pg,
			@RequestParam(value = "f", defaultValue = "Title") String title,
			@RequestParam(value = "p", defaultValue = "%%") String p) throws ClassNotFoundException, SQLException {
		
		 List<Notice> list = noticedao.getNotices(Integer.parseInt(pg),title, p);
		 
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("list", list);
		 mv.setViewName("notice.jsp");
		return mv;
	}*/
	
	@RequestMapping("notice.htm")
	public String notices(String pg , String f , String q, Model model) {
		
		//default 값 설정
		int page = 1;
		String field="TITLE";
		String query = "%%";
		
		if(pg != null   && ! pg.equals("")) {
			page  = Integer.parseInt(pg);
		}
		
		if(f != null   && ! f.equals("")) {
			field = f;
		}

		if(q != null   && ! q.equals("")) {
			query = q;
		}
		
		//DAO 작업
		List<Notice> list = null;
		try {
						list = noticedao.getNotices(page, field, query);
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		} catch (SQLException e) {
					e.printStackTrace();
		}
		
		
//		//Spring  적용
//		ModelAndView   mv = new ModelAndView();
//		mv.addObject("list", list);
//		mv.setViewName("notice.jsp");
//		return mv;
		model.addAttribute("list", list); // 자동으로 notice.jsp forward
		
		return "notice.jsp";
	}
	
	@RequestMapping("noticeDetail.htm")
	public String noticesDetail(String seq, Model model) throws ClassNotFoundException, SQLException {
		Notice notice = noticedao.getNotice(seq);
		System.out.println("This is noticeDetail.htm입니당");
//		ModelAndView mv = new ModelAndView();
//		
//		mv.addObject("notice", notice);
//		mv.setViewName("noticeDetail.jsp");
		
		model.addAttribute("notice",notice);
		return "noticeDetail.jsp";
	}
	
	//글쓰기 화면(GET)
	@RequestMapping(value = "noticeReg.htm", method=RequestMethod.GET)
	public String noticeReg() {
		return "noticeReg.jsp";
	}
	
	//글쓰기 처리(POST)
		@RequestMapping(value="noticeReg.htm",  method = RequestMethod.POST)
		public String noticeReg(Notice n , HttpServletRequest request) {
			  // System.out.println(n.toString());
			  // Notice  >> DTO
			  // private List<CommonsMultipartFile>   files
			
			 //files[0]     >>1.jpg
			 //files[1]     >>2.jpg
			
			 List<CommonsMultipartFile> files = n.getFiles();
			 List<String> filenames = new ArrayList<String>();  //파일명 관리
			
			if(files != null  && files.size() > 0) {  //1개라 업로드된 파일이 존재하면
					for(CommonsMultipartFile  mutifile  : files) {
						String filename =  mutifile.getOriginalFilename();
						String path = request.getServletContext().getRealPath("/customer/upload"); //배포된 서버 경로 
						String fpath = path + "\\" + filename;
						System.out.println(fpath);
						
						if(!filename.equals("")) {  //실 파일 업로드 (웹서버)
							FileOutputStream fs =null;
							try {
								     fs = new FileOutputStream(fpath);
								     fs.write(mutifile.getBytes());
				     
								     filenames.add(filename);  //db에 입력될 파일명
								     
							} catch (Exception e) {
								e.printStackTrace();
							}finally {
								 try {
									fs.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					}
					
			}
			 
			 
			 
			 
				//파일명 (DTO)
				n.setFileSrc(filenames.get(0));
				n.setFileSrc2(filenames.get(1));
				try {
							noticedao.insert(n);  //DB insert
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
				//insert 나 update 하고 나면 ...(F5 누르면 계속 글이 ..Write)
				//리스트 (location.href    or   redirect )
				//서버에게 새로운 요청 ...목록보기
				//String :   redirect:notice.htm   
				//Servlet , jsp  :   location.href  or   response.sendRedirect 
				
				
			  return "redirect:notice.htm";
		}
	
	//글수정하기(화면 > 데이터 뿌려주고)GET
	@RequestMapping(value = "noticeEdit.htm", method=RequestMethod.GET)
	public String noticeEdit(String seq, Model model) throws ClassNotFoundException, SQLException {
		//noticedao.getNotice(seq)
		Notice notice = noticedao.getNotice(seq);
		
		model.addAttribute(notice);
		
		return "noticeEdit.jsp";
	}
	
	
	//굴수정(처리) POST
	@RequestMapping(value = "noticeEdit.htm", method=RequestMethod.POST)
	public String noticeEdit(Notice n,  HttpServletRequest request) {
		//파일업로드 가능
		//처리가 끝나면 redirect:noticeDetail.htm
		
		String seq = n.getSeq();
List<CommonsMultipartFile> files = n.getFiles();
		
		List<String> filenames = new ArrayList<String>(); // 파일명만 따로 관리
		
		if(files != null && files.size()>0) { //한개라도 업로드된 파일이 있다면 실행!!
			for(CommonsMultipartFile multifile : files) {
				String filename = multifile.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/customer/upload"); //배포된 서버 경로 
				String fpath = path + "\\" + filename;
				System.out.println(fpath);
				
				if(!filename.equals("")) { //실 파일 업로드 >> 웹서버
					FileOutputStream fs =null;
					try {
						     fs = new FileOutputStream(fpath);
						     fs.write(multifile.getBytes());
						     
						     filenames.add(filename); //db에 입력될 파일명
						     
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						 try {
							fs.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
		}
		
		//파일명(DTO)
		n.setFileSrc(filenames.get(0));
		n.setFileSrc2(filenames.get(1)); //파일이 하나라면 에러가 안날까?
		
		try {
			noticedao.update(n);	//DB UPDATE
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//INSERT, UPDATE를 하고나면(F5 누르면 계속 글이 써진다.)
		//때문에 리스트View페이지로 옮겨야됨 >> location.href or redirect
		//서버에게 새로운요청을 보내야 함 >> 목록보기로
		//Spring : redirect:notice.htm == Servlet,jsp : location.href or sendRedirect
		
		
		return "redirect:noticeDetail.htm?seq="+seq; //목록보기로 리다이렉트
	}
	
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String seq) {
		try {
			noticedao.delete(seq);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:notice.htm";
	}
	
}
