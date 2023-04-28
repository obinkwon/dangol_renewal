package egovframework.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.model.Admin;
import egovframework.model.Comment;
import egovframework.model.Details;
import egovframework.model.Event;
import egovframework.model.Grade;
import egovframework.model.Store;
import egovframework.service.dao.IMainDao;
import egovframework.service.dao.IOwnerDao;


@Service
public class MainService {
	
	@Autowired
	private IMainDao maDao;
	
	@Autowired
	private IOwnerDao oDao;
	
	//지역별 가게 리스트
	public List<Store> areaStoreList(Store store){
		return maDao.selectStoreByArea(store);
	}
	
	//지역별 가게 리스트 수
	public int areaStoreListCnt(Store store) {
		return maDao.getStoreByAreaCount(store);
	}
	
	//총 카운트 리스트
	public HashMap<String, Integer> infoStoreCount() {
		HashMap<String, Integer> infoMap = new HashMap<String, Integer>();
		infoMap.put("storeCount", maDao.selectTotalStores());
		infoMap.put("userCount", maDao.selectTotalMembers());
		infoMap.put("reviewCount", maDao.selectTotalComments());
		return infoMap;
	}
	
	public int selectBestStore() {
		int[] snumList = maDao.selectStoreMemberBySnum();
		if(snumList.length!=0) {
			Store store = new Store();
			store.setSnum(snumList[0]);
			Store s = oDao.selectStoreOne(store);
			if(s.getSimage()==null) return 758059;
			else return s.getSnum();
		}
		else return 758059;
	}
	
	public List<HashMap<String, Object>> selectMonthStore() {//이달의 별점 평균이 제일 높은 매장
		List<HashMap<String, Object>> storeMapList = new ArrayList<HashMap<String, Object>>();
		List<Store> sList = maDao.selectStoreAll();
		for(Store s: sList) {
			int sum = 0;
			double ctotalAvg = 0;
			HashMap<String, Object> storeMap = new HashMap<String, Object>();
			storeMap.put("snum", s.getSnum());
			List<Grade> gList = maDao.selectGradeBySnum(s.getSnum());
			if(gList.size()!=0) {
				for(Grade g : gList) {
					List<Details> dList = maDao.selectDetailAllByGnum(g.getGnum());
					for(Details d : dList) {
						Comment c = maDao.selectCommentMonthByDnum(d.getDnum());
						if(c!=null) sum += c.getCtotal();
					}
				}
				ctotalAvg = sum/gList.size();
				storeMap.put("ctotalAvg", ctotalAvg);
				storeMapList.add(storeMap);
			}
		}
		return storeMapList;
	}
	
	public List<HashMap<String, Object>> selectYearStore() {//올해의 별점 평균이 제일 높은 매장
		List<HashMap<String, Object>> storeMapList = new ArrayList<HashMap<String, Object>>();
		List<Store> sList = maDao.selectStoreAll();
		for(Store s: sList) {
			int sum = 0;
			double ctotalAvg = 0;
			HashMap<String, Object> storeMap = new HashMap<String, Object>();
			storeMap.put("snum", s.getSnum());
			List<Grade> gList = maDao.selectGradeBySnum(s.getSnum());
			if(gList.size()!=0) {
				for(Grade g : gList) {
					List<Details> dList = maDao.selectDetailAllByGnum(g.getGnum());
					for(Details d : dList) {
						Comment c = maDao.selectCommentYearByDnum(d.getDnum());
						if(c!=null) sum += c.getCtotal();
					}
				}
				ctotalAvg = sum/gList.size();
				storeMap.put("ctotalAvg", ctotalAvg);
				storeMapList.add(storeMap);
			}
		}
		return storeMapList;
	}
	
	public Event selectEventBanner() {
		List<Event> eList = maDao.selectEventAll();
		if(eList.size()!=0) return eList.get(0);
		else return null;
	}
	
	public HashMap<String, Object> searchMain(String keyword, int page, int storesPerPage) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		int offset = getOffset(page, storesPerPage);
		params.put("offset",offset);
		params.put("storesPerPage", storesPerPage);
		params.put("keyword", keyword);
		result.put("sList", maDao.selectSearchStoreAll(params));
		result.put("current",page);
		result.put("start", getStartPage(page));
		result.put("end", getEndPage(page));
		result.put("last", getLastPage(storesPerPage,maDao.getSearchStoreAllCount(params)));
		result.put("totalBoard", maDao.getSearchStoreAllCount(params));
		return result;
	}
	
	public HashMap<String, String> selectMainTag(){
		HashMap<String, String> mainTagMap = new HashMap<String, String>();
		List<Admin> aList = maDao.selectAdminMainTag();
		if(aList != null && aList.size() > 0) {
			mainTagMap.put("main1", aList.get(0).getAvalue());
			mainTagMap.put("main2", aList.get(1).getAvalue());
		}
		return mainTagMap; 
	}
	
	public HashMap<String, Integer> selectMainTagNum(){
		HashMap<String, Integer> mainTagMap = new HashMap<String, Integer>();
		List<Admin> aList = maDao.selectAdminMainTag();
		if(aList != null && aList.size() > 0) {
			Admin a = maDao.selectAdminByAvlaue(aList.get(0).getAvalue());
			mainTagMap.put("main1", a.getAnum());
			a = maDao.selectAdminByAvlaue(aList.get(1).getAvalue());
			if(a!=null) mainTagMap.put("main2", a.getAnum());
		}
		return mainTagMap;
	}
	
	//페이징 부분
	public Admin getPaging(Admin admin,int resultSize) {
		int page = admin.getPage();
		int storesPerPage = admin.getStoresPerPage();
		
		int offset = getOffset(page, storesPerPage);
		int startPage = getStartPage(page);
		int endPage = getEndPage(page);
		int lastPage = getLastPage(storesPerPage,resultSize);
		admin.setOffset(offset);
		admin.setStartPage(startPage);
		admin.setEndPage(endPage);
		admin.setLastPage(lastPage);
		return admin;
	}
	
	//지역 정보
	public List<Store> getAreaInfo(){
		return maDao.getAreaInfo();
	}
	
	//지역 상세 정보
	public List<Store> getAreaInfoDetail(Store store){
		return maDao.getAreaInfoDetail(store);
	}
	
	public int getStartPage(int page) {
		// 현재페이지-((현재페이지-1)%네비게이터 블록 크기)
		return page-((page-1)%10);
		
	}

	public int getEndPage(int page) {
		// 네비게이터의 첫번째 페이지 번호 + (네비게이터 블록 크기 -1)
		return page-((page-1)%10) + (10-1);

	}

	public int getLastPage(int storesPerPage, int storeCount) {
		return (storeCount-1)/storesPerPage + 1;
	}

	public int getOffset(int page, int boardsPerPage) {
		//offset : 해당 페이지에서 가져올 게시물의 시작점
		return (page-1)*boardsPerPage + 1;
	}
	
}
