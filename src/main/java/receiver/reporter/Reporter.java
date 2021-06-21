package receiver.reporter;

import receiver.model.BatteryCharacteristic;

public class Reporter implements IReporter {

	public void printProcessedData(String parameterName, BatteryCharacteristic batteryCharacteristic) {
		System.out.println("Minimum " + parameterName + " : " + batteryCharacteristic.min);
		System.out.println("Maximum " + parameterName + " : " + batteryCharacteristic.max);
		System.out.println("Average " + parameterName + " : " + batteryCharacteristic.avg);
	}

}