package cn.qtech.xf.modules.web;

import cn.qtech.xf.modules.service.FIleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by mtf81 on 2017/2/15.
 */
@Controller
@RequestMapping("/image")
public class ImageController {
	@Autowired
	private FIleService imageService;
	@RequestMapping(value = "/down/{imageType}/{tagetId}",method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@RequestParam String imageType, @RequestParam int targetId) {
//		String fileName="";
//		File file=new File("");
//		try {
//			return FileUtil.download(fileName, file);
//		}catch(IOException e){
//			e.printStackTrace();
//		}
//		return null;
		return imageService.getFile(imageType,targetId);
	}
	@RequestMapping(value="/upload/{imageType}/{targetId}",method = RequestMethod.POST)
	public String uploadImage(@PathVariable String imageType,@PathVariable int targetId,@RequestParam("upImage") MultipartFile upImage){
		System.out.println("start-------------");
		System.out.println(upImage.getOriginalFilename());
		System.out.println(upImage.getName());
		System.out.println(upImage.getSize());
		System.out.println(imageType);
		System.out.println(targetId);
		System.out.println("end----------------");
		imageService.saveFile(imageType,targetId,upImage);
		System.out.println("end2---------------");
		return "success";
	}
}
