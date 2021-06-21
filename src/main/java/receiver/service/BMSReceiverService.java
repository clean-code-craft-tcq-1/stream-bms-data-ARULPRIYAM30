package receiver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import receiver.constant.BMSFactor;

public class BMSReceiverService {

	private static BMSFactor bmsFactor = new BMSFactor();

	public static void main(String[] args) {

		Scanner inputData = new Scanner(System.in);
		String arg;
		List<String> argsList = new ArrayList<>();

		while ((arg = inputData.nextLine()) != null) {
			argsList.add(arg);
		}

		List<Float> temperatureList = BMSReceiver.getParamsFromConsoleArguments(argsList, bmsFactor.TEMPERATURE);
		List<Float> socList = BMSReceiver.getParamsFromConsoleArguments(argsList, bmsFactor.SOC);
		List<Float> chargeRateList = BMSReceiver.getParamsFromConsoleArguments(argsList, bmsFactor.CHARGE_RATE);

		BMSReceiver.calculateMinMaxAvgTemperature(temperatureList);
		BMSReceiver.calculateMinMaxAvgSoc(socList);
		BMSReceiver.calculateMinMaxAvgChargeRate(chargeRateList);

		inputData.close();
	}

}
