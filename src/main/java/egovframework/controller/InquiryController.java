package egovframework.controller;


import java.io.IOException;
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
import org.springframework.web.servlet.ModelAndView;

import egovframework.model.Admin;
import egovframework.model.Inquiry;
import egovframework.service.InquiryService;



@Controller
@RequestMapping("/inquiry")
public class InquiryController {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(InquiryController.class);
	
	@Resource(name = "inquiryService")
	private InquiryService inquiryService;

	/**
	 * 자주묻는 질문 - 고객센터
	 * @param model
	 * @return "/faq.do"
	 * @exception Exception
	 */
	@RequestMapping("/faq.do")
	public String inquiryFaqList(HttpServletRequest request
			, HttpServletResponse response
			, Model model
			, @RequestParam(required=false) String type) throws Exception {
		String returnPage = "";
		
		try {
			if(type != null) {
				if(type.equals("service")) {
					returnPage = "inquiry/faqService";
				}else {
					returnPage = "inquiry/faqSite";
				}
			}else {
				returnPage = "inquiry/faq";
			}
			model.addAttribute("type", type);

		}catch(Exception e) {
			logger.error(" InquiryController.inquiryFaqList :: exception ::: "+e.getMessage());
		}
		
		return returnPage;
	}
	
	@RequestMapping("/list.do")
	public String inquiryList (HttpServletRequest request
			, HttpServletResponse response
			, HttpSession session 
			, Model model
			, @ModelAttribute("inquiry") Inquiry inquiry) throws Exception {
		
		String returnPage = "";
		
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			String str = "";
			
			if(session.getAttribute("mid") != null || session.getAttribute("bid") != null) {
				inquiry.setMid((String)session.getAttribute("mid"));
				inquiry.setBid((String)session.getAttribute("bid"));
				model.addAttribute("inquirylist",inquiryService.selectInquiryList(inquiry));
			}else {
				str = "<script language='javascript'>";
				str += "alert('로그인 후 이용 가능 합니다.');";
				str += "location.href='/login/loginForm.do';";
				str += "</script>";
				pw.print(str);
				return null;
			}
			
			returnPage = "inquiry/list";

		}catch(Exception e) {
			logger.error(" InquiryController.inquiryList :: exception ::: "+e.getMessage());
		}
		
		return returnPage;
	}
	
	@RequestMapping("/inquiryForm.do")
	public String inquiryForm (HttpServletRequest request
			, HttpServletResponse response
			, HttpSession session 
			, Model model) throws Exception {
		
		String returnPage = "";
		
		try {
			returnPage = "inquiry/inquiryForm";
		}catch(Exception e) {
			logger.error(" InquiryController.inquiryForm :: exception ::: "+e.getMessage());
		}

		return returnPage;
	}
	
	@ResponseBody
	@RequestMapping("/insertInquiry.do")
	public ResponseEntity<?> insertInquiry(HttpServletRequest request
			, HttpServletResponse response
			, HttpSession session
			, @ModelAttribute("inquiry") Inquiry inquiry) throws IOException {
			
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("code", "3000");
		resultMap.put("message", "fail");
		resultMap.put("httpStatusCode", HttpStatus.OK.value());	// 200
		
		try {
			inquiry.setMid((String) session.getAttribute("mid"));
			inquiry.setBid((String)session.getAttribute("bid"));
			
			int result = inquiryService.insertInquiry(inquiry);
			if(result > 0) {
				// 정상 데이터 결과
				resultMap.put("code", "3001");
				resultMap.put("message", "success");
				resultMap.put("httpStatusCode", HttpStatus.OK.value());	// 200
			}
		}catch(Exception e) {
			logger.error(" InquiryController.insertInquiry :: exception ::: " + e.getMessage());
		}
		
		return new ResponseEntity<>(resultMap, HttpStatus.OK);
		
	}
	
	@RequestMapping("removeInquiry.do")
	public String removeInquiry(int inum) {
		inquiryService.deleteInquiryOne(inum);
		return "redirect:inquiry.do";
		
	}
	
	@RequestMapping("inquiryView.do")
	public ModelAndView inquiryView(int inum) {
	ModelAndView mav = new ModelAndView();
		mav.addObject("inquiry",inquiryService.selectInquiryOne(inum));
		mav.setViewName("inquiry/inquiryView");
		return mav;
		
	}
	@RequestMapping("searchInquiry.do")
	public ModelAndView searchInquiry(HttpSession session,String keyword) {
		ModelAndView mav= new ModelAndView();
		if(session.getAttribute("mid")!=null) {
			String mid= (String) session.getAttribute("mid");
			mav.addObject("inquirylist",inquiryService.searchInquiryListByMid(mid,keyword));
			mav.setViewName("inquiry/inquiry");
			return mav;
		}else {
			String bid=(String) session.getAttribute("bid");
			mav.addObject("inquirylist",inquiryService.searchInquiryListByBid(bid,keyword));
			mav.setViewName("inquiry/inquiry");
			return mav;
		}
		
	}
}
