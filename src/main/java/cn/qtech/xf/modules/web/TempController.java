package cn.qtech.xf.modules.web;

import cn.qtech.xf.common.utils.FileUtil;
import cn.qtech.xf.modules.entity.Attachment;
import cn.qtech.xf.modules.entity.Menu;
import cn.qtech.xf.modules.entity.Option;
import cn.qtech.xf.modules.service.FIleService;
import cn.qtech.xf.modules.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/temp")
public class TempController {

	@Autowired
	private FIleService imageService;
	@Autowired
	private MenuService menuService;
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

//	@RequestMapping(value = "/getList",method = RequestMethod.GET)
//	public String getListInit(){
//
//		return "temp/getList";
//	}
//	@RequestMapping(value = "/getList",method = RequestMethod.POST)
//	public String getList(ListTemp listTemp){
//		System.out.println(listTemp);
//		return "redirect:/temp/getList";
//	}

	@RequestMapping(value = "/getMenu",method =RequestMethod.GET )
	public String getMenu(){
		List<Menu> menus=(List)menuService.getAllMenu();
		System.out.println(menus);

//		Menu menu=new Menu();
//		menu.setMenuTitle("测试存入");
//		menu.setMenuDiscription("nodiscription");
//		Option option1=new Option();
//		option1.setOptionTitle("存入选项1");
//		Option option2=new Option();
//		option2.setOptionTitle("存入选项2");
//		List<Option> options=new ArrayList<Option>();
//		options.add(option1);
//		options.add(option2);
//		menu.setOptions(options);
//
//		menuService.saveMenu(menu);

		return "sys/saveFile";
	}
}
