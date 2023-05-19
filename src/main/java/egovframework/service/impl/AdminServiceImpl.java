package egovframework.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import egovframework.com.utils.FileUtils;
import egovframework.model.Admin;
import egovframework.model.Inquiry;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.service.AdminService;
import egovframework.service.dao.IAdminDao;

@Service("adminService")
public class AdminServiceImpl extends EgovAbstractServiceImpl implements AdminService {

	@Resource(name = "IAdminDao")
	private IAdminDao adminDao;

	@Value("${Globals.FilePath}")
    private String FilePath;

	// admin 하나만 검색
	public Admin selectAdminOne(Admin admin) throws Exception {
		return adminDao.selectAdminOne(admin);
	}

	// admin 타입 카운트
	public int selectAdminListCnt(Admin admin) throws Exception {
		return adminDao.selectAdminListCnt(admin);
	}

	// admin 여러개 검색
	public List<Admin> selectAdminList(Admin admin) throws Exception {
		return adminDao.selectAdminList(admin);
	}

	// 태그 추가
	public int insertTag(Admin admin) throws Exception {
		return adminDao.insertTag(admin);
	}
	
	// 태그 수정
	public int updateTag(Admin admin) throws Exception {
		return adminDao.updateTag(admin);
	}

	// 태그 삭제
	public int deleteTag(Admin admin) throws Exception {
		return adminDao.deleteTag(admin);
	}

	// 태그 추가(파일)
	public int insertTagFile(Admin admin, MultipartFile uploadFile) throws Exception {
		String filePath = FilePath + "admin\\";
		Map<String,Object> attachMap = FileUtils.uploadFile(filePath, uploadFile);
		String aimage = (String) attachMap.get("storedFileName");
		
		admin.setAimage(aimage);
		return adminDao.insertTag(admin);
	}

	// 전체 글 갯수
	public List<Inquiry> inquiryListCount() throws Exception {
		return adminDao.inquiryListCount();
	}

	// 글 상세보기
	public Inquiry selectInquiry(Inquiry inquiry) throws Exception {
		return adminDao.selectInquiry(inquiry);
	}

	// 답변 등록하기
	public int insertInquiryAnswer(Inquiry inquiry) throws Exception {
		return adminDao.insertInquiryAnswer(inquiry);
	}

	// 파일 경로 생성
	public File getAttachedFile(int anum) throws Exception {
		Admin vo = new Admin();
		vo.setAnum(anum);
		Admin admin = adminDao.selectAdminOne(vo);
		String fileName = admin.getAimage();
		String path = FilePath + "admin\\";
		return new File(path + fileName);
	}

}
