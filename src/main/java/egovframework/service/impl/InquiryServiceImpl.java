package egovframework.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.model.Inquiry;
import egovframework.service.InquiryService;
import egovframework.service.dao.IInquiryDao;

@Service("inquiryService")
public class InquiryServiceImpl implements InquiryService{

	@Autowired
	private IInquiryDao inqryDao;

	// 문의 리스트
	public List<Inquiry> selectInquiryList(Inquiry inquiry) throws Exception {
		return inqryDao.selectInquiryList(inquiry);
	}
		
	public List<Inquiry> selectInquiryByMid(String mid) {
		List<Inquiry> inquiry = inqryDao.selectInquiryByMid(mid);
		return inquiry;
	}

	public List<Inquiry> selectInquiryByBid(String bid) {
		List<Inquiry> inquiry = inqryDao.selectInquiryByBid(bid);
		return inquiry;
	}

	public void deleteInquiryOne(int inum) {
		inqryDao.deleteInquiryOne(inum);

	}

	public void insertInquiry(Inquiry inquiry) {
		inqryDao.insertInquiry(inquiry);
	}

	public Inquiry selectInquiryOne(int inum) {
		Inquiry inquiry = inqryDao.selectInquiryOne(inum);
		return inquiry;
	}

	public List<Inquiry> searchInquiryListByMid(String mid, String keyword) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("mid", mid);
		param.put("keyword", keyword);
		List<Inquiry> inquiry = inqryDao.searchInquiryListByMid(param);
		return inquiry;
	}

	public List<Inquiry> searchInquiryListByBid(String bid, String keyword) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("bid", bid);
		param.put("keyword", keyword);
		List<Inquiry> inquiry = inqryDao.searchInquiryListByBid(param);
		return inquiry;
	}
}
