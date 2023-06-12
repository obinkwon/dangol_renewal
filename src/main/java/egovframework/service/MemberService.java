package egovframework.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import egovframework.model.Login;
import egovframework.model.Member;

public interface MemberService {

	/**
	 * 사용자 로그인
	 * 
	 * @param	Login
	 * @return  int
	 * @exception Exception
	 */
	public int loginMembers(Login login) throws Exception;
	
	/**
	 * 회원 정보 가져오기
	 * 
	 * @param	Member
	 * @return  Member
	 * @exception Exception
	 */
	public Member selectMember(Member member) throws Exception;

	public List<Member> findId(String phone) throws Exception;

	public Member findPw(Member member) throws Exception;

	//회원 가입
	public int insertMember(Member member, MultipartFile mfile) throws Exception;
	
	// 회원 태그 리스트 가져오기
	public List<Member> selectMtag(Member member);
	
	//회원 태그 등록
	public int insertMtag(Member member);
	
	//회원 파일 경로 생성
	public File getAttachedFile(String mid) throws Exception;

}
