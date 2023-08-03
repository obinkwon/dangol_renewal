package egovframework.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import egovframework.com.utils.FileUtils;
import egovframework.model.Login;
import egovframework.model.Member;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.service.MemberService;
import egovframework.service.dao.IAdminDao;
import egovframework.service.dao.IMemberDao;


@Service("memberService")
public class MemberServiceImpl extends EgovAbstractServiceImpl implements MemberService {

	@Resource(name = "IMemberDao")
	private IMemberDao memberDao;
	
	@Resource(name = "IAdminDao")
	private IAdminDao adminDao;
	
	@Value("${Globals.FilePath}")
    private String FilePath;

	public int loginMembers(Login login) throws Exception {
		Member member = new Member();
		member.setMid(login.getId());
		member = memberDao.selectMember(member);

		if (member != null) {
			if (member.getMpw().equals(login.getPwd()) && member.getMtype().equals("user")) {
				return 0; // 사용자 로그인 성공
			} else if (member.getMpw().equals(login.getPwd()) && member.getMtype().equals("admin")) {
				return 1; // 관리자 로그인 성공
			} else {
				return 2; // 비밀번호 틀림
			}
		} else { //등록된 id 없음
			return 3;
		}
	}
	
	// 사용자 검색
	public Member selectMember(Member member) throws Exception {
		return memberDao.selectMember(member);
	}

	//회원 가입
	public int insertMember(Member member, MultipartFile uploadFile) throws Exception{
		String filePath = FilePath + "member\\";
		Map<String,Object> attachMap = FileUtils.uploadFile(filePath, uploadFile);
		
		if(attachMap != null) {
			String mimage = (String) attachMap.get("storedFileName");
			member.setMimage(mimage);
		}
		
		return memberDao.insertMember(member);
	}
	
	public List<Member> findId(String phone) throws Exception{
		Member member = new Member();
		member.setMphone(phone);
		return memberDao.findId(member);
	}

	public Member findPw(Member member) throws Exception{
		return memberDao.findPw(member);
	}

	
	// 회원 태그 리스트 가져오기
	public List<Member> selectMtag(Member member) {
		return memberDao.selectMtag(member);
	}
	
	//회원 태그 등록
	public int insertMtag(Member member) {
		int result = 0;
		String mtag = member.getMtag();
		String mid = member.getMid();
		String[] mtagArr = mtag.split(",");
		for(String mt : mtagArr){
			Member m = new Member();
			m.setAnum(mt);
			m.setMid(mid);
			result += memberDao.insertMtag(m);
		}
		return result;
	}
	
	//회원 파일 경로 생성
	public File getAttachedFile(String mid) throws Exception{
		Member vo = new Member();
		vo.setMid(mid);
		Member member = memberDao.selectMember(vo);
		String fileName = member.getMimage();
		String path = FilePath + "member\\";
		return new File(path + fileName);
	}

}
