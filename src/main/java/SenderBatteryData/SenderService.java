package SenderBatteryData;

import java.util.List;

public interface SenderService {
		public List<SenderParam> receiveReadingsFromBattery(int streamcount);
		public void sendReadingsToConsole();
	
}
