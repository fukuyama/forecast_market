package jp.co.azing.forecastmarket;

import java.util.ArrayList;
import java.util.List;

public class ForecastInformationManager {

	// 予測情報のリスト
	private List<ForecastInformation> forecastinformations = new ArrayList<ForecastInformation>();

	/**
	 * 予測情報の登録
	 *
	 * @param information
	 */
	public void regist(ForecastInformation information){

		//入力チェック？
		//例外処理


		forecastinformations.add(information);



	}


	/**
	 * 予測情報の更新
	 *
	 * @param information
	 * @return
	 */
	public boolean update(ForecastInformation information){
		return false;

	}

	/**
	 * 予測情報の削除
	 *
	 * @param information
	 * @return
	 */
	public boolean remove(ForecastInformation information){
		return false;

	}


	/**
	 *
	 *
	 */
	public List catalog(){

		return forecastinformations;
	}


}
