package jp.co.azing.forecastmarket;

/**
 * ユーザー情報.
 * 
 * @author fukuyama
 * 
 */
public final class User {
	/** ユーザー番号. */
	private int userNumber;
	/** ログインID. */
	private String loginId;
	/** パスワード. */
	private String password;
	/** ポイント. */
	private int point;
	/** 名前. */
	private String name;
	/** 管理者フラグ. */
	private boolean manager;

	/**
	 * コンストラクタ.
	 * 
	 * @param userId
	 *            ユーザＩｄ
	 * @param password
	 *            パスワード
	 * @param name
	 *            名前
	 */
	public User(String userId, String password, String name) {
		this.loginId = userId;
		this.password = password;
		this.name = name;
	}

	/**
	 * ユーザー番号取得.
	 * 
	 * @return ユーザー番号
	 */
	public int getUserNumber() {
		return userNumber;
	}

	/**
	 * ユーザー番号設定.
	 * 
	 * @param userNumber
	 *            ユーザー番号
	 */
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	/**
	 * ログインID取得.
	 * 
	 * @return ログインID
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * ログインID設定.
	 * 
	 * @param loginId
	 *            ログインID
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * パスワード取得.
	 * 
	 * @return パスワード
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * パスワード設定.
	 * 
	 * @param password
	 *            パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * ポイント取得.
	 * 
	 * @return ポイント
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * ポイント設定.
	 * 
	 * @param point
	 *            ポイント
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * 名前取得.
	 * 
	 * @return 名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名前設定.
	 * 
	 * @param name
	 *            名前
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 管理者かどうか判定.
	 * 
	 * @return 管理者の場合 true
	 */
	public boolean isManager() {
		return manager;
	}

	/**
	 * 管理者フラグ設定.
	 * 
	 * @param manager
	 *            フラグ
	 */
	public void setManager(boolean manager) {
		this.manager = manager;
	}

}
