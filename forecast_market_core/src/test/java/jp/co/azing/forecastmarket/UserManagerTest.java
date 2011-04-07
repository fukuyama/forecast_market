package jp.co.azing.forecastmarket;

import jp.co.azing.forecastmarket.User;
import jp.co.azing.forecastmarket.UserManager;
import jp.co.azing.forecastmarket.UserNotFound;
import jp.co.azing.forecastmarket.UserRegistException;
import junit.framework.TestCase;

public class UserManagerTest extends TestCase {

	public void testRegist() throws UserNotFound {
		// ���[�U�[�Ǘ��C���X�^���X
		UserManager mgr = new UserManager();
		String userId = "aaa";// ���[�U�h�c
		String password = "bbb";// �p�X���[�h
		String name = "imamura";// ���O

		try {
			mgr.regist(userId, password, name); // �o�^
		} catch (UserRegistException e) {
			assertTrue(false);
		}

		assertTrue(mgr.auth(userId, password));// �F��

		User user = mgr.getUser(userId);// ���[�U�[�h�c�̃��[�U�[�����擾
		assertNotNull(user);// ��ꂽ���m�F
		assertEquals(user.getName(), name); // ���e�m�F
		int userNumber = user.getUserNumber(); // ���[�U�[�ԍ����O�������B
		assertEquals(1, userNumber);
	}

