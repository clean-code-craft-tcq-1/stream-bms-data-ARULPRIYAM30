package receiver.model;

public class BatteryCharacteristic {

	public Float min;
	public Float max;
	public Float avg;

	public BatteryCharacteristic(Float min, Float max, Float avg) {
		super();
		this.min = min;
		this.max = max;
		this.avg = avg;
	}
}
