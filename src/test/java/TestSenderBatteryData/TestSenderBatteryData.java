package TestSenderBatteryData;

import static org.junit.Assert.*;
import org.junit.Test;

import SenderBatteryData.CheckSenderData;
import SenderBatteryData.SenderParam;
import SenderBatteryData.SenderService;
import SenderBatteryData.SenderServiceImpl;

public class TestSenderBatteryData {
	// validate whether Data send is null then return null
	@Test
	public void givenBatteryParametersAsNull() {
		SenderParam batteryValue = null;
		assertNull(CheckSenderData.isEmpty(batteryValue));
	}

	// validate Data send in stream hat atleast 10 values
	@Test
	public void givenBatteryParametersSizeisLessThan10() {
		assertFalse(CheckSenderData.validateDataSize("5"));
	}

	// validate Data send has valid size then read the Data and print in console
	@Test
	public void givenBatteryParamexpectspropercount() {
		SenderService sender = new SenderServiceImpl();
		int validateSize = 14;
		assertEquals(sender.receiveReadingsFromBattery(14).size(), validateSize);
		sender.sendReadingsToConsole();
	}

}
