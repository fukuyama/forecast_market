package jp.co.azing.forecastmarket;

import java.util.ArrayList;
import java.util.List;

public class ForecastInformationManager {

	// �\�����̃��X�g
	private List<ForecastInformation> forecastinformations = new ArrayList<ForecastInformation>();

	/**
	 * �\�����̓o�^
	 *
	 * @param information
	 */
	public void regist(ForecastInformation information){

		//���̓`�F�b�N�H
		//��O����


		forecastinformations.add(information);



	}


	/**
	 * �\�����̍X�V
	 *
	 * @param information
	 * @return
	 */
	public boolean update(ForecastInformation information){
		return false;

	}

	/**
	 * �\�����̍폜
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
