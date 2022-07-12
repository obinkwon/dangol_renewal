package egovframework.dangol.dao;

import java.util.List;

import egovframework.dangol.model.Details;
import egovframework.dangol.model.Grade;
import egovframework.dangol.model.Order;
import egovframework.dangol.model.Store;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("IOwnerDao")
public interface IOwnerDao {
	/* 점장 */
	//점장 정보 조회
	public Store selectBossOne(Store store);
	//점장 ID 조회
	public List<Store> findOwnerId(Store store);
	//점장 PWD 조회
	public Store findOwnerPw(Store store);
	//점장 가입
	public int insertOwner(Store store);
	//점장 탈퇴
	public int deleteOwner(Store store);
	//점장 수정
	public int updateOwner(Store store);
	//메뉴 등록
	public void insertOrder(Order order);
	
	/* 예약 */
	//가게에 등록된 등급 정보
	public List<Grade> selectGradeListBid(Store store);
	//예약 리스트(전체)
	public List<Details> selectDetailListTotal(Store store);
	//예약 리스트(하나만)
	public List<Details> selectDetailListOne(Store store);
	//예약 정보
	public Details selectDetailOne(Details details);
	//멤버쉽 적용
	public int updateDetail(Details details);
	
	/* 점장 가게*/
	//가게 리스트 가져오기
	public List<Store> selectStoreList(Store store); 
	//가게 등록
	public int insertStore(Store store); 
	//가게 태그 등록
	public int insertStag(Store store); 
	//가게 태그 등록
	public int deleteStag(Store store); 
	//가게 태그 리스트
	public List<Store> selectStagList(Store store); 
	//가게 정보 가져오기
	public Store selectStoreOne(Store store); 
	//가게 수정하기
	public int updateStore(Store store); 
	//가게 삭제하기
	public int deleteStore(Store store); 
	//메뉴 등록
	public int insertMenu(Order order); 
	//메뉴 삭제
	public int deleteMenu(Order order); 
	//메뉴 수정
	public int updateMenu(Order order); 

	
	 
}
