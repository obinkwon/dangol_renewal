package egovframework.service.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import egovframework.model.Admin;
import egovframework.model.Inquiry;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("IAdminDao")
public class IAdminDao extends EgovAbstractMapper {

	private final Logger logger = LoggerFactory.getLogger(IAdminDao.class);
	
	@Resource(name = "egov.sqlSession")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}
	
	//태그 부분
	/**
	 * admin 타입으로 리스트 검색
	 * 
	 * @param
	 * @return Admin Admin
	 * @exception Exception
	 */
	public Admin selectAdminTypeOne(Admin vo) throws Exception {
		return selectOne("admin.selectAdminTypeOne",vo);
	}
	
	/**
	 * admin 하나만 검색
	 * 
	 * @param
	 * @return Admin Admin
	 * @exception Exception
	 */
	public Admin selectAdminOne(Admin vo) throws Exception {
		return selectOne("admin.selectAdminOne",vo);
	}
	
	/**
	 * admin 여러개 검색(타입)
	 * 
	 * @param
	 * @return List Admin
	 * @exception Exception
	 */
	public List<Admin> selectAdminTypeList(Admin vo) throws Exception {
		return selectList("admin.selectAdminTypeList",vo);
	}
	
	/**
	 * admin 여러개 검색(mtag)
	 * 
	 * @param
	 * @return List Admin
	 * @exception Exception
	 */
	public List<Admin> selectAdminMtagList(Admin vo) throws Exception {
		return selectList("admin.selectAdminMtagList",vo);
	}
	
	/**
	 * 메인태그 수정
	 * 
	 * @param
	 * @return int Admin
	 * @exception Exception
	 */
	public int updateAdmin(Admin vo) throws Exception {
		return update("admin.updateAdmin",vo);
	}
	
	/**
	 * 태그 추가
	 * 
	 * @param
	 * @return int Admin
	 * @exception Exception
	 */
	public int insertTag(Admin vo) throws Exception {
		return insert("admin.insertTag",vo);
	}
	
	/**
	 * 태그 삭제
	 * 
	 * @param
	 * @return int Admin
	 * @exception Exception
	 */
	public int deleteTag(Admin vo) throws Exception {
		return delete("admin.deleteTag",vo);
	}

	// 1:1문의 부분
	/**
	 * 전체 글, 답변완료, 미완료 글 조회
	 * 
	 * @param
	 * @return List Inquiry
	 * @exception Exception
	 */
	public List<Inquiry> selectInquiryList(Inquiry vo) throws Exception {
		return selectList("admin.selectInquiryList",vo);
	}
	
	/**
	 * 전체 글 갯수
	 * 
	 * @param
	 * @return List 
	 * @exception Exception
	 */
	public List<Inquiry> inquiryListCount() throws Exception {
		return selectList("admin.inquiryListCount");
	}
	
	/**
	 * 글 상세보기
	 * 
	 * @param
	 * @return Inquiry Inquiry
	 * @exception Exception
	 */
	public Inquiry selectInquiry(Inquiry vo) throws Exception {
		return selectOne("admin.selectInquiry",vo);
	}
	
	/**
	 * 답변등록하기
	 * 
	 * @param
	 * @return int Inquiry
	 * @exception Exception
	 */
	public int insertInquiryAnswer(Inquiry vo) throws Exception {
		return insert("admin.insertInquiryAnswer",vo);
	}

}
