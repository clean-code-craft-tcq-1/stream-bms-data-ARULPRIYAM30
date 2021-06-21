package receiver.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import receiver.constant.BMSFactor;

public class BMSReceiverService {

	private static BMSFactor bmsFactor = new BMSFactor();

	public static void main(String[] args) {

		BufferedReader inputData = new BufferedReader(new InputStreamReader(System.in));
		String arg;
		List<String> argsList = new ArrayList<>();

		try {
			while ((arg = inputData.readLine()) != null) {
				System.out.println(arg);
				argsList.add(arg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Float> temperatureList = BMSReceiver.getParamsFromConsoleArguments(argsList, bmsFactor.TEMPERATURE);
		List<Float> socList = BMSReceiver.getParamsFromConsoleArguments(argsList, bmsFactor.SOC);
		List<Float> chargeRateList = BMSReceiver.getParamsFromConsoleArguments(argsList, bmsFactor.CHARGE_RATE);

		BMSReceiver.calculateMinMaxAvgTemperature(temperatureList);
		BMSReceiver.calculateMinMaxAvgSoc(socList);
		BMSReceiver.calculateMinMaxAvgChargeRate(chargeRateList);
	}

}
