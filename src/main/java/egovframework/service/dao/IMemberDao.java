package egovframework.service.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.model.Member;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("IMemberDao")
public class IMemberDao extends EgovAbstractMapper {
	
	private final Logger logger = LoggerFactory.getLogger(IMemberDao.class);
	
	@Resource(name = "egov.sqlSession")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}
	
	//ID 찾기
	public List<Member> findId(Member member);
	//비밀번호 찾기
	public Member findPw(Member member);
	//회원 등록
	public int insertMember(Member member);
	//회원 태그 등록
	public int insertMtag(Member member);
	//회원 태그 조회
	public List<Member> selectMtag(Member member);
	/**
	 * 회원 정보 조회
	 * 
	 * @param	Member
	 * @return	int
	 * @exception Exception
	 */
	public Member selectMember(Member vo)throws Exception {
		return selectOne("member.selectMember", vo);
	}
	//패널티 추가
	public int updateMpenalty(Member member);
}
