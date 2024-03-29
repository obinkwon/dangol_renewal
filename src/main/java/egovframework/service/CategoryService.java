package egovframework.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import egovframework.model.Admin;
import egovframework.model.Comment;
import egovframework.model.Details;
import egovframework.model.Grade;
import egovframework.model.Order;
import egovframework.model.Store;

public interface CategoryService {

	// 등급 정보 등록
	public int insertGrade(Grade grade) throws Exception ;

	// 예약하기 기능
	public int insertDetail(Details detail) throws Exception ;

	// 음식종류별 가게 리스트 가져오기
	public List<Store> getStoreListFood(Admin admin) throws Exception ;

	// 테마종류별 가게 리스트 가져오기
	public List<Store> getStoreListTheme(Admin admin) throws Exception ;

	// 지역별 가게 리스트 가져오기
	public List<Store> getStoreListArea(Admin admin) throws Exception ;

	// 추천별 가게 리스트 가져오기
	public List<Store> getStoreListRecommend(Admin admin) throws Exception ;

	// 신규 가게 리스트 가져오기
	public List<Store> getStoreListNew(Admin admin);

	// 음식 종류별 가게 갯수
	public int getStoreListCountFood(Admin admin);

	// 테마 종류별 가게 갯수
	public int getStoreListCountTheme(Admin admin);

	// 지역별 가게 갯수
	public int getStoreListCountArea(Admin admin);

	// 추천별 가게 갯수
	public int getStoreListCountRecommend(Admin admin);

	// 신규 가게 갯수
	public int getStoreListCountNew(Admin admin);

	// 가게 후기 총 평점 평균 리스트
	public List<Store> etcCount(List<Store> sList);

	// 가게 태그 세팅
	public List<Store> stagSetting(List<Store> sList);

	// 해당가게 내 등급
	public Grade selectMyGradeInfo(Grade grade) throws Exception ;

	// 후기 작성 정보 가져오기
	public Details getCommentInfo(Details details) throws Exception ;

	public List<Order> selectOrderList(Store store) throws Exception ;

	public Map<String, Object> selectDangolList(Store store) throws Exception ;

	// 해당 가게 태그 리스트
	public List<String[]> selectStagList(List<Store> sList);

	public Grade getGradeComment(Details details);

	public List<Comment> storeCommentList(Store store) throws Exception ;

	public List<Comment> storeMyCommentList(Grade grade);

	// 예약 리스트 가져오기
	public List<Details> todayReserve(Details detail) throws Exception ;

	// 후기 삭제 기능
	public void deleteComment(int cnum);

	public Comment selectComment(int cnum, int dnum);

	public Details getDetailOne(Details details) throws Exception ;

	public List<Admin> selectTasteTagList();

	public void updateComment(Comment comment);

	public int getStartPage(int page);

	public int getEndPage(int page);

	public int getLastPage(int storesPerPage, int storeCount);

	public int getOffset(int page, int boardsPerPage);

	public File getAttachedFile(int snum);

	public File getAttachedFileMenu(Order order) throws Exception;

	public Order selectOrderOne(Order order);

	// 메뉴 입력 부분
	public void insertStoreMenu();

	public int selectDetailsList(Grade grade);

}
