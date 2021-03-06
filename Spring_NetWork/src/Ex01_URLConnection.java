import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//네트워크 작업을 할 수 있는 자원 
//JAVA API 제공
//클래스를 통해서
//URL 클래스(인터넷 상에 주소를 다루는 클래스)
//URLConnection 클래스(연결돤 URL 주소로 부터 다양한 정보와 작업)
//http://image3.kangcom.com/2018/02/b_pic/201802028179.jpg

//1. 크로스 도메인 오류
//2. 크롤링 ( 특정 페이지 원하는 정보 뽑아오기 )
public class Ex01_URLConnection {
	public static void main(String[] args) throws IOException {
		String urlstr = "http://www.kangcom.com/images/banner/amazon_Best.jpg";
		URL url = new URL(urlstr); //연결
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		
		
		
		URLConnection uc = url.openConnection();
		int filesize = uc.getContentLength();
		
		System.out.println("파일 크기 : " + filesize);
		System.out.println("파일형식 : " + uc.getContentType());
		//
		FileOutputStream fos = new FileOutputStream("copy6.jpg"); //파일 생성 (프로젝트 폴더)
		
		byte[] buffer = new byte[2048];
		int n = 0;
		int count =0;
		
		while((n = bis.read(buffer)) != -1) {
			fos.write(buffer,0,buffer.length);
			fos.flush();
			System.out.println("n : " + n);
			count+=1;
		}
		System.out.println("count : "+ count);
		fos.close();
		bis.close();
	}

}







