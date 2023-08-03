package egovframework.service.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import egovframework.model.Inquiry;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Repository("IInquiryDao")
public class IInquiryDao extends EgovAbstractMapper {
	
	private final Logger logger = LoggerFactory.getLogger(IInquiryDao.class);
	
	@Resource(name = "egov.sqlSession")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}

	/**
	 * 1:1문의 리스트 조회
	 * 
	 * @param	Inquiry
	 * @return 	List
	 * @exception Exception
	 */
	public List<Inquiry> selectInquiryList(Inquiry vo) throws Exception {
		return selectList("inquiry.selectInquiryList",vo);
	}
	
	/**
	 * 1:1문의 리스트 조회
	 * 
	 * @param	Inquiry
	 * @return 	int
	 * @exception Exception
	 */
	public int insertInquiry(Inquiry vo) throws Exception {
		return insert("inquiry.insertInquiry", vo);
	}
	
	public void deleteInquiryOne(int inum);
	public Inquiry selectInquiryOne(int inum);
	public List<Inquiry> searchInquiryListByMid (HashMap<String, Object>param);
	public List<Inquiry> searchInquiryListByBid (HashMap<String, Object>param);
}
