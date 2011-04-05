/**
 *
 */
package jp.co.azing.forecastmarket;

import java.util.List;

import jp.co.azing.forecastmarket.ForecastInformation;
import jp.co.azing.forecastmarket.ForecastInformationManager;
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
		fail("まだ実装されていません。");
	}

	/**
	 * {@link jp.co.azing.forecastmarket.ForecastInformationManager#update(jp.co.azing.forecastmarket.ForecastInformation)}
	 * のためのテスト・メソッド。
	 */
	public void testUpdate() {
		fail("まだ実装されていません。");
	}

	/**
	 * {@link jp.co.azing.forecastmarket.ForecastInformationManager#remove(jp.co.azing.forecastmarket.ForecastInformation)}
	 * のためのテスト・メソッド。
	 */
	public void testRemove() {
		fail("まだ実装されていません。");
	}

	/**
	 * {@link jp.co.azing.forecastmarket.ForecastInformationManager#catalog()}
	 * のためのテスト・メソッド。
	 */
	public void testCatalog() {
		ForecastInformationManager forecastInformationManager = new ForecastInformationManager();
		List catalog = forecastInformationManager.catalog();

		// 一覧のサイズが0ならばOK
		assertEquals(0, catalog.size());

		ForecastInformation info1 = new ForecastInformation();
		forecastInformationManager.regist(info1);
		assertEquals(1, catalog.size());

	}

}
