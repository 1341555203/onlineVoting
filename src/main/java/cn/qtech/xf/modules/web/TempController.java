package cn.qtech.xf.modules.web;

import cn.qtech.xf.common.utils.FileUtil;
import cn.qtech.xf.modules.entity.Attachment;
import cn.qtech.xf.modules.service.FIleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/temp")
public class TempController {

	@Autowired
	private FIleService imageService;
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String homePage(){
		return "sys/home";
	}
	@RequestMapping(value="/vote/view",method = RequestMethod.GET)
	public String voteView(){
		return "vote/view";
	}
	@RequestMapping(value = "/saveFile",method = RequestMethod.GET)
	public String saveFileInit(){

		return "sys/saveFile";
	}
	@RequestMapping(value = "/saveFile",method = RequestMethod.POST)
	public String saveFile(MultipartFile uploadFile) throws IOException{
		System.out.println("name--"+uploadFile.getOriginalFilename());
		System.out.println("Stream--"+uploadFile.getInputStream());

		return "success";
	}
	@RequestMapping(value = "/getTestImage",method =RequestMethod.GET )
	public ResponseEntity<byte[]> getTestImage(){
		Attachment attachment=new Attachment();
		attachment.setAttOrigin("tupian.jpg");
		try {
			File file = new File("d:/ImagesForOnlineVoting/testImage.jpg");
			return FileUtil.download(attachment.getAttOrigin(), file);
		}catch (IOException e){
			e.printStackTrace();
			System.out.println("------imageServiceImpl ioException");
		}
		return null;
	}
}
