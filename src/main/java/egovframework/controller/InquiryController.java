package egovframework.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		
		if(!type.equals("")) {
			if(type.equals("service")) {
				returnPage = "inquiry/faqService";
			}else {
				returnPage = "inquiry/faqSite";
			}
		}else {
			returnPage = "inquiry/faq";
		}
		model.addAttribute("type", type);
		
		return returnPage;
	}
	
	@RequestMapping("/list.do")
	public String inquiryList (HttpServletRequest request
			, HttpServletResponse response
			, HttpSession session 
			, Model model) throws Exception {
		String returnPage = "inquiry/list";
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String str = "";
		
		if(session.getAttribute("mid") != null) {
			String mid = (String)session.getAttribute("mid");
			model.addAttribute("inquirylist",inquiryService.selectInquiryByMid(mid));
		}else if (session.getAttribute("bid") != null) {
			String bid = (String) session.getAttribute("bid");
			model.addAttribute("inquirylist",inquiryService.selectInquiryByBid(bid));
		}else {
			str = "<script language='javascript'>";
			str += "alert('로그인 후 이용 가능 합니다.');";
			str += "location.href='loginForm.do';";
			str += "</script>";
			pw.print(str);
			return null;
		}
		
		return returnPage;
	}
	
	@RequestMapping("removeInquiry.do")
	public String removeInquiry(int inum) {
		inquiryService.deleteInquiryOne(inum);
		return "redirect:inquiry.do";
		
	}
	@RequestMapping("registInquiryForm.do")
	public String registInquiryForm() {
		return "inquiry/registInquiryForm";
	}
	@RequestMapping("registInquiry.do")
	public String registInquiry(Inquiry inquiry, HttpSession session, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		String str = "";
		
	if(session.getAttribute("mid")!=null) {
		System.out.println("여기여기");
		String mid= (String) session.getAttribute("mid");
		inquiry.setMid(mid);
		System.out.println(inquiry);
		inquiryService.insertInquiry(inquiry);
	}else {
		String bid=(String)session.getAttribute("bid");
		inquiry.setBid(bid);
		System.out.println(inquiry);
		inquiryService.insertInquiry(inquiry);
	}
	str = "<script language='javascript'>";
	str += "alert('1:1문의가 등록되었습니다.');";
	str += "location.href='inquiry.do';";
	str += "</script>";
	pw.print(str);
	return null;
	
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
