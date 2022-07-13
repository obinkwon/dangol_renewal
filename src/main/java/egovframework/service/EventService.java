package egovframework.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import egovframework.model.Event;
import egovframework.model.Store;

public interface EventService {

	// 일반 사용자의 이벤트 보기
	public Store selectStoreBySnum(int snum);

	// (사장님)가게 목록 드롭다운
	public List<Store> selectStoresByBid(String bid);

	// 일반 사용자의 이벤트 보기
	public List<Event> selectEventsByStatus(Event event);

	// 전체 이벤트 목록 출력
	public List<Event> selectEventsByStatusAndSnums(String status, int[] snums);

	// 전체 이벤트 중 하나의 이벤트 상세내용 보기
	public Event selectOneEvent(int eid);

	// ed (사장님) 이벤트 내 추가
	public void insertEvent(Event event, MultipartFile efile) throws Exception;

	// (사장님) 이벤트 수정
	public int updateEvent(Event event, MultipartFile efile) throws Exception;

	// (사장님) 이벤트 삭제
	public int deleteEvent(int eid);

	// 사장님에 따라 수정, 삭제 버튼생성
	public boolean checkAuthority(String bid, int eid);

	// 파일 경로 생성
	public File getAttachedFile(int eid);

}
