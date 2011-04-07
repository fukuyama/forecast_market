/**
 *
 */
package jp.co.azing.forecastmarket;

import java.util.List;

import jp.co.azing.forecastmarket.ForecastInformation;
import jp.co.azing.forecastmarket.ForecastInformationManager;
import junit.framework.TestCase;

/**
 * @author �g��
 * 
 */
public class ForecastInformationManagerTest extends TestCase {

	/**
	 * {@link jp.co.azing.forecastmarket.ForecastInformationManager#regist(jp.co.azing.forecastmarket.ForecastInformation)}
	 * �̂��߂̃e�X�g�E���\�b�h�B
	 */
	public void testRegist() {
		fail("�܂���������Ă��܂���B");
	}

	/**
	 * {@link jp.co.azing.forecastmarket.ForecastInformationManager#update(jp.co.azing.forecastmarket.ForecastInformation)}
	 * �̂��߂̃e�X�g�E���\�b�h�B
	 */
	public void testUpdate() {
		fail("�܂���������Ă��܂���B");
	}

	/**
	 * {@link jp.co.azing.forecastmarket.ForecastInformationManager#remove(jp.co.azing.forecastmarket.ForecastInformation)}
	 * �̂��߂̃e�X�g�E���\�b�h�B
	 */
	public void testRemove() {
		fail("�܂���������Ă��܂���B");
	}

	/**
	 * {@link jp.co.azing.forecastmarket.ForecastInformationManager#catalog()}
	 * �̂��߂̃e�X�g�E���\�b�h�B
	 */
	public void testCatalog() {
		ForecastInformationManager forecastInformationManager = new ForecastInformationManager();
		List catalog = forecastInformationManager.catalog();

		// �ꗗ�̃T�C�Y��0�Ȃ��OK
		assertEquals(0, catalog.size());

		ForecastInformation info1 = new ForecastInformation();
		forecastInformationManager.regist(info1);
		assertEquals(1, catalog.size());

	}

}
