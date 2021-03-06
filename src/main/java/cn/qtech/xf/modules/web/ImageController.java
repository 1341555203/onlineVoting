package cn.qtech.xf.modules.web;

import cn.qtech.xf.modules.service.FIleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/image")
public class ImageController {
	@Autowired
	private FIleService fIleService;
	/*
	image/down/{imageType}/{targetId}
	下载
	 */
	@RequestMapping(value = "/down/{imageType}/{targetId}",method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable String imageType, @PathVariable int targetId) {
		return fIleService.getFile(imageType,targetId);
	}
	/*
	image/upload/{imageType}/{targetId}
	上传
	 */
	@RequestMapping(value="/upload/{imageType}/{targetId}",method = RequestMethod.POST)
	public String uploadImage(@PathVariable String imageType,@PathVariable int targetId,@RequestParam("upImage") MultipartFile upImage){
		fIleService.saveFile(imageType,targetId,upImage);
		return "success";
	}
	@RequestMapping(value="/upload/{imageType}/{targetId}/redirect",method = RequestMethod.POST)
	public String uploadImageRedirect(@PathVariable String imageType,@PathVariable int targetId,@RequestParam String uri,@RequestParam("upImage") MultipartFile upImage){
		fIleService.saveFile(imageType,targetId,upImage);
		System.out.println(uri);
		return "redirect:/"+uri;
	}
}
