package jp.co.azing.forecastmarket;

import jp.co.azing.forecastmarket.User;
import jp.co.azing.forecastmarket.UserManager;
import jp.co.azing.forecastmarket.UserNotFound;
import jp.co.azing.forecastmarket.UserRegistException;
import junit.framework.TestCase;

public class UserManagerTest extends TestCase {

	public void testRegist() throws UserNotFound {
		// ユーザー管理インスタンス
		UserManager mgr = new UserManager();
		String userId = "aaa";// ユーザＩＤ
		String password = "bbb";// パスワード
		String name = "imamura";// 名前

		try {
			mgr.regist(userId, password, name); // 登録
		} catch (UserRegistException e) {
			assertTrue(false);
		}

		assertTrue(mgr.auth(userId, password));// 認証

		User user = mgr.getUser(userId);// ユーザーＩＤのユーザー情報を取得
		assertNotNull(user);// 取れたか確認
		assertEquals(user.getName(), name); // 内容確認
		int userNumber = user.getUserNumber(); // ユーザー番号が０だった。
		assertEquals(1, userNumber);
	}

	public void testRegist01() throws UserNotFound {
		// ユーザー管理インスタンス
		UserManager mgr = new UserManager();

		try {
			mgr.regist("user00", "test", "imamura"); // 登録
			assertEquals(1, mgr.size());
		} catch (UserRegistException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		try {
			mgr.regist("user01", "test", "fukuyama"); // 登録
			assertEquals(2, mgr.size());
		} catch (UserRegistException e) {
			e.printStackTrace();
			assertTrue(false);
		}

		User user = null;

		user = mgr.getUser("user01");// ユーザーＩＤのユーザー情報を取得
		assertNotNull(user);// 取れたか確認
		assertEquals(user.getName(), "fukuyama"); // 内容確認
		assertEquals(2, user.getUserNumber());

		user = mgr.getUser("user00");// ユーザーＩＤのユーザー情報を取得
		assertNotNull(user);// 取れたか確認
		assertEquals(user.getName(), "imamura"); // 内容確認
		assertEquals(1, user.getUserNumber());
	}

	public void testRegist02() {
		// ユーザー管理インスタンス
		UserManager mgr = new UserManager();

		try {
			mgr.regist("user00", "test", "imamura"); // 登録
			assertEquals(1, mgr.size());
		} catch (UserRegistException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		try {
			mgr.regist("user01", "test", "fukuyama"); // 登録
			assertEquals(2, mgr.size());
		} catch (UserRegistException e) {
			e.printStackTrace();
			assertTrue(false);
		}

		User user = null;
		try {
			user = mgr.getUser("user02");
			assertTrue(false);
		} catch (UserNotFound e) {
		}
		assertNull(user);// 取れたか確認（取れないのが正解）
	}

	/**
	 * 重複ユーザーのテスト
	 * 
	 * @throws Exception
	 */
	public void testResistUserDup() throws Exception {
		// ユーザー管理インスタンス
		UserManager mgr = new UserManager();
		String userId = "aaa";// ユーザＩＤ
		String password = "bbb";// パスワード
		String name = "imamura";// 名前

		try {
			mgr.regist(userId, password, name); // 登録
			assertEquals(1, mgr.size());
		} catch (UserRegistException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		try {
			mgr.regist(userId, password, name); // 登録
			assertTrue(false);
		} catch (UserRegistException e) {
		}
		assertEquals(1, mgr.size());

	}

	public void testAuthTrue() throws Exception {
		// ユーザー管理インスタンス
		UserManager mgr = new UserManager();
		String userId = "aaa";// ユーザＩＤ
		String password = "bbb";// パスワード

		try {
			mgr.regist(userId, password, "aaaaa"); // 登録
		} catch (UserRegistException e) {
		}

		boolean answer = mgr.auth(userId, new String("bbb"));
		assertTrue(answer);

	}

	public void testAuthFalse() throws Exception {
		// ユーザー管理インスタンス
		UserManager mgr = new UserManager();
		String userId = "aaa";// ユーザＩＤ
		String password = "bbb";// パスワード

		boolean answer = mgr.auth(userId, password);
		assertFalse(answer);

	}

	public void testAuthFalse01() throws Exception {
		// ユーザー管理インスタンス
		UserManager mgr = new UserManager();
		String userId = "aaa";// ユーザＩＤ
		String password = "bbs";// パスワード

		try {
			mgr.regist(userId, password, "aaaaa"); // 登録
		} catch (UserRegistException e) {
		}

		boolean answer = mgr.auth(userId, new String("bbb"));
		assertFalse(answer);
	}

	public void testAuthFalse02() throws Exception {
		// ユーザー管理インスタンス
		UserManager mgr = new UserManager();
		String userId = "aaa";// ユーザＩＤ
		String password = "bbb";// パスワード

		try {
			mgr.regist(userId, password, "aaaaa"); // 登録
		} catch (UserRegistException e) {
		}

		boolean answer = mgr.auth("popo", new String("bbb"));
		assertFalse(answer);

	}

	public void testAuthFalse03() throws Exception {
		// ユーザー管理インスタンス
		UserManager mgr = new UserManager();
		String userId = "aaa";// ユーザＩＤ
		String password = "bbs";// パスワード

		try {
			mgr.regist(userId, password, "aaaaa"); // 登録
		} catch (UserRegistException e) {
		}

		boolean answer = mgr.auth(null, new String("bbs"));
		assertFalse(answer);
	}

	public void testAuthFalse04() throws Exception {
		// ユーザー管理インスタンス
		UserManager mgr = new UserManager();
		String userId = "aaa";// ユーザＩＤ
		String password = "bbb";// パスワード

		try {
			mgr.regist(userId, password, "aaaaa"); // 登録
		} catch (UserRegistException e) {
		}

		boolean answer = mgr.auth("aaa", null);
		assertFalse(answer);

	}

	public void testRemoveUserNotFound() throws Exception {
		// ユーザー管理インスタンス
		UserManager mgr = new UserManager();
		String userId = "aaa";// ユーザＩＤ
		String password = "bbb";// パスワード

		try {
			boolean answer = mgr.remove(userId, password);
			assertTrue(false);
		} catch (UserNotFound e) {
			assertTrue(true);
		}
	}

	public void testRemoveTrue01() throws Exception {
		// ユーザー管理インスタンス
		UserManager mgr = new UserManager();
		try {
			mgr.regist("user00", "test", "imamura"); // 登録
			assertEquals(1, mgr.size());
		} catch (UserRegistException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		try {
			boolean answer = mgr.remove("user00", "test"); // 削除
			assertTrue(answer);
		} catch (UserNotFound e) {
			assertTrue("通っちゃだめ", false);
		}

		try {
			mgr.getUser("user00");
			assertTrue("通っちゃだめ", false);
		} catch (Exception e) {
			assertTrue(e instanceof UserNotFound);
		}

	}

	public void testRemoveTrue02() throws Exception {
		// ユーザー管理インスタンス
		UserManager mgr = new UserManager();
		try {
			mgr.regist("user00", "test", "imamura"); // 登録
			assertEquals(1, mgr.size());
		} catch (UserRegistException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		try {
			mgr.regist("user01", "test", "imamura"); // 登録
			assertEquals(2, mgr.size());
		} catch (UserRegistException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		try {
			boolean answer = mgr.remove("user00", "test"); // 削除
			assertTrue(answer);
			assertEquals(1, mgr.size());
		} catch (UserNotFound e) {
			assertTrue("通っちゃだめ", false);
		}

		try {
			mgr.getUser("user00");
			assertTrue("通っちゃだめ", false);
		} catch (Exception e) {
			assertTrue(e instanceof UserNotFound);
		}

	}
}
