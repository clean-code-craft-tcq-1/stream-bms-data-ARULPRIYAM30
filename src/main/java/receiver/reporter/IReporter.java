package receiver.reporter;

import receiver.model.BatteryCharacteristic;

public interface IReporter {
	public void printProcessedData(String characteristic, BatteryCharacteristic batteryCharacteristic);
}
