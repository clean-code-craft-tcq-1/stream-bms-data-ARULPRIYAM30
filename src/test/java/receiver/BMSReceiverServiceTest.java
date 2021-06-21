package receiver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import receiver.constant.BMSFactor;
import receiver.service.BMSReceiver;
import receiver.validator.BMSValidator;

public class BMSReceiverServiceTest {

	List<Float> temperatureList;
	List<Float> socList;
	List<Float> chargeRateList;
	BMSFactor bmsFactor = new BMSFactor();

	@Before
	public void setup() {

		temperatureList = Arrays.asList(45.0F, 34.0F, 23.0F, 44.0F, 10.0F);
		socList = Arrays.asList(21.0F, 29.0F, 40.0F, 75.0F);
		chargeRateList = Arrays.asList(0.3F, 0.5F, 0.2F, 0.01F);
	}

	@Test
	public void givenArgsAsEmpty_whenGetParamsFromConsoleArguments_thenReturnEmptyList() {
		List<String> args = new ArrayList<>();
		assertEquals(0, BMSReceiver.getParamsFromConsoleArguments(args, bmsFactor.TEMPERATURE).size());
		assertEquals(0, BMSReceiver.getParamsFromConsoleArguments(args, bmsFactor.SOC).size());
		assertEquals(0, BMSReceiver.getParamsFromConsoleArguments(args, bmsFactor.CHARGE_RATE).size());
	}

	@Test
	public void givenArgsAsValid_whenGetParamsFromConsoleArguments_thenReturnValidList() {
		List<String> args = new ArrayList<>();
		args.add("1;21;0.5");
		args.add("21;76;0.5");
		assertTrue(BMSReceiver.getParamsFromConsoleArguments(args, bmsFactor.TEMPERATURE).size() > 0);
		assertTrue(BMSReceiver.getParamsFromConsoleArguments(args, bmsFactor.SOC).size() > 0);
		assertTrue(BMSReceiver.getParamsFromConsoleArguments(args, bmsFactor.CHARGE_RATE).size() > 0);
	}

	@Test
	public void givenListAsNull_whenCalculateMinMaxAvg_thenReturnFalse() {
		assertFalse(BMSReceiver.calculateMinMaxAvgTemperature(null));
		assertFalse(BMSReceiver.calculateMinMaxAvgSoc(null));
		assertFalse(BMSReceiver.calculateMinMaxAvgChargeRate(null));
	}

	@Test
	public void givenListAsEmpty_whenCalculateMinMaxAvg_thenReturnFalse() {
		List<Float> paramsList = new ArrayList<>();
		assertFalse(BMSReceiver.calculateMinMaxAvgTemperature(paramsList));
		assertFalse(BMSReceiver.calculateMinMaxAvgSoc(paramsList));
		assertFalse(BMSReceiver.calculateMinMaxAvgChargeRate(paramsList));
	}

	@Test
	public void givenListAsNullOrEmpty_whenGetMaxValueFromParamList_thenReturnNotNull() {
		List<Float> paramsList = new ArrayList<>();

		assertNotNull(BMSValidator.getMaxValueFromParamList(null));
		assertNotNull(BMSValidator.getMinValueFromParamList(null));
		assertNotNull(BMSValidator.getAverageFromParamList(null));
		assertNotNull(BMSValidator.getMaxValueFromParamList(paramsList));
		assertNotNull(BMSValidator.getMinValueFromParamList(paramsList));
		assertNotNull(BMSValidator.getAverageFromParamList(paramsList));
	}

	@Test
	public void givenTemperatureArgsListAsValidList_whenCalculateMinMaxAvgTemperature_thenReturnTrue() {
		assertTrue(BMSReceiver.calculateMinMaxAvgTemperature(temperatureList));
	}

	@Test
	public void givenSocArgsListAsValidList_whenCalculateMinMaxAvgSoc_thenReturnTrue() {
		assertTrue(BMSReceiver.calculateMinMaxAvgSoc(socList));
	}

	@Test
	public void givenChargeRateArgsListAsValidList_whenCalculateMinMaxAvgChargeRate_thenReturnTrue() {
		assertTrue(BMSReceiver.calculateMinMaxAvgChargeRate(chargeRateList));
	}
}
