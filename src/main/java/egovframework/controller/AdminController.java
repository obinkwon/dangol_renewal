package egovframework.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import egovframework.model.Admin;
import egovframework.model.Inquiry;
import egovframework.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Resource(name = "adminService")
	private AdminService adminService;

	/**
	 * 태그 관련 - 메인추천 화면 로딩
	 * @param model
	 * @return "/recommandTag.do"
	 * @exception Exception
	 */
	@RequestMapping("/recommandTag.do")
	public String adminRecommandTag(HttpServletRequest request
			, HttpServletResponse response
			, Model model
			, @ModelAttribute("admin") Admin admin) throws Exception {
		String returnPage = "";
		
		try {
			// 현재 설정된 메인추천 1, 2
			admin.setAtype("main1");
			List<Admin> main1List = adminService.selectAdminList(admin);
			model.addAttribute("main1", main1List.size() > 0 ? main1List.get(0) : null);
			
			admin.setAtype("main2");
			List<Admin> main2List = adminService.selectAdminList(admin);
			model.addAttribute("main2", main2List.size() > 0 ? main2List.get(0) : null);

			// 드롭다운에 들어갈 themetags 출력
			admin.setAtype("theme");
			model.addAttribute("themes", adminService.selectAdminList(admin));
			
			model.addAttribute("atype", "main");
			
			returnPage = "admin/recommandTag";

		}catch(Exception e) {
			logger.error(" AdminController.adminRecommandTag :: exception ::: "+e.getMessage());
		}

		return returnPage;
	}
	
	/**
	 * 관리자가 메인추천 태그 적용
	 * @param model
	 * @return "/insertTag.do"
	 * @exception Exception
	 */
	@ResponseBody
	@RequestMapping("/insertMain.do")
	public ResponseEntity<?> adminInsertMain(HttpServletRequest request
			, HttpSession session 
			, HttpServletResponse response
			, Model model
			, @ModelAttribute("admin") Admin admin) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			int result = 0;
			if(admin.getAtype() != null) {
				List<Admin> tagList = adminService.selectAdminList(admin);
				if(tagList.size() > 0) {
					//update
					admin.setAnum(tagList.get(0).getAnum());
					result = adminService.updateTag(admin);
				}else { 
					//insert
					result = adminService.insertTag(admin);
				}
			}
			
			if(result > 0) {
				// 정상 데이터 결과
				resultMap.put("code", "3001");
				resultMap.put("message", "success");
				resultMap.put("httpStatusCode", HttpStatus.OK.value());	// 200
			}else {
				// 정상 데이터 결과
				resultMap.put("code", "3000");
				resultMap.put("message", "fail");
				resultMap.put("httpStatusCode", HttpStatus.OK.value());	// 200
			}
		}catch(Exception e) {
			logger.error(" AdminController.adminInsertMain :: exception ::: " + e.getMessage());
		}
		
		return new ResponseEntity<>(resultMap, HttpStatus.OK);
	}
	
	/**
	 * 관리자 테마 페이지 로드
	 * @param model
	 * @return "/adminThemeTag.do"
	 * @exception Exception
	 */
	@RequestMapping("/themeTag.do")
	public String adminThemeTag(HttpServletRequest request
			, HttpServletResponse response
			, Model model
			, @ModelAttribute("admin") Admin admin) throws Exception {
		String returnPage = "";
		
		try {
			admin.setAtype("theme");
			model.addAttribute("themeTags", adminService.selectAdminList(admin));
			
			model.addAttribute("atype","theme");
			returnPage = "admin/themeTag";

		}catch(Exception e) {
			logger.error(" AdminController.adminThemeTag :: exception ::: " + e.getMessage());
		}
		
		return returnPage;
	}
	
	/**
	 * 관리자 태그 추가
	 * @param model
	 * @return "/insertTag.do"
	 * @exception Exception
	 */
	@ResponseBody
	@RequestMapping("/insertTag.do")
	public ResponseEntity<?> adminInsertTag(HttpServletRequest request
			, HttpSession session 
			, HttpServletResponse response
			, Model model
			, @ModelAttribute("admin") Admin admin) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			int result = adminService.insertTag(admin);
			if(result > 0) {
				// 정상 데이터 결과
				resultMap.put("code", "3001");
				resultMap.put("message", "success");
				resultMap.put("httpStatusCode", HttpStatus.OK.value());	// 200
			}else {
				// 정상 데이터 결과
				resultMap.put("code", "3000");
				resultMap.put("message", "fail");
				resultMap.put("httpStatusCode", HttpStatus.OK.value());	// 200
			}
		}catch(Exception e) {
			logger.error(" AdminController.adminInsertTag :: exception ::: " + e.getMessage());
		}
		
		return new ResponseEntity<>(resultMap, HttpStatus.OK);
	}
	
	/**
	 * 관리자 태그 삭제
	 * @param model
	 * @return "/deleteTag.do"
	 * @exception Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTag.do")
	public ResponseEntity<?> adminDeleteTag(HttpServletRequest request
			, HttpSession session 
			, HttpServletResponse response
			, Model model
			, @ModelAttribute("admin") Admin admin) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			int result = adminService.deleteTag(admin);
			if(result > 0) {
				// 정상 데이터 결과
				resultMap.put("code", "3001");
				resultMap.put("message", "success");
				resultMap.put("httpStatusCode", HttpStatus.OK.value());	// 200
			}else {
				// 정상 데이터 결과
				resultMap.put("code", "3000");
				resultMap.put("message", "fail");
				resultMap.put("httpStatusCode", HttpStatus.OK.value());	// 200
			}
		}catch(Exception e) {
			logger.error(" AdminController.adminDeleteTag :: exception ::: " + e.getMessage());
		}
		
		return new ResponseEntity<>(resultMap, HttpStatus.OK);
	}
	
	/**
	 * 관리자 음식 페이지 로드
	 * @param model
	 * @return "/deleteTag.do"
	 * @exception Exception
	 */
	@RequestMapping("/foodTag.do")
	public String adminFoodTag(HttpServletRequest request
			, HttpServletResponse response
			, Model model
			, @ModelAttribute("admin") Admin admin) throws Exception {
		String returnPage = "";
		
		try {
			admin.setAtype("food");
			model.addAttribute("foodTags", adminService.selectAdminList(admin));
			
			model.addAttribute("atype","food");
			returnPage = "admin/foodTag";

		}catch(Exception e) {
			logger.error(" AdminController.adminThemeTag :: exception ::: " + e.getMessage());
		}
		
		return returnPage;
	}
	
	//관리자 태그 추가(파일)
	@RequestMapping("insertTagFile.do")
	public String insertTagFile(Admin admin,
			@RequestParam(value="afile") MultipartFile afile) throws Exception{
		adminService.insertTagFile(admin, afile);
		return "redirect:adminFoodTag.do";
	}
	

	//관리자 맛 페이지 로드
	@RequestMapping("adminTasteTag.do")
	public ModelAndView adminTasteTag() throws Exception {
		ModelAndView mav = new ModelAndView();
		// TasteTags 출력
		Admin admin = new Admin();
		admin.setAtype("taste");
		mav.addObject("tasteTags", adminService.selectAdminList(admin));
		mav.setViewName("Admin/adminTasteTag");
		return mav;
	}

	// 1:1문의
	//1:1문의 전체 글 불러오기
	@RequestMapping("selectAllInquirys.do")
	public ModelAndView selectAllInquirys(Inquiry inquiry) throws Exception{
		ModelAndView mav = new ModelAndView();
		String state = inquiry.getIstate();
		if(state == null) {
			state = "all";
		}
		// 모든 1:1문의 글 출력
		List<Inquiry> iList = adminService.selectInquiryList(inquiry);
		mav.addObject("iList", iList);
		mav.addObject("cntList", adminService.inquiryListCount());
		mav.addObject("state", state);
		mav.setViewName("Admin/adminInquiry");
		return mav;
	}
	
	//1:1문의 상세 글 불러오기
	@RequestMapping("selectInquiryDetail.do")
	public ModelAndView selectInquiryDetail(Inquiry inquiry) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.addObject("inquiry", adminService.selectInquiry(inquiry));
		mav.setViewName("Admin/adminInquiryDetail");
		return mav;
	}
	
	//답변등록
	@RequestMapping("insertInquiryAnswer.do")
	public String insertInquiryAnswer(Inquiry inquiry
			, HttpServletResponse response) throws Exception{
		int result = adminService.insertInquiryAnswer(inquiry);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String str = "";
		str = "<script language='javascript'>";
		if(result > 0) {
			str += "alert('답변이 등록되었습니다.');";
		}else {
			str += "alert('등록하는데 실패했습니다. 다시 시도해주세요.');";
		}
		str += "location.href='selectAllInquirys.do'";
		str += "</script>";
		pw.print(str);
		return null;
	}
	
	//저장된 이미지 불러오기
	@RequestMapping("downloadAimage.do")
	public View download(int anum) throws Exception {
		File attachFile= adminService.getAttachedFile(anum);
		View view = new DownloadView(attachFile);
		
		return view;
	}
}