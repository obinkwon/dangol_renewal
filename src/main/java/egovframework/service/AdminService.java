package egovframework.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import egovframework.model.Admin;
import egovframework.model.Inquiry;


public interface AdminService {
	
	//admin 하나만 검색
	public Admin selectAdminOne(Admin admin);
	
	//admin 하나만 검색 (타입)
	public Admin selectAdminTypeOne(Admin admin);
	
	//admin 여러개 검색 (타입)
	public List<Admin> selectAdminTypeList(Admin admin);
	
	//admin 여러개 검색 (mtag)
	public List<Admin> selectAdminMtagList(Admin admin);
	
	//메인 태그 수정
	public int updateAdmin(Admin admin);
	
	//태그 추가
	public int insertTag(Admin admin);
	
	//태그 삭제
	public int deleteTag(Admin admin);

	//태그 추가(파일)
	public int insertTagFile(Admin admin, MultipartFile afile) throws Exception;
	
	//1:1문의 
	//전체 글 로드
	public List<Inquiry> selectInquiryList(Inquiry inquiry);
	//전체 글 갯수
	public List<Inquiry> inquiryListCount();
	
	//글 상세보기
	public Inquiry selectInquiry(Inquiry inquiry);
	
	//답변 등록하기
	public int insertInquiryAnswer(Inquiry inquiry);

	//파일 경로 생성
	public File getAttachedFile(int anum);
	
	public File insertFile(MultipartFile afile);

}
