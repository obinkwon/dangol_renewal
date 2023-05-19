package egovframework.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import egovframework.model.Admin;
import egovframework.model.Inquiry;


public interface AdminService {
	
	/**
	 * admin 하나만 검색
	 * 
	 * @param	Admin
	 * @return  Admin
	 * @exception Exception
	 */
	public Admin selectAdminOne(Admin admin) throws Exception;
	
	/**
	 * admin 카운트
	 * 
	 * @param	Admin
	 * @return  int
	 * @exception Exception
	 */
	public int selectAdminListCnt(Admin admin) throws Exception;
	
	/**
	 * admin 여러개 검색
	 * 
	 * @param	Admin
	 * @return  List
	 * @exception Exception
	 */
	public List<Admin> selectAdminList(Admin admin) throws Exception;
	
	/**
	 * 태그 추가
	 * 
	 * @param	Admin
	 * @return  int
	 * @exception Exception
	 */
	public int insertTag(Admin admin) throws Exception;
	
	/**
	 * 태그 수정
	 * 
	 * @param	Admin
	 * @return  int
	 * @exception Exception
	 */
	public int updateTag(Admin admin) throws Exception;
	
	/**
	 * 태그 삭제
	 * 
	 * @param	Admin
	 * @return  int
	 * @exception Exception
	 */
	public int deleteTag(Admin admin) throws Exception;
	
	/**
	 * 태그 추가(파일)
	 * 
	 * @param	Admin, MultipartFile
	 * @return  int
	 * @exception Exception
	 */
	public int insertTagFile(Admin admin, MultipartFile afile) throws Exception;

	//1:1문의 
	//전체 글 갯수
	public List<Inquiry> inquiryListCount() throws Exception;
	
	//글 상세보기
	public Inquiry selectInquiry(Inquiry inquiry) throws Exception;
	
	//답변 등록하기
	public int insertInquiryAnswer(Inquiry inquiry) throws Exception;

	//파일 경로 생성
	public File getAttachedFile(int anum) throws Exception;
	
}
