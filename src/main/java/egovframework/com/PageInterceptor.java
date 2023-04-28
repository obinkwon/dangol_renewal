package egovframework.com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class PageInterceptor implements HandlerInterceptor{
    protected final Logger logger = LoggerFactory.getLogger(PageInterceptor.class);

	@Override
	public boolean preHandle(
			HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		HttpSession session = request.getSession();
		String isLang = "kr"; // 다국어 설정
		String isPage = ""; // pc/모바일 접속 여부 체크
		String isUrl = request.getRequestURI(); 
		String isQueryStr = request.getQueryString();
		
		if( isQueryStr != null && !isQueryStr.equals("") ) {
			isUrl += "?" + isQueryStr; 
		}
		
		logger.error("PageInterceptor :::: isPage = "+isPage);
		logger.error("PageInterceptor :::: isLang = "+isLang);

		session.setAttribute("sessLang", isLang);
		session.setAttribute("sessPage", isPage);
		
		return true;
	}
	
	// controller의 handler가 끝나면 처리됨
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView mav)
			throws Exception {
	}

	// view까지 처리가 끝난 후에 처리됨
	@Override
	public void afterCompletion(
			HttpServletRequest request, HttpServletResponse response,
			Object obj, Exception e)
			throws Exception {
	}

}
