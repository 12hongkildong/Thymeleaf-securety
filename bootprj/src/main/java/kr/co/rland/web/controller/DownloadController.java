package kr.co.rland.web.controller;

import java.io.FileInputStream;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DownloadController {

	@GetMapping("/test/download")
	public void download(HttpServletResponse response) throws Exception {
		
		//자체적으로 파일 만들어주는 로직
		//서버컴에 저장을 한다.
		
		
		
		//클라이언트 다운로드 관련
		//서버컴의 파일위치
		String path = "C:/Users/user/Desktop/test.txt";
		FileInputStream fis = new FileInputStream(path);
		byte buf[] = new byte[1024];
		int size = 1024;
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition",
				"attachment; fileName=\"" + URLEncoder.encode("test.txt", "UTF-8") + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		while ((size = fis.read(buf)) != -1)
			response.getOutputStream().write(buf, 0, size);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		fis.close();
	}
}
