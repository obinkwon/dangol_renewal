package egovframework.service.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.model.Comment;
import egovframework.model.Details;
import egovframework.model.Grade;
import egovframework.model.Member;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("IMyPageDao")
public class IMyPageDao extends EgovAbstractMapper {
	
	private final Logger logger = LoggerFactory.getLogger(IMyPageDao.class);
	
	@Resource(name = "egov.sqlSession")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}
	
	//회원 수정
	public int updateMemberOne (Member member);
	//회원 태그 삭제
	public int deleteMtag(Member member);
	//회원 삭제
	public int deleteMemberOne (Member member);
	//방문내역 리스트
	public List<Details> selectHistoryList(Member member);
	//즐겨찾기 리스트
	public List<Details> selectBookmarkList(Member member);
	//즐겨찾기 수정
	public int updateLike(Member member);
	//예약 날짜 조회
	public Details selectddate(Details details);
	//예약 삭제
	public int deleteReserve(Details details);
	//나의 등급 정보 리스트
	public List<Grade> selectGradeList(Member member);
	//등급 강등 and  포인트 절감
	public int updateGrade(Grade grade);
	//예약 리스트
	public List<Details> selectReserveState (Member member);
	//후기 작성 여부 수정
	public int updatedetailsComment(Details details);
	//후기 작성
	public int insertComment(Comment comment);
	//등급 업데이트
	public int updateGradeInfo(Grade grade);
	//후기 카운트 업데이트
	public void updateGradeCount(Grade grade);
	
}
