package egovframework.com.utils;


import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile; 

@Component
public class FileUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

	public static Map<String,Object> uploadFile(
			String filePath
			, MultipartFile uploadFile
			) throws Exception{ 
		
		String originalFileName = ""; 
		String fileExt = ""; 
		String storedFileName = ""; 
		Map<String, Object> listMap = null; 
		
		logger.error("filePath :::::: "+filePath);
		
		//파일 경로 확인
		File file = new File(filePath); 
		if(!file.exists()) file.mkdirs();
		
		logger.error("uploadFile :::::: "+uploadFile.isEmpty());
		
		if(!uploadFile.isEmpty()){ 
			logger.error("uploadFile :::::: is not empty !!");
			originalFileName = uploadFile.getOriginalFilename(); 
			fileExt = originalFileName.substring(originalFileName.lastIndexOf("."));
			storedFileName = new Date().getTime() + fileExt; 
			file = new File(filePath + storedFileName);
			uploadFile.transferTo(file); 
			listMap = new HashMap<String,Object>(); 
			listMap.put("filePath", filePath); 
			listMap.put("fileRpath", filePath); 
			listMap.put("originalFileName", originalFileName); 
			listMap.put("storedFileName", storedFileName); 
			listMap.put("fileExt", fileExt); 
		}
		
		return listMap; 
	} 

	public static Map<String,Object> uploadFileReal(
			  String realPath
			, String filePath
			, MultipartFile uploadFile
			) throws Exception{ 
		
		String originalFileName = ""; 
		String fileExt = ""; 
		String storedFileName = ""; 
		Map<String, Object> listMap = null; 
		
		logger.error("filePath :::::: "+filePath);
		logger.error("realPath :::::: "+realPath);
		
		//파일 경로 확인
		File file = new File(realPath+filePath); 
		if(!file.exists()) file.mkdirs(); 
		
		if(!uploadFile.isEmpty()){ 
			originalFileName = uploadFile.getOriginalFilename(); 
			fileExt = originalFileName.substring(originalFileName.lastIndexOf(".")); 
			storedFileName = new Date().getTime() + fileExt; 
			file = new File(realPath+filePath + storedFileName); 
			uploadFile.transferTo(file); 
			listMap = new HashMap<String,Object>(); 
			listMap.put("filePath", filePath); 
			listMap.put("fileRpath", realPath); 
			listMap.put("originalFileName", originalFileName); 
			listMap.put("storedFileName", storedFileName); 
			listMap.put("fileExt", fileExt); 
		}
		
		return listMap; 
	} 
}
