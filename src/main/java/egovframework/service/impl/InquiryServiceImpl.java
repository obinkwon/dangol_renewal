package egovframework.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.model.Inquiry;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.service.InquiryService;
import egovframework.service.dao.IInquiryDao;

@Service("inquiryService")
public class InquiryServiceImpl extends EgovAbstractServiceImpl implements InquiryService{

	@Resource(name = "IInquiryDao")
	private IInquiryDao inquiryDao;

	// 문의 리스트
	public List<Inquiry> selectInquiryList(Inquiry inquiry) throws Exception {
		return inquiryDao.selectInquiryList(inquiry);
	}
	
	// 문의 등록
	public int insertInquiry(Inquiry inquiry) throws Exception {
		return inquiryDao.insertInquiry(inquiry);
	}
	
	public void deleteInquiryOne(int inum) {
		inquiryDao.deleteInquiryOne(inum);

	}


	public Inquiry selectInquiryOne(int inum) {
		Inquiry inquiry = inquiryDao.selectInquiryOne(inum);
		return inquiry;
	}

	public List<Inquiry> searchInquiryListByMid(String mid, String keyword) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("mid", mid);
		param.put("keyword", keyword);
		List<Inquiry> inquiry = inquiryDao.searchInquiryListByMid(param);
		return inquiry;
	}

	public List<Inquiry> searchInquiryListByBid(String bid, String keyword) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("bid", bid);
		param.put("keyword", keyword);
		List<Inquiry> inquiry = inquiryDao.searchInquiryListByBid(param);
		return inquiry;
	}
}
