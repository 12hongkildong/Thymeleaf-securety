package kr.co.rland.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@RestController
@Controller //view를 찾게 된다.
@RequestMapping("/")
public class HomeController {
	
	@PostMapping("upload")
	@ResponseBody
	public String upload(MultipartFile [] imgs,
						HttpServletRequest request) throws IllegalStateException, IOException {
		for(int i=0; i<imgs.length;i++) {
		MultipartFile img = imgs[i];
		
		//여러 개의 파일이 전달되지 않았을 경우를 대비해서 넣어준 구문
		if(img.isEmpty())
			continue;
		
		String urlPath ="/image/menu" +File.separator + img.getOriginalFilename();;
		//물리 경로 //this.getClass().getResource(""); 하지만 앞의 방식으로는 톰캣상의 경로를 알기는 힘들다.
		String realPath = request.getServletContext().getRealPath(urlPath);
		OutputStream fos = new FileOutputStream(realPath); 
		//읽어온 데이터들 쌓이는 배열
		byte [] buf = new byte[1024];
		InputStream fis = img.getInputStream();
		int size = 1024;
		// 2049 - 1024 = 1025, 1025-1024 =1
		while((size = fis.read(buf)) !=-1)
				fos.write(buf,0,size);
		fis.close();
		fos.close();
		}
//		img.transferTo(new File(realPath));
		return "ok";
}
	
	@GetMapping("index")
	public String index(Model model, 
			HttpServletResponse response, 
			String name, 
			HttpServletRequest request)throws UnsupportedEncodingException {
		String data = URLEncoder.encode("cookie 지롱~", "utf-8");
		Cookie cookie = new Cookie("my", data);
		response.addCookie(cookie);
		//output 파라미터
		model.addAttribute("data", data);
		model.addAttribute("imgPath", "/test.png");
		//forwarding
		return "index";
	}
	
//	@GetMapping("display")
//	public ResponseEntity<Resource> display(HttpServletRequest request) {
//		String urlPath ="/image/menu" +File.separator + "test.jpg";
//		String realPath = request.getServletContext().getRealPath(urlPath);
//		Resource resource = new FileSystemResource(realPath);
//		if(!resource.exists()) 
//			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
//		HttpHeaders header = new HttpHeaders();
//		Path filePath = null;
//		try{
//			filePath = Paths.get(realPath);
//			header.add("Content-type", Files.probeContentType(filePath));
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
//	}
}
