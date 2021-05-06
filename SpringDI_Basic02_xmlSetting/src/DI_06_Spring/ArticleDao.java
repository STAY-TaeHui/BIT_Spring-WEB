package DI_06_Spring;

//mysql, oracle이 사용하는 동일한 (공통)추상 함수를 구현 강제함
public interface ArticleDao {
	void insert(Article article);
}
