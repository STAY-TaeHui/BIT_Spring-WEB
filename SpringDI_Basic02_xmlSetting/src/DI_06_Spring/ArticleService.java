package DI_06_Spring;

public class ArticleService {
	//클라이언트 요청에따라서 
	//DAO객체 생성... 함수를 호출
	
	//ArticleServie는 ArticleDAo가 필요하다(의존)
	
	private ArticleDao articledao;
	public ArticleService(ArticleDao articledao) {
		this.articledao = articledao;
		System.out.println("생성자 호출");
	}
	
	//글쓰기 서비스
	public void write(Article article) {
		this.articledao.insert(article);
	}
}
