package jp.co.azing.forecastmarket;

/**
 * ���[�U�[���.
 * 
 * @author fukuyama
 * 
 */
public final class User {
	/** ���[�U�[�ԍ�. */
	private int userNumber;
	/** ���O�C��ID. */
	private String loginId;
	/** �p�X���[�h. */
	private String password;
	/** �|�C���g. */
	private int point;
	/** ���O. */
	private String name;
	/** �Ǘ��҃t���O. */
	private boolean manager;

	/**
	 * �R���X�g���N�^.
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

	/**
	 * ���[�U�[�ԍ��擾.
	 * 
	 * @return ���[�U�[�ԍ�
	 */
	public int getUserNumber() {
		return userNumber;
	}

	/**
	 * ���[�U�[�ԍ��ݒ�.
	 * 
	 * @param userNumber
	 *            ���[�U�[�ԍ�
	 */
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	/**
	 * ���O�C��ID�擾.
	 * 
	 * @return ���O�C��ID
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * ���O�C��ID�ݒ�.
	 * 
	 * @param loginId
	 *            ���O�C��ID
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * �p�X���[�h�擾.
	 * 
	 * @return �p�X���[�h
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * �p�X���[�h�ݒ�.
	 * 
	 * @param password
	 *            �p�X���[�h
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * �|�C���g�擾.
	 * 
	 * @return �|�C���g
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * �|�C���g�ݒ�.
	 * 
	 * @param point
	 *            �|�C���g
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * ���O�擾.
	 * 
	 * @return ���O
	 */
	public String getName() {
		return name;
	}

	/**
	 * ���O�ݒ�.
	 * 
	 * @param name
	 *            ���O
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * �Ǘ��҂��ǂ�������.
	 * 
	 * @return �Ǘ��҂̏ꍇ true
	 */
	public boolean isManager() {
		return manager;
	}

	/**
	 * �Ǘ��҃t���O�ݒ�.
	 * 
	 * @param manager
	 *            �t���O
	 */
	public void setManager(boolean manager) {
		this.manager = manager;
	}

}
