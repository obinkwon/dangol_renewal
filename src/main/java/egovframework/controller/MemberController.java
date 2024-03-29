package egovframework.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import egovframework.model.Login;
import egovframework.model.Member;
import egovframework.model.Store;
import egovframework.service.AdminService;
import egovframework.service.MemberService;
import egovframework.service.OwnerService;


@Controller
@RequestMapping("/login")
public class MemberController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource(name = "memberService")
	private MemberService memberService;
	
	@Resource(name = "ownerService")
	private OwnerService ownerService;
	
	@Resource(name = "adminService")
	private AdminService adminService;
	
	/**
	 * 로그인 폼 이동 - 로그인
	 * @param model
	 * @return "/loginForm.do"
	 * @exception Exception
	 */
	@RequestMapping("/loginForm.do")
	public String loginForm(HttpServletRequest request
			, HttpServletResponse response
			, Model model) throws Exception {
		String returnPage = "";
		
		try {
			returnPage = "login/loginForm";
		}catch(Exception e) {
			logger.error(" MemberController.loginForm :: exception ::: "+e.getMessage());
		}

		return returnPage;
	}
	
	/**
	 * 로그인 Action - 로그인
	 * @param model
	 * @return "/loginAct.do"
	 * @exception Exception
	 */
	@ResponseBody
	@RequestMapping("/loginAct.do")
	public ResponseEntity<?> loginAct(HttpServletRequest request
			, HttpServletResponse response
			, HttpSession session 
			, Model model
			, @ModelAttribute("login") Login login) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("code", "3000");
		resultMap.put("message", "fail");
		resultMap.put("httpStatusCode", HttpStatus.OK.value());	// 200
		
		try {
			if(login != null) {
				String loginUser = login.getLoginUser();
				String sessionId = "";
				String path = "";
				
				//사용자 로그인일때
				if (loginUser.equals("user")) {
					int memberCnt = memberService.loginMembers(login);
					logger.debug("memberCnt ::: {}", memberCnt);
					sessionId = memberCnt == 0 ? "mid" : "loginAdmin";
					path = "/main/main.do";
				} else { //점장 로그인일때
					if (ownerService.loginBoss(login.getId(), login.getPwd()) == 0) {
					} else {
					}
					path = "main.do";
				}
				session.setAttribute(sessionId, login.getId());
				if(!path.equals("")) {
					// 정상 데이터 결과
					resultMap.put("code", "3001");
					resultMap.put("message", "success");
					resultMap.put("path", path);
					resultMap.put("httpStatusCode", HttpStatus.OK.value());	// 200
				}
			}
		}catch(Exception e) {
			logger.error(" MemberController.loginAct :: exception ::: " + e.getMessage());
		}
		
		return new ResponseEntity<>(resultMap, HttpStatus.OK);
	}
	
	/**
	 * 회원가입 폼 이동 - 로그인
	 * @param model
	 * @return "/signUpForm.do"
	 * @exception Exception
	 */
	@RequestMapping("/signUpForm.do")
	public String signUpForm(HttpServletRequest request
			, HttpServletResponse response
			, Model model) throws Exception {
		String returnPage = "";
		
		try {
			returnPage = "login/signUpForm";
		}catch(Exception e) {
			logger.error(" MemberController.signUpForm :: exception ::: "+e.getMessage());
		}

		return returnPage;
	}
	
	/**
	 * 사용자 회원 가입 폼 이동 - 로그인
	 * @param model
	 * @return "/signup/membersForm.do"
	 * @exception Exception
	 */
	@RequestMapping("/signup/membersForm.do")
	public String signUpMembersForm(HttpServletRequest request
			, HttpServletResponse response
			, Model model) throws Exception{
		String returnPage = "";
		Admin admin = new Admin();
		
		try {
			// 회원가입시 해시태그 리스트 가져오기
			admin.setAtype("theme");
			model.addAttribute("themeList", adminService.selectAdminList(admin));
			returnPage = "login/signup/membersForm";
		}catch(Exception e) {
			logger.error(" MemberController.signUpMembersForm :: exception ::: "+e.getMessage());
		}

		return returnPage;
	}
	
	/**
	 * 회원가입시 id 중복체크 - 로그인
	 * @param model
	 * @return "/checkIdMember.do"
	 * @exception Exception
	 */
	@RequestMapping("/checkIdMember.do")
	@ResponseBody
	public ResponseEntity<?> checkIdMember(HttpServletRequest request
			, HttpSession session 
			, HttpServletResponse response
			, Model model
			, @ModelAttribute("member") Member member) throws Exception{
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("code", "3000");
		resultMap.put("message", "fail");
		resultMap.put("httpStatusCode", HttpStatus.OK.value());	// 200
		
		try {
			Member resultVO = memberService.selectMember(member);
			if(resultVO == null) {
				// 정상 데이터 결과
				resultMap.put("code", "3001");
				resultMap.put("message", "success");
				resultMap.put("httpStatusCode", HttpStatus.OK.value());	// 200
			}
		}catch(Exception e) {
			logger.error(" AdminController.adminInsertTagFile :: exception ::: " + e.getMessage());
		}
		
		return new ResponseEntity<>(resultMap, HttpStatus.OK);
	}
	
	// 회원가입
	/**
	 * 회원가입 Action - 로그인
	 * @param model
	 * @return "/signUpAct.do"
	 * @exception Exception
	 */
	@RequestMapping("/signUpAct.do")
	public ResponseEntity<?> signUpAct(HttpServletRequest request
			, HttpSession session 
			, HttpServletResponse response
			, Model model
			, @ModelAttribute("member") Member member
			, @ModelAttribute("uploadFile") MultipartFile uploadFile) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("code", "3000");
		resultMap.put("message", "fail");
		resultMap.put("httpStatusCode", HttpStatus.OK.value());	// 200
		
		try {
			int result = memberService.insertMember(member, uploadFile);
			if(result > 0) {
				if(member.getMtag() != null) {
					memberService.insertMtag(member);
				}
				// 정상 데이터 결과
				resultMap.put("code", "3001");
				resultMap.put("message", "success");
				resultMap.put("httpStatusCode", HttpStatus.OK.value());	// 200
			}
		}catch(Exception e) {
			logger.error(" MemberController.signUpAct :: exception ::: " + e.getMessage());
		}
		
		
		
		return new ResponseEntity<>(resultMap, HttpStatus.OK);
	}
	
	//id, pwd 찾기 폼 이동
	@RequestMapping("findIdPwForm.do")
	public ModelAndView findIdPwForm(String type) { 
		ModelAndView mav = new ModelAndView();
		mav.addObject("type",type);
		mav.setViewName("jsp/findIdPwForm");
		return mav;
	}
	
	//id 찾기
	@RequestMapping("findId.do")
	@ResponseBody
	public List<String> checkById(String loginUser
			, String phone) throws Exception{ 
		List<String> str = new ArrayList<String>();

		if (loginUser.equals("user")) { //사용자 일때
			List<Member> mlist = memberService.findId(phone);
			if (mlist.size() > 0) {
				for (int i = 0; i < mlist.size(); i++) {
					str.add(mlist.get(i).getMid());
				}
			}
		} else { //점장 일때
			List<Store> blist = ownerService.findId(phone);
			if (blist.size() > 0) {
				for (int i = 0; i < blist.size(); i++) {
					str.add(blist.get(i).getBid());
				}
			}
		}
		return str;
	}

	//비밀번호 찾기
	@RequestMapping("findPw.do")
	@ResponseBody
	public String checkByPw(String loginUser
			, String id
			, String phone) throws Exception{
		String result = "";
		
		if (loginUser.equals("user")) { //사용자 일때
			Member member = new Member();
			member.setMid(id);
			member.setMphone(phone);
			
			member = memberService.findPw(member);
			if (member != null) {
				result = member.getMpw();
			}
		} else { //점장 일때
			Store store = new Store();
			store.setBid(id);
			store.setBphone(phone);
			store = ownerService.findPw(store);
			if (store != null) {
				result = store.getBid();
			}
		}
		return result;
	}

	//저장된 이미지 불러오기
	@RequestMapping("downloadMImage.do") 
	public View download(String mid) throws Exception{
		File attachFile= memberService.getAttachedFile(mid);
		View view = new DownloadView(attachFile);
		return view;
	}
	
	//도로명 주소 api
	@RequestMapping("jusoPopup.do")
	public ModelAndView jusoPopup(int index) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("index", index);
		mav.setViewName("jsp/jusoPopup");
		return mav;
	}

}
