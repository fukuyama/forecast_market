package jp.co.azing.forecastmarket;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ユーザ管理クラス
 * 
 * @author taneoka
 * 
 */
public class UserManager {
	/**
	 * ユーザリスト
	 */
	private List<User> users = new ArrayList<User>();

	/**
	 * ユーザ登録
	 * 
	 * @param loginId
	 *            ユーザＩＤ
	 * @param password
	 *            パスワード
	 * @param name
	 *            名前
	 * 
	 * @throws UserRegistException
	 *             ユーザー登録失敗
	 */
	public void regist(String loginId, String password, String name)
			throws UserRegistException {

		// userId のユーザが居るか確認
		if (existsUser(loginId)) {
			throw new UserRegistException();
		}

		// ユーザー情報作成
		User user = new User(loginId, password, name);

		// ユーザーリストから使用されていないユーザー番号を探す
		int userNumber = generateUserNumber();
		user.setUserNumber(userNumber);

		// リストにユーザー情報を追加
		users.add(user);
	}

	/**
	 * ユーザー番号生成. ユーザーリストから使用されていないユーザー番号を探す
	 * 
	 * @return
	 */
	private int generateUserNumber() {
		// ユーザーリストが空だったら
		if (users.isEmpty()) {
			// １を返す
			return 1;
		}
		// TODO: ループしすぎる問題あり
		// i を1からインクリメントしながらループ
		for (int i = 1; i <= Integer.MAX_VALUE; i++) {
			// ユーザーリストのループ
			for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
				User user = (User) iterator.next();
				// リストに入っているUserの番号を調べる
				// i と ユーザー番号を比較
				if (i == user.getUserNumber()) {
					// 同じだったらループおわり
					break;
				} else {
					// 違ったら
					if (!iterator.hasNext()) {
						// それが最後のユーザーか？
						// 最後のユーザーならi を返す
						return i;
					}
				}
			}
		}
		return 1;
	}

	private boolean existsUser(String userId) {
		try {
			getUser(userId);
			return true;
		} catch (UserNotFound e) {
			return false;
		}
	}

	/**
	 * 認証
	 * 
	 * @param userId
	 * @param password
	 * @return 認証結果　成功したらtrue　
	 */
	public boolean auth(String userId, String password) {
		if (userId == null || password == null) {
			return false;
		}

		// 手持ちのユーザリストに受け取ったuserIDがあるかを調べる
		try {
			User user = getUser(userId);
			// あれば、そいつの記録されてるpasswordと受け取ったpasswordを比較
			if (user.getPassword().equals(password)) {
				// 真なら、認証ＯＫ
				return true;
			}
			// 偽なら、認証ＮＧ
		} catch (UserNotFound e) {
			// なければ認証ＮＧ
		}

		return false;
	}

	/**
	 * ユーザ情報取得
	 * 
	 * @param userId
	 * @return　ユーザ情報　User
	 */
	public User getUser(String userId) throws UserNotFound {
		// リストから引数のユーザIDを持っているユーザを探す
		// // イテレータでリストをループさせる
		for (User user : users) {
			// // リストから取ってきたユーザのユーザIDと引数のユーザIDを比較
			if (user.getLoginId().equals(userId)) {
				// // 同じであればユーザを返す
				return user;
			}
		}
		// ユーザー見つからない
		throw new UserNotFound();
	}

	/**
	 * ユーザーの数
	 * 
	 * @return
	 */
	public int size() {
		return users.size();
	}

	/**
	 * ユーザー削除.
	 * 
	 * @param userId
	 * @param password
	 * @return 正否
	 */
	public boolean remove(String userId, String password) throws UserNotFound {
		// userId のユーザー情報を取得
		User user = getUser(userId);
		// ユーザー情報のパスワードが password と等しいか？
		if (user.getPassword().equals(password)) {
			// 等しい場合 users から userId のユーザー情報を削除
			return users.remove(user);
		}
		return false;
	}

}
