package egovframework.service.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import egovframework.model.Admin;
import egovframework.model.Comment;
import egovframework.model.Details;
import egovframework.model.Grade;
import egovframework.model.Order;
import egovframework.model.Store;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("ICategoryDao")
public class ICategoryDao extends EgovAbstractMapper {
	
	private final Logger logger = LoggerFactory.getLogger(ICategoryDao.class);
	
	@Resource(name = "egov.sqlSession")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}
	
	/**
	 * 해당가게 내 등급
	 * 
	 * @param
	 * @return Grade Grade
	 * @exception Exception
	 */
	public Grade selectGradeAtStore(Grade vo) throws Exception {
		return selectOne("category.selectGradeAtStore",vo);
	}
	
	/**
	 * 해당가게 메뉴 리스트
	 * 
	 * @param
	 * @return Store List
	 * @exception Exception
	 */
	public List<Order> selectOrderList(Store vo) throws Exception {
		return selectList("category.selectOrderList",vo);
	}
	
	/**
	 * 해당가게 리뷰 리스트(ing)
	 * 
	 * @param
	 * @return Store List
	 * @exception Exception
	 */
	public List<Comment> selectCommentListBySnum(Store vo) throws Exception {
		return selectList("category.selectCommentListBySnum",vo);
	}
	
	/**
	 * 해당가게 단골 정보
	 * 
	 * @param
	 * @return Store List
	 * @exception Exception
	 */
	public List<Grade> selectStoreGlevel(Store vo) throws Exception {
		return selectList("category.selectStoreGlevel",vo);
	}
	
	/**
	 * 해당가게 등급 등록
	 * 
	 * @param	Grade
	 * @return 	int
	 * @exception Exception
	 */
	public int insertGrade(Grade vo) throws Exception {
		return insert("category.insertGrade",vo);
	}
	
	/**
	 * 예약 리스트 가져오기
	 * 
	 * @param
	 * @return Details List
	 * @exception Exception
	 */
	public List<Details> selectDetailReserveByDdate(Details vo) throws Exception {
		return selectList("category.selectDetailReserveByDdate",vo);
	}
	
	/**
	 * 예약 하기
	 * 
	 * @param
	 * @return int List
	 * @exception Exception
	 */
	public int insertDetail(Details vo) throws Exception {
		return insert("category.insertDetail",vo);
	}
	
	/**
	 * 예약 정보 가져오기
	 * 
	 * @param
	 * @return int List
	 * @exception Exception
	 */
	public Details selectDetailOne(Details vo) throws Exception {
		return selectOne("category.selectDetailOne",vo);
	}
	
	/**
	 * 음식종류별 가게 리스트 가져오기
	 * 
	 * @param
	 * @return int List
	 * @exception Exception
	 */
	public List<Store> selectStoreListFood(Admin vo) throws Exception {
		return selectOne("category.selectStoreListFood",vo);
	}
	
	/**
	 * 테마별 가게 리스트 가져오기
	 * 
	 * @param
	 * @return int List
	 * @exception Exception
	 */
	public List<Store> selectStoreListTheme(Admin vo) throws Exception {
		return selectOne("category.selectStoreListTheme",vo);
	}
	
	/**
	 * 지역별 가게 리스트 가져오기
	 * 
	 * @param
	 * @return int List
	 * @exception Exception
	 */
	public List<Store> selectStoreListArea(Admin vo) throws Exception {
		return selectOne("category.selectStoreListArea",vo);
	}
	
	//추천별 가게 리스트 가져오기
	public List<Store> selectStoreListRecommend(Admin admin);
	//신규 가게 리스트 가져오기
	public List<Store> selectStoreListNew(Admin admin);
	//음식 종류별 가게 갯수
	public int getStoreListCountFood(Admin admin);
	//테마 종류별 가게 갯수
	public int getStoreListCountTheme(Admin admin);
	//지역별 가게 갯수
	public int getStoreListCountArea(Admin admin);
	//추천별 가게 갯수
	public int getStoreListCountRecommend(Admin admin);
	//신규 가게 갯수
	public int getStoreListCountNew(Admin admin);
	//가게별 리뷰 총점
	public int selectCommentTotal(Store store);
	//가게별 리뷰 갯수
	public int selectCommentTotalCnt(Store store);
	//후기 작성 정보
	public Details selectCommentInfo(Details details);
	//후기 작성자 등급 정보
	public Grade selectGradeComment(Details details);
	
	
	
	
	//
	public List<Details> selectDetailsListGnum(Grade grade);
	public List<Details> selectDetailAllByGnum(int gnum);
	public Comment selectCommentOneByDnum(int dnum);
	
	//
	public Admin selectAdminOne(int anum);
	
	public Order selectOrderOne(Order order);
	
	
	//내 리뷰 가져오기
	public List<Comment> selectMyCommentListByGrade(Grade grade);
	public void deleteCommentOneByCnum(int cnum);
	public Comment selectCommentByCnum(int cnum);
	public void updateDetailByDnum(int dnum);
	public List<Details> selectDetailByMidSnum(HashMap<String, Object> dMap);
	public void updateDcountMinusByDnum(int dnum);
	public int selectDetailMaxDcount(Grade grade);
	public List<Admin> selectAdminTasteTag();
	public void updateCommentOne(Comment comment);
	public Comment selectCommentByDnum(int dnum);
	public List<Store> selectKeywordStore(HashMap<String, Object> params);
}
