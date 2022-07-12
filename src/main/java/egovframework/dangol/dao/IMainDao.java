package egovframework.dangol.dao;

import java.util.HashMap;
import java.util.List;

import egovframework.dangol.model.Admin;
import egovframework.dangol.model.Comment;
import egovframework.dangol.model.Details;
import egovframework.dangol.model.Event;
import egovframework.dangol.model.Grade;
import egovframework.dangol.model.Store;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("IMainDao")
public interface IMainDao {
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
