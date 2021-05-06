package DI_08_Spring;

public class JobExecute {
	private ArticleDao articledao;
	private int data;
	
	
	public JobExecute(String first , int second) {
		System.out.println("String , int");
	}
	
	public JobExecute(String first , long second) {
		System.out.println("String , long");
	}
	
	public JobExecute(String first , String second) {
		System.out.println("String , String");
	}
	
	

	public ArticleDao getArticledao() {
		return articledao;
	}

	public void setArticledao(ArticleDao articledao) {
		this.articledao = articledao;
		System.out.println("setArticleDao : " + this.articledao);
	}
	

	public void setData(int data) {
		this.data = data;
		System.out.println("setData value : " + this.data);
	}
	
	
	
	
}