	public void testRegist01() throws UserNotFound {
		// ���[�U�[�Ǘ��C���X�^���X
		UserManager mgr = new UserManager();

		try {
			mgr.regist("user00", "test", "imamura"); // �o�^
			assertEquals(1, mgr.size());
		} catch (UserRegistException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		try {
			mgr.regist("user01", "test", "fukuyama"); // �o�^
			assertEquals(2, mgr.size());
		} catch (UserRegistException e) {
			e.printStackTrace();
			assertTrue(false);
		}

		User user = null;

		user = mgr.getUser("user01");// ���[�U�[�h�c�̃��[�U�[�����擾
		assertNotNull(user);// ��ꂽ���m�F
		assertEquals(user.getName(), "fukuyama"); // ���e�m�F
		assertEquals(2, user.getUserNumber());

		user = mgr.getUser("user00");// ���[�U�[�h�c�̃��[�U�[�����擾
		assertNotNull(user);// ��ꂽ���m�F
		assertEquals(user.getName(), "imamura"); // ���e�m�F
		assertEquals(1, user.getUserNumber());
	}

	public void testRegist02() {
		// ���[�U�[�Ǘ��C���X�^���X
		UserManager mgr = new UserManager();

		try {
			mgr.regist("user00", "test", "imamura"); // �o�^
			assertEquals(1, mgr.size());
		} catch (UserRegistException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		try {
			mgr.regist("user01", "test", "fukuyama"); // �o�^
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
		assertNull(user);// ��ꂽ���m�F�i���Ȃ��̂������j
	}

	/**
	 * �d�����[�U�[�̃e�X�g
	 * 
	 * @throws Exception
	 */
	public void testResistUserDup() throws Exception {
		// ���[�U�[�Ǘ��C���X�^���X
		UserManager mgr = new UserManager();
		String userId = "aaa";// ���[�U�h�c
		String password = "bbb";// �p�X���[�h
		String name = "imamura";// ���O

		try {
			mgr.regist(userId, password, name); // �o�^
			assertEquals(1, mgr.size());
		} catch (UserRegistException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		try {
			mgr.regist(userId, password, name); // �o�^
			assertTrue(false);
		} catch (UserRegistException e) {
		}
		assertEquals(1, mgr.size());

	}

	public void testAuthTrue() throws Exception {
		// ���[�U�[�Ǘ��C���X�^���X
		UserManager mgr = new UserManager();
		String userId = "aaa";// ���[�U�h�c
		String password = "bbb";// �p�X���[�h

		try {
			mgr.regist(userId, password, "aaaaa"); // �o�^
		} catch (UserRegistException e) {
		}

		boolean answer = mgr.auth(userId, new String("bbb"));
		assertTrue(answer);

	}

	public void testAuthFalse() throws Exception {
		// ���[�U�[�Ǘ��C���X�^���X
		UserManager mgr = new UserManager();
		String userId = "aaa";// ���[�U�h�c
		String password = "bbb";// �p�X���[�h

		boolean answer = mgr.auth(userId, password);
		assertFalse(answer);

	}

	public void testAuthFalse01() throws Exception {
		// ���[�U�[�Ǘ��C���X�^���X
		UserManager mgr = new UserManager();
		String userId = "aaa";// ���[�U�h�c
		String password = "bbs";// �p�X���[�h

		try {
			mgr.regist(userId, password, "aaaaa"); // �o�^
		} catch (UserRegistException e) {
		}

		boolean answer = mgr.auth(userId, new String("bbb"));
		assertFalse(answer);
	}

	public void testAuthFalse02() throws Exception {
		// ���[�U�[�Ǘ��C���X�^���X
		UserManager mgr = new UserManager();
		String userId = "aaa";// ���[�U�h�c
		String password = "bbb";// �p�X���[�h

		try {
			mgr.regist(userId, password, "aaaaa"); // �o�^
		} catch (UserRegistException e) {
		}

		boolean answer = mgr.auth("popo", new String("bbb"));
		assertFalse(answer);

	}

	public void testAuthFalse03() throws Exception {
		// ���[�U�[�Ǘ��C���X�^���X
		UserManager mgr = new UserManager();
		String userId = "aaa";// ���[�U�h�c
		String password = "bbs";// �p�X���[�h

		try {
			mgr.regist(userId, password, "aaaaa"); // �o�^
		} catch (UserRegistException e) {
		}

		boolean answer = mgr.auth(null, new String("bbs"));
		assertFalse(answer);
	}

	public void testAuthFalse04() throws Exception {
		// ���[�U�[�Ǘ��C���X�^���X
		UserManager mgr = new UserManager();
		String userId = "aaa";// ���[�U�h�c
		String password = "bbb";// �p�X���[�h

		try {
			mgr.regist(userId, password, "aaaaa"); // �o�^
		} catch (UserRegistException e) {
		}

		boolean answer = mgr.auth("aaa", null);
		assertFalse(answer);

	}

	public void testRemoveUserNotFound() throws Exception {
		// ���[�U�[�Ǘ��C���X�^���X
		UserManager mgr = new UserManager();
		String userId = "aaa";// ���[�U�h�c
		String password = "bbb";// �p�X���[�h

		try {
			boolean answer = mgr.remove(userId, password);
			assertTrue(false);
		} catch (UserNotFound e) {
			assertTrue(true);
		}
	}

	public void testRemoveTrue01() throws Exception {
		// ���[�U�[�Ǘ��C���X�^���X
		UserManager mgr = new UserManager();
		try {
			mgr.regist("user00", "test", "imamura"); // �o�^
			assertEquals(1, mgr.size());
		} catch (UserRegistException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		try {
			boolean answer = mgr.remove("user00", "test"); // �폜
			assertTrue(answer);
		} catch (UserNotFound e) {
			assertTrue("�ʂ����Ⴞ��", false);
		}

		try {
			mgr.getUser("user00");
			assertTrue("�ʂ����Ⴞ��", false);
		} catch (Exception e) {
			assertTrue(e instanceof UserNotFound);
		}

	}

	public void testRemoveTrue02() throws Exception {
		// ���[�U�[�Ǘ��C���X�^���X
		UserManager mgr = new UserManager();
		try {
			mgr.regist("user00", "test", "imamura"); // �o�^
			assertEquals(1, mgr.size());
		} catch (UserRegistException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		try {
			mgr.regist("user01", "test", "imamura"); // �o�^
			assertEquals(2, mgr.size());
		} catch (UserRegistException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		try {
			boolean answer = mgr.remove("user00", "test"); // �폜
			assertTrue(answer);
			assertEquals(1, mgr.size());
		} catch (UserNotFound e) {
			assertTrue("�ʂ����Ⴞ��", false);
		}

		try {
			mgr.getUser("user00");
			assertTrue("�ʂ����Ⴞ��", false);
		} catch (Exception e) {
			assertTrue(e instanceof UserNotFound);
		}

	}
}
