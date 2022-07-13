package egovframework.dao;

import java.util.List;

import egovframework.model.Admin;
import egovframework.model.Inquiry;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("IAdminDao")
public interface IAdminDao {

	// 태그
	// admin 타입으로 리스트 검색
	public Admin selectAdminTypeOne(Admin admin);

	// admin 하나만 검색
	public Admin selectAdminOne(Admin admin);

	// admin 여러개 검색(타입)
	public List<Admin> selectAdminTypeList(Admin admin);

	// admin 여러개 검색(mtag)
	public List<Admin> selectAdminMtagList(Admin admin);

	// 메인태그 수정
	public int updateAdmin(Admin admin);

	// 태그 추가
	public int insertTag(Admin admin);

	// 태그 삭제
	public int deleteTag(Admin admin);

	// 1:1문의
	// 전체 글, 답변완료, 미완료 글 조회
	public List<Inquiry> selectInquiryList(Inquiry inquiry);

	// 전체 글 갯수
	public List<Inquiry> inquiryListCount();

	// 글 상세보기
	public Inquiry selectInquiry(Inquiry inquiry);

	// 답변등록하기
	public int insertInquiryAnswer(Inquiry inquiry);

}
