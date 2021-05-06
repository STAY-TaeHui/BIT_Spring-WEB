package DI_06_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Oracle사용 insert 실행
//		OracleArticleDao articledao = new OracleArticleDao();
//		ArticleService articleservice = new ArticleService(articledao);
//		
//		Article article = new Article();
//		articleservice.write(article);
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:DI_06_Spring/DI_06.xml");
		
		ArticleService articleservice = context.getBean("articleservice",ArticleService.class);
		Article article = context.getBean("article",Article.class);
		
		articleservice.write(article);
	}

}
