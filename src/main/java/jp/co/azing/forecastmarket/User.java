package jp.co.azing.forecastmarket;

/**
 * ���[�U�[���
 * 
 * @author fukuyama
 * 
 */
public class User {
	private int userNumber;
	private String loginId;
	private String password;
	private int point;
	private String name;
	private boolean manager;

	/**
	 * �R���X�g���N�^
	 * 
	 * @param userId
	 *            ���[�U�h��
	 * @param password
	 *            �p�X���[�h
	 * @param name
	 *            ���O
	 */
	public User(String userId, String password, String name) {
		this.loginId = userId;
		this.password = password;
		this.name = name;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

}
