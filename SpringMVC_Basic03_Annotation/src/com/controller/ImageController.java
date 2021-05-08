package com.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.model.Photo;

@Controller
@RequestMapping("/image/upload.do")
public class ImageController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "image/image";
		
	}
	
	@RequestMapping(method =RequestMethod.POST)
	public String submit(Photo photo, HttpServletRequest request) {
		/*
		 * 1. Photo DTO 타입으로 데이터 받기
		 * 1.1 자동화 : name속성값이 Photo 타입 클래스 memberfield명과 동일해야 함
		 * 2. 내부적으로 poublic String submit(Photho photo)
		 * 2.1 Photo photo = new Photo();
		 * 2.2 자동주입 >> photo.setName("홍길동") ....
		 * 		photo.setImage() 파일명 >> 자동주입 안됨 >> 업로드한 파일명 >> 가공해야함 >> CommonsMultipartFile를 통해 추출해야함
		 * 		photo.set(CommonsMultipartFile - file)
		 * 		
		 * 
		 * 
		 */
		System.out.println(photo.toString());
		//파일 객체 가져와서 CommonsMultipartFile변수에 넣기
	    CommonsMultipartFile imagefile =photo.getFile();
		System.out.println("imagefile.name : " + imagefile.getName());
		System.out.println("imagefile.getContentType : " + imagefile.getContentType());
		System.out.println("imagefile.getOriginalFilename : " + imagefile.getOriginalFilename());
		System.out.println("imagefile.getBytes : " + imagefile.getBytes().length);
		
		//POINT DB에 들어갈 파일명
		//CommonsMultipartFile타입의 imagefile에서 파일이름 뽑기 >> photo.setImage로 파일명 세팅 >> DB에 들어갈 파일명
		photo.setImage(imagefile.getName());
		
		//cos.jar 자동 파일 업로드 
		//실제 파일 업로드 구현 (upload 업로드)
		//CommonsMultipartFile타입의 imagefile에서 이름을 뽑아오기
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload"); //배포된 서버 경로 
		String fpath = path + "\\" + filename;
		System.out.println(fpath);
		
		FileOutputStream fs =null;
		try {
			     fs = new FileOutputStream(fpath);
			     fs.write(imagefile.getBytes());
			     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 try {
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//DB작업 .... 파일 업로드 완료
		return "image/image";
		
	}
}
