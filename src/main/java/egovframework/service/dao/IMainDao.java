package egovframework.service.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.model.Admin;
import egovframework.model.Comment;
import egovframework.model.Details;
import egovframework.model.Event;
import egovframework.model.Grade;
import egovframework.model.Store;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("IMainDao")
public class IMainDao extends EgovAbstractMapper {
	
	private final Logger logger = LoggerFactory.getLogger(IMainDao.class);
	
	@Resource(name = "egov.sqlSession")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}
	
	//지역별 가게 리스트
	public List<Store> selectStoreByArea(Store store);
	//지역별 가게 리스트 수
	public int getStoreByAreaCount(Store store);
	//총 지점수
	public int selectTotalStores();
	//총 회원수
	public int selectTotalMembers();
	//총 후기수
	public int selectTotalComments();
	//지역명 정보
	public List<Store> getAreaInfo();
	//지역명 상세 정보
	public List<Store> getAreaInfoDetail(Store store);
	
	
	
	
	public List<Store> selectSearchStoreAll(HashMap<String, Object> searchMap);
	public List<Store> selectStoreAll();
	public int[] selectStoreMemberBySnum();
	public int[] selectCommentMonth();
	public List<Grade> selectGradeBySnum(int snum);
	public List<Details> selectDetailAllByGnum(int gnum);
	public Comment selectCommentMonthByDnum(int dnum);
	public Comment selectCommentYearByDnum(int dnum);
	public List<Event> selectEventAll();
	public List<Admin> selectAdminMainTag();
	public Admin selectAdminByAvlaue(String avalue);
	public int getSearchStoreAllCount(HashMap<String, Object> params);
}
