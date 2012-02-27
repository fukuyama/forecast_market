/**
 * ForecastInformationManagerTest.
 */
package jp.co.azing.forecastmarket;

import java.util.List;

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
		ForecastInformationManager fim = new ForecastInformationManager();
		ForecastInformation info = new ForecastInformation();
		info.setForecastName("forecastName");
		assertEquals(0, fim.catalog().size());
		fim.regist(info);
		assertEquals(1, fim.catalog().size());
	}

	/**
	 * {@link jp.co.azing.forecastmarket.ForecastInformationManager#update(jp.co.azing.forecastmarket.ForecastInformation)}
	 * �̂��߂̃e�X�g�E���\�b�h�B
	 */
	public void testUpdate() {
		ForecastInformationManager fim = new ForecastInformationManager();
		ForecastInformation info = new ForecastInformation();
		info.setForecastName("forecastName");
		assertEquals(0, fim.catalog().size());
		fim.regist(info);
		assertEquals(1, fim.catalog().size());
		boolean update = fim.update(info);
		assertTrue(update);
	}

	/**
	 * {@link jp.co.azing.forecastmarket.ForecastInformationManager#remove(jp.co.azing.forecastmarket.ForecastInformation)}
	 * �̂��߂̃e�X�g�E���\�b�h�B
	 */
	public void testRemove() {
		ForecastInformationManager fim = new ForecastInformationManager();
		ForecastInformation info = new ForecastInformation();
		info.setForecastName("forecastName");
		assertEquals(0, fim.catalog().size());
		fim.regist(info);
		assertEquals(1, fim.catalog().size());
		boolean remove = fim.remove(info);
		assertTrue(remove);
		assertEquals(0, fim.catalog().size());
	}

	/**
	 * {@link jp.co.azing.forecastmarket.ForecastInformationManager#catalog()}
	 * �̂��߂̃e�X�g�E���\�b�h�B
	 */
	public void testCatalog() {
		ForecastInformationManager forecastInformationManager =
				new ForecastInformationManager();
		List<ForecastInformation> catalog =
				forecastInformationManager.catalog();

		// �ꗗ�̃T�C�Y��0�Ȃ��OK
		assertEquals(0, catalog.size());

		ForecastInformation info1 = new ForecastInformation();
		forecastInformationManager.regist(info1);
		assertEquals(1, catalog.size());

	}

}
