package egovframework.service.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.model.Inquiry;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("IInquiryDao")
public class IInquiryDao extends EgovAbstractMapper {
	
	private final Logger logger = LoggerFactory.getLogger(IInquiryDao.class);
	
	@Resource(name = "egov.sqlSession")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}

	public List<Inquiry> selectInquiryByMid (String mid);
	public List<Inquiry> selectInquiryByBid (String bid);
	public void deleteInquiryOne(int inum);
	public void insertInquiry(Inquiry inquiry);
	public Inquiry selectInquiryOne(int inum);
	public List<Inquiry> searchInquiryListByMid (HashMap<String, Object>param);
	public List<Inquiry> searchInquiryListByBid (HashMap<String, Object>param);
}
