package egovframework.service.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
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
	
	@Resource(name = "egov.sqlSession")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}
	
	//해당가게 내 등급
	public Grade selectGradeAtStore(Grade grade);
	//해당가게 메뉴 리스트
	public List<Order> selectOrderList(Store store);
	//해당가게 리뷰 리스트(ing)
	public List<Comment> selectCommentListBySnum(Store store);
	//해당가게 단골 정보
	public List<Grade> selectStoreGlevel(Store store);
	//해당가게 등급 등록
	public int insertGrade(Grade grade);
	//예약 리스트 가져오기
	public List<Details> selectDetailReserveByDdate(Details detail);
	//예약 하기
	public int insertDetail(Details details);
	//예약 정보 가져오기
	public Details selectDetailOne(Details details);
	//음식종류별 가게 리스트 가져오기
	public List<Store> selectStoreListFood(Admin admin);
	//테마별 가게 리스트 가져오기
	public List<Store> selectStoreListTheme(Admin admin);
	//지역별 가게 리스트 가져오기
	public List<Store> selectStoreListArea(Admin admin);
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
