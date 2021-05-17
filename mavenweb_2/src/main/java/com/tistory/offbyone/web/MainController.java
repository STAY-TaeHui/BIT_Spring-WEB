package com.tistory.offbyone.web;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;


@Controller
public class MainController {
	
	
    @Autowired
    MessageSource messageSource;
    
    
    @Autowired
    LocaleResolver localeResolver;
    
    

	//LocaleChangeInterceptor를 이용한 Locale변경
    @RequestMapping(value = "/i18n.do", method = RequestMethod.GET)
    public String i18n(Locale locale, HttpServletRequest request, Model model) {

        // RequestMapingHandler로 부터 받은 Locale 객체를 출력
        model.addAttribute("clientLocale", locale);

        // localeResolver 로부터 Locale 을 출력
        model.addAttribute("sessionLocale", localeResolver.resolveLocale(request));

        // JSP 페이지에서 EL 을 사용해서 arguments 를 넣을 수 있도록 값을 보낸다.
        model.addAttribute("siteCount", messageSource.getMessage("msg.first", null, locale));

        return "i18n";
   }
    //LocaleResolver의 setLocale을 이용한 Locale변경
    @RequestMapping(value = "/i18n2.do", method = RequestMethod.GET)
    public String setting(String newLocale, Locale oldLocale, HttpServletRequest request, HttpServletResponse response, Model model) {
    	//newLocale : 변경 할 Locale를 파라미터로 받아온다.
    	//oldLocale : 변경 전 Locale를 파라미터로 받아온다.
    	Locale lag = oldLocale;
    	if(newLocale != null) // 파라미터에 newLocale이 있을경우
    	{
    		lag = new Locale(newLocale);//newLocale을 생성해준다.
    		localeResolver.setLocale(request, response, lag);// setLocale을 통해 newLocale로 Locale을 변경한다.
    	}
    	
    	 model.addAttribute("clientLocale", lag);

         // localeResolver 로부터 Locale 을 출력해 봅니다.
         model.addAttribute("sessionLocale", localeResolver.resolveLocale(request));

         // JSP 페이지에서 EL 을 사용해서 arguments 를 넣을 수 있도록 값을 보낸다.
         model.addAttribute("siteCount", messageSource.getMessage("msg.first", null, lag));

        return "i18n";
   }
}
