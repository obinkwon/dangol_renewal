package egovframework.model;

public class Login {
	private String id;
    private String pwd;
    private String loginUser;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}
	
	@Override
	public String toString() {
		return "Login [id=" + id + ", pwd=" + pwd + ", loginUser=" + loginUser + "]";
	}
}
