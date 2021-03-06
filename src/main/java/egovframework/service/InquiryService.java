package egovframework.service;

import java.util.List;

import egovframework.model.Inquiry;

public interface InquiryService {

	public List<Inquiry> selectInquiryByMid(String mid);

	public List<Inquiry> selectInquiryByBid(String bid);

	public void deleteInquiryOne(int inum);

	public void insertInquiry(Inquiry inquiry);

	public Inquiry selectInquiryOne(int inum);

	public List<Inquiry> searchInquiryListByMid(String mid, String keyword);

	public List<Inquiry> searchInquiryListByBid(String bid, String keyword);
}
