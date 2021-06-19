package receiver.service;

import java.util.List;

import receiver.constant.BMSFactor;

public class BMSReceiverService {

	private static BMSFactor bmsFactor = new BMSFactor();

	public static void main(String[] args) {

		List<Float> temperatureList = BMSReceiver.getParamsFromConsoleArguments(args, bmsFactor.TEMPERATURE);
		List<Float> socList = BMSReceiver.getParamsFromConsoleArguments(args, bmsFactor.SOC);
		List<Float> chargeRateList = BMSReceiver.getParamsFromConsoleArguments(args, bmsFactor.CHARGE_RATE);

		BMSReceiver.calculateMinMaxAvgTemperature(temperatureList);
		BMSReceiver.calculateMinMaxAvgSoc(socList);
		BMSReceiver.calculateMinMaxAvgChargeRate(chargeRateList);
	}

}
