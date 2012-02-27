/**
 * ForecastInformationManagerTest.
 */
package jp.co.azing.forecastmarket;

import java.util.List;

import junit.framework.TestCase;

/**
 * @author 吉原
 * 
 */
public class ForecastInformationManagerTest extends TestCase {

	/**
	 * {@link jp.co.azing.forecastmarket.ForecastInformationManager#regist(jp.co.azing.forecastmarket.ForecastInformation)}
	 * のためのテスト・メソッド。
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
	 * のためのテスト・メソッド。
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
	 * のためのテスト・メソッド。
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
	 * のためのテスト・メソッド。
	 */
	public void testCatalog() {
		ForecastInformationManager forecastInformationManager =
				new ForecastInformationManager();
		List<ForecastInformation> catalog =
				forecastInformationManager.catalog();

		// 一覧のサイズが0ならばOK
		assertEquals(0, catalog.size());

		ForecastInformation info1 = new ForecastInformation();
		forecastInformationManager.regist(info1);
		assertEquals(1, catalog.size());

	}

}
