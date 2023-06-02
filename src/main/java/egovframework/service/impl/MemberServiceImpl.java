package egovframework.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import egovframework.model.Login;
import egovframework.model.Member;
import egovframework.service.MemberService;
import egovframework.service.dao.IAdminDao;
import egovframework.service.dao.IMemberDao;


@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Resource(name = "IMemberDao")
	private IMemberDao memberDao;
	
	@Autowired
	private IAdminDao adao;
	
	private String imagePath = "C:\\eclipse-workspace\\dangol\\WebContent\\images\\";

	public int loginMembers(Login login) throws Exception{
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

	public List<Member> findId(String phone) throws Exception{
		Member member = new Member();
		member.setMphone(phone);
		return mdao.findId(member);
	}

	public Member findPw(Member member) throws Exception{
		return mdao.findPw(member);
	}

	//회원 가입
	public int insertMember(Member member
			, MultipartFile mfile) throws Exception{
		String path = imagePath +"member\\";
		File dir = new File(path);
		if(!dir.exists()) dir.mkdirs();
		String mimage = "";
		if(mfile != null) {
			mimage = mfile.getOriginalFilename();
			if(!mimage.equals("")) {
				File attachFile = new File(path+mimage);
				mfile.transferTo(attachFile);  //웹으로 받아온 파일을 복사
			}
		}
		member.setMimage(mimage);//db에 파일 정보 저장을 하기위해 모델객체에 setting하기
		return mdao.insertMember(member);
	}
	
	// 회원 태그 리스트 가져오기
	public List<Member> selectMtag(Member member) {
		return mdao.selectMtag(member);
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
			result += mdao.insertMtag(m);
		}
		return result;
	}
	
	//회원 정보 가져오기
	public Member selectMember(Member member){
		return mdao.selectMember(member);
	}
	
	//회원 파일 경로 생성
	public File getAttachedFile(String mid) throws Exception{
		Member member = new Member();
		member.setMid(mid);
		member = mdao.selectMember(member);
		String fileName = member.getMimage();
		String path = imagePath + "member\\";
		return new File(path+fileName);
	}

}
