package receiver.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import receiver.constant.BMSFactor;
import receiver.model.BatteryCharacteristic;
import receiver.reporter.IReporter;
import receiver.reporter.Reporter;
import receiver.validator.BMSValidator;

public class BMSReceiver {

	private static IReporter reporter = new Reporter();
	private static BMSFactor bmsFactor = new BMSFactor();
	private static Map<String, Integer> batteryParamsMap = new HashMap<String, Integer>() {

		private static final long serialVersionUID = 1L;

		{
			put(bmsFactor.TEMPERATURE, 0);
			put(bmsFactor.SOC, 1);
			put(bmsFactor.CHARGE_RATE, 2);
		}
	};

	public static boolean calculateMinMaxAvgTemperature(List<Float> temperatureList) {

		if (!BMSValidator.isValidList(temperatureList))
			return false;
		BatteryCharacteristic batteryCharacteristic = new BatteryCharacteristic(
				BMSValidator.getMinValueFromParamList(temperatureList),
				BMSValidator.getMaxValueFromParamList(temperatureList),
				BMSValidator.getAverageFromParamList(temperatureList));

		reporter.printProcessedData(bmsFactor.TEMPERATURE, batteryCharacteristic);

		return true;
	}

	public static boolean calculateMinMaxAvgSoc(List<Float> socList) {

		if (!BMSValidator.isValidList(socList))
			return false;

		BatteryCharacteristic batteryCharacteristic = new BatteryCharacteristic(
				BMSValidator.getMinValueFromParamList(socList), BMSValidator.getMaxValueFromParamList(socList),
				BMSValidator.getAverageFromParamList(socList));

		reporter.printProcessedData(bmsFactor.SOC, batteryCharacteristic);

		return true;
	}

	public static boolean calculateMinMaxAvgChargeRate(List<Float> chargeRateList) {

		if (!BMSValidator.isValidList(chargeRateList))
			return false;

		BatteryCharacteristic batteryCharacteristic = new BatteryCharacteristic(
				BMSValidator.getMinValueFromParamList(chargeRateList),
				BMSValidator.getMaxValueFromParamList(chargeRateList),
				BMSValidator.getAverageFromParamList(chargeRateList));

		reporter.printProcessedData(bmsFactor.CHARGE_RATE, batteryCharacteristic);

		return true;
	}

	public static List<Float> getParamsFromConsoleArguments(String[] params, String paramType) {
		List<Float> paramList = new ArrayList<>();
		if (params.length > 0) {
			for (String senderData : params) {
				String batteryParams[] = senderData.split(";");
				paramList.add(Float.valueOf(batteryParams[batteryParamsMap.get(paramType)]));
			}
		}
		return paramList;
	}
}
