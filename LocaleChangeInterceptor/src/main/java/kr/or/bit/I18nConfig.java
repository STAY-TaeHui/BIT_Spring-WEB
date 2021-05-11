package kr.or.bit;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration 
@ComponentScan
public class I18nConfig extends WebMvcConfigurerAdapter
{ 
	@Bean 
	public LocaleResolver localeResolver() {
		// 쿠키를 사용한 예제 
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setCookieName("lang"); return resolver; } 
	/** 언어 변경시 아래 코드 추가 */
	public void addInterceptors(InterceptorRegistry registry) { 
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang"); // ?lang={언어코드} 로 언어를 바꿀 수 있습니다. 
		registry.addInterceptor(localeChangeInterceptor); 
		} 
	@Bean
	public MessageSource messageSource() { 
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:/i18n/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource; 
		} 

}
