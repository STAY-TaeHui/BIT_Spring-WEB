package DI_06_Spring;

public class MySqlArticleDao implements ArticleDao{

	@Override
	public void insert(Article article) {
		// TODO Auto-generated method stub
		System.out.println("MYSQL insert 구문 실행");
	}

}
