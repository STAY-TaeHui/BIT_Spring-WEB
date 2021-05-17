package com.tistory.offbyone.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 웹 컨텍스트 설정파일
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.tistory.offbyone.web"})//Controller가 있는 패키지
public class WebContextConfiguration  implements WebMvcConfigurer {

	

	/**
	 * 언어 변경을 위한 인터셉터를 생성한다.
	 * interceptor.setParamName("lang");
	 * 이 코드는 요청쿼리에 ?lang 이라는 파라미터가 붙으면 인터셉터가 Locale을 생성한 뒤 
	 * LocaleResolver를 이용해서 Locale을 변경한다.
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}
	
	/**
	 * 인터셉터를 등록한다.
	 * InterceptorRegistry : uri 매핑된 컨트롤러를 거치기 전, 후 처리를 할 수 있도록 도와준다.
	 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
	
	/**
	 * 뷰 리졸버를 설정한다.
	 * @return
	 */
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
