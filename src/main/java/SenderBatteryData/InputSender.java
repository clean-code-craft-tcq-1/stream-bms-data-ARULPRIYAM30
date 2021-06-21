package SenderBatteryData;

public class InputSender {
	private static ILogger log = new Logger();

	public static void main(String[] args) {
		try {
			String noofEntries = "10";
			if (CheckSenderData.checkNumeric(noofEntries) && CheckSenderData.validateDataSize(noofEntries)) {
				SenderService data = new SenderServiceImpl();
				data.receiveReadingsFromBattery(Integer.parseInt(noofEntries));
				data.sendReadingsToConsole();
			}

		} catch (NullPointerException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}
