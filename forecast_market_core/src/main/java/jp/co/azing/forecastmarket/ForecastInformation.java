package jp.co.azing.forecastmarket;

import java.util.Date;

public class ForecastInformation {

	private int forecastNumber;
	private String forecastName;
	private String forecastMatter;
	private Date entryTime;
	private Date endTime;
	private int totalSell;
	private int systemTraceValue;
	private int paybackPoint;

	public int getForecastNumber() {
		return forecastNumber;
	}

	public void setForecastNumber(int forecastNumber) {
		this.forecastNumber = forecastNumber;
	}

	public String getForecastName() {
		return forecastName;
	}

	public void setForecastName(String forecastName) {
		this.forecastName = forecastName;
	}

	public String getForecastMatter() {
		return forecastMatter;
	}

	public void setForecastMatter(String forecastMatter) {
		this.forecastMatter = forecastMatter;
	}

	public Date getEntryTime() {
		return (Date) entryTime.clone();
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public Date getEndTime() {
		return (Date) endTime.clone();
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getTotalSell() {
		return totalSell;
	}

	public void setTotalSell(int totalSell) {
		this.totalSell = totalSell;
	}

	public int getSystemTraceValue() {
		return systemTraceValue;
	}

	public void setSystemTraceValue(int systemTraceValue) {
		this.systemTraceValue = systemTraceValue;
	}

	public int getPaybackPoint() {
		return paybackPoint;
	}

	public void setPaybackPoint(int paybackPoint) {
		this.paybackPoint = paybackPoint;
	}

}
