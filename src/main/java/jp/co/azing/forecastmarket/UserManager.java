package jp.co.azing.forecastmarket;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ���[�U�Ǘ��N���X
 * 
 * @author taneoka
 * 
 */
public class UserManager {
	/**
	 * ���[�U���X�g
	 */
	private List<User> users = new ArrayList<User>();

	/**
	 * ���[�U�o�^
	 * 
	 * @param loginId
	 *            ���[�U�h�c
	 * @param password
	 *            �p�X���[�h
	 * @param name
	 *            ���O
	 * 
	 * @throws UserRegistException
	 *             ���[�U�[�o�^���s
	 */
	public void regist(String loginId, String password, String name)
			throws UserRegistException {

		// userId �̃��[�U�����邩�m�F
		if (existsUser(loginId)) {
			throw new UserRegistException();
		}

		// ���[�U�[���쐬
		User user = new User(loginId, password, name);

		// ���[�U�[���X�g����g�p����Ă��Ȃ����[�U�[�ԍ���T��
		int userNumber = generateUserNumber();
		user.setUserNumber(userNumber);

		// ���X�g�Ƀ��[�U�[����ǉ�
		users.add(user);
	}

	/**
	 * ���[�U�[�ԍ�����. ���[�U�[���X�g����g�p����Ă��Ȃ����[�U�[�ԍ���T��
	 * 
	 * @return
	 */
	private int generateUserNumber() {
		// ���[�U�[���X�g���󂾂�����
		if (users.isEmpty()) {
			// �P��Ԃ�
			return 1;
		}
		// TODO: ���[�v���������肠��
		// i ��1����C���N�������g���Ȃ��烋�[�v
		for (int i = 1; i <= Integer.MAX_VALUE; i++) {
			// ���[�U�[���X�g�̃��[�v
			for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
				User user = (User) iterator.next();
				// ���X�g�ɓ����Ă���User�̔ԍ��𒲂ׂ�
				// i �� ���[�U�[�ԍ����r
				if (i == user.getUserNumber()) {
					// �����������烋�[�v�����
					break;
				} else {
					// �������
					if (!iterator.hasNext()) {
						// ���ꂪ�Ō�̃��[�U�[���H
						// �Ō�̃��[�U�[�Ȃ�i ��Ԃ�
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
	 * �F��
	 * 
	 * @param userId
	 * @param password
	 * @return �F�،��ʁ@����������true�@
	 */
	public boolean auth(String userId, String password) {
		if (userId == null || password == null) {
			return false;
		}

		// �莝���̃��[�U���X�g�Ɏ󂯎����userID�����邩�𒲂ׂ�
		try {
			User user = getUser(userId);
			// ����΁A�����̋L�^����Ă�password�Ǝ󂯎����password���r
			if (user.getPassword().equals(password)) {
				// �^�Ȃ�A�F�؂n�j
				return true;
			}
			// �U�Ȃ�A�F�؂m�f
		} catch (UserNotFound e) {
			// �Ȃ���ΔF�؂m�f
		}

		return false;
	}

	/**
	 * ���[�U���擾
	 * 
	 * @param userId
	 * @return�@���[�U���@User
	 */
	public User getUser(String userId) throws UserNotFound {
		// ���X�g��������̃��[�UID�������Ă��郆�[�U��T��
		// // �C�e���[�^�Ń��X�g�����[�v������
		for (User user : users) {
			// // ���X�g�������Ă������[�U�̃��[�UID�ƈ����̃��[�UID���r
			if (user.getLoginId().equals(userId)) {
				// // �����ł���΃��[�U��Ԃ�
				return user;
			}
		}
		// ���[�U�[������Ȃ�
		throw new UserNotFound();
	}

	/**
	 * ���[�U�[�̐�
	 * 
	 * @return
	 */
	public int size() {
		return users.size();
	}

	/**
	 * ���[�U�[�폜.
	 * 
	 * @param userId
	 * @param password
	 * @return ����
	 */
	public boolean remove(String userId, String password) throws UserNotFound {
		// userId �̃��[�U�[�����擾
		User user = getUser(userId);
		// ���[�U�[���̃p�X���[�h�� password �Ɠ��������H
		if (user.getPassword().equals(password)) {
			// �������ꍇ users ���� userId �̃��[�U�[�����폜
			return users.remove(user);
		}
		return false;
	}

}
