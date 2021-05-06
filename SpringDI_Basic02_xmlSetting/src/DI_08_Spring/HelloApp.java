package DI_08_Spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		
		/*
		 * JobExecute jobexcute = new JobExecute("hong", 100);
		 * 
		 * //JobExecute jobexcute2 = new JobExecute("hong", 100L);
		 * 
		 * //JobExecute jobexcute3 = new JobExecute("hong", "kim");
		 * 
		 * ArticleDao articledao = new ArticleDao();
		 * jobexcute.setArticledao(articledao);
		 * 
		 * jobexcute.setData(500);
		 */
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:DI_08_Spring/DI_08.xml");
	
	}

}


