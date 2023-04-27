package egovframework.dao;

import java.util.HashMap;
import java.util.List;

import egovframework.model.Inquiry;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("IInquiryDao")
public interface IInquiryDao {

	public List<Inquiry> selectInquiryByMid (String mid);
	public List<Inquiry> selectInquiryByBid (String bid);
	public void deleteInquiryOne(int inum);
	public void insertInquiry(Inquiry inquiry);
	public Inquiry selectInquiryOne(int inum);
	public List<Inquiry> searchInquiryListByMid (HashMap<String, Object>param);
	public List<Inquiry> searchInquiryListByBid (HashMap<String, Object>param);
}
