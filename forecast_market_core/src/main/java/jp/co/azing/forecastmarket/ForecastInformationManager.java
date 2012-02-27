package jp.co.azing.forecastmarket;

import java.util.ArrayList;
import java.util.List;

/**
 * —\‘ªî•ñ‚ÌŠÇ—.
 * 
 * @author fukuyama
 * 
 */
public final class ForecastInformationManager {

	/** —\‘ªî•ñ‚ÌƒŠƒXƒg. */
	private List<ForecastInformation> infos =
			new ArrayList<ForecastInformation>();

	/**
	 * —\‘ªî•ñ‚Ì“o˜^.
	 * 
	 * @param information
	 *            —\‘ªî•ñ
	 */
	public void regist(ForecastInformation information) {

		// “ü—Íƒ`ƒFƒbƒNH
		// —áŠOˆ—

		infos.add(information);

	}

	/**
	 * —\‘ªî•ñ‚ÌXV.
	 * 
	 * @param information
	 *            —\‘ªî•ñ
	 * @return XV‚µ‚½ê‡ true
	 */
	public boolean update(ForecastInformation information) {
		return true;

	}

	/**
	 * —\‘ªî•ñ‚Ìíœ.
	 * 
	 * @param information
	 *            —\‘ªî•ñ
	 * @return íœ‚µ‚½ê‡ true
	 */
	public boolean remove(ForecastInformation information) {
		boolean remove = infos.remove(information);
		return remove;

	}

	/**
	 * —\‘ªî•ñ‚Ìæ“¾.
	 * 
	 * @return —\‘ªî•ñ‚ÌƒŠƒXƒg
	 */
	public List<ForecastInformation> catalog() {
		return infos;
	}

}
