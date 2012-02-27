package jp.co.azing.forecastmarket;

import java.util.ArrayList;
import java.util.List;

/**
 * �\�����̊Ǘ�.
 * 
 * @author fukuyama
 * 
 */
public final class ForecastInformationManager {

	/** �\�����̃��X�g. */
	private List<ForecastInformation> infos =
			new ArrayList<ForecastInformation>();

	/**
	 * �\�����̓o�^.
	 * 
	 * @param information
	 *            �\�����
	 */
	public void regist(ForecastInformation information) {

		// ���̓`�F�b�N�H
		// ��O����

		infos.add(information);

	}

	/**
	 * �\�����̍X�V.
	 * 
	 * @param information
	 *            �\�����
	 * @return �X�V�����ꍇ true
	 */
	public boolean update(ForecastInformation information) {
		return true;

	}

	/**
	 * �\�����̍폜.
	 * 
	 * @param information
	 *            �\�����
	 * @return �폜�����ꍇ true
	 */
	public boolean remove(ForecastInformation information) {
		boolean remove = infos.remove(information);
		return remove;

	}

	/**
	 * �\�����̎擾.
	 * 
	 * @return �\�����̃��X�g
	 */
	public List<ForecastInformation> catalog() {
		return infos;
	}

}
