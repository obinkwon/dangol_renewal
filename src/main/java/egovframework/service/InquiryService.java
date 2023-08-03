package egovframework.service;

import java.util.List;

import egovframework.model.Inquiry;

public interface InquiryService {

	/**
	 * 문의 리스트
	 * 
	 * @param	Inquiry
	 * @return  List
	 * @exception Exception
	 */
	public List<Inquiry> selectInquiryList(Inquiry inquiry) throws Exception;
	
	/**
	 * 문의 등록
	 * 
	 * @param	Inquiry
	 * @return  int
	 * @exception Exception
	 */
	public int insertInquiry(Inquiry inquiry) throws Exception;
	
	public void deleteInquiryOne(int inum);


	public Inquiry selectInquiryOne(int inum);

	public List<Inquiry> searchInquiryListByMid(String mid, String keyword);

	public List<Inquiry> searchInquiryListByBid(String bid, String keyword);
}
