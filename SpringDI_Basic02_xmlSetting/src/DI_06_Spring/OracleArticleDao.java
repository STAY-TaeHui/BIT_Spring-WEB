package DI_06_Spring;

public class OracleArticleDao implements ArticleDao{

	@Override
	public void insert(Article article) {
		// TODO Auto-generated method stub
		System.out.println("Oracle INsert 구문실행");
	}

}
