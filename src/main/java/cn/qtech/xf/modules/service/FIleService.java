package cn.qtech.xf.modules.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by mtf81 on 2017/2/15.
 */
public interface FIleService {
	ResponseEntity<byte []> getFile(String ownerType, Integer targetId);
	void  saveFile(String ownerType, Integer targetId,MultipartFile file);
}
