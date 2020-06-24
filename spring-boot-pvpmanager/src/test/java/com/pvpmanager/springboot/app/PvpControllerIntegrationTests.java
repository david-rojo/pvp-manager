package com.pvpmanager.springboot.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.pvpmanager.springboot.app.controller.PvpApiController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
/**
 * We use the same H2 database for these tests that is used in the deployment of
 * the application, also with the initial data loading
 * 
 * @author David Rojo
 *
 */
public class PvpControllerIntegrationTests {

	public static final String REST_ENDPOINT = "/pvp-manager/pvp/{brandId}/{productId}/{date}";

	public static final Integer SEARCHED_BRAND_ID = 1;
	public static final Integer SEARCHED_PRODUCT_ID = 35455;

	public static final String CURRENCY_VALUE = "EUR";

	public static final String START_DATE_PRICELIST1 = "2020-06-14T00:00:00";
	public static final String END_DATE_PRICELIST1 = "2020-12-31T23:59:59";
	public static final Double PRICE_PRICELIST1 = 35.5;
	public static final String START_DATE_PRICELIST2 = "2020-06-14T15:00:00";
	public static final String END_DATE_PRICELIST2 = "2020-06-14T18:30:00";
	public static final Double PRICE_PRICELIST2 = 25.45;
	public static final String START_DATE_PRICELIST3 = "2020-06-15T00:00:00";
	public static final String END_DATE_PRICELIST3 = "2020-06-15T11:00:00";
	public static final Double PRICE_PRICELIST3 = 30.5;
	public static final String START_DATE_PRICELIST4 = "2020-06-15T16:00:00";
	public static final String END_DATE_PRICELIST4 = "2020-12-31T23:59:59";
	public static final Double PRICE_PRICELIST4 = 38.95;

	public static final String JSONKEY_PRICE_LIST = "priceList";
	public static final String JSONKEY_BRAND_ID = "brandId";
	public static final String JSONKEY_PRODUCT_ID = "productId";
	public static final String JSONKEY_START_DATE = "startDate";
	public static final String JSONKEY_END_DATE = "endDate";
	public static final String JSONKEY_PRICE = "price";
	public static final String JSONKEY_CURRENCY = "currency";

	@Autowired
	private PvpApiController pvpController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void whenPvpControllerInjected_thenNotNull() throws Exception {
		assertThat(pvpController).isNotNull();
	}

	@Test
	public void whenGetRequestToPvpEndPointTest1_thenCorrectResponse() throws Exception {
		Integer targetPriceList = 1;
		String requestedDate = "2020-06-14-10.00.00";

		mockMvc.perform(MockMvcRequestBuilders
				.get(REST_ENDPOINT, SEARCHED_BRAND_ID, SEARCHED_PRODUCT_ID, requestedDate)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_PRICE_LIST).value(targetPriceList))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_BRAND_ID).value(SEARCHED_BRAND_ID))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_PRODUCT_ID).value(SEARCHED_PRODUCT_ID))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_START_DATE).value(START_DATE_PRICELIST1))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_END_DATE).value(END_DATE_PRICELIST1))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_PRICE).value(PRICE_PRICELIST1))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_CURRENCY).value(CURRENCY_VALUE));
	}

	@Test
	public void whenGetRequestToPvpEndPointTest2_thenCorrectResponse() throws Exception {
		Integer targetPriceList = 2;
		String requestedDate = "2020-06-14-16.00.00";

		mockMvc.perform(MockMvcRequestBuilders
				.get(REST_ENDPOINT, SEARCHED_BRAND_ID, SEARCHED_PRODUCT_ID, requestedDate)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_PRICE_LIST).value(targetPriceList))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_BRAND_ID).value(SEARCHED_BRAND_ID))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_PRODUCT_ID).value(SEARCHED_PRODUCT_ID))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_START_DATE).value(START_DATE_PRICELIST2))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_END_DATE).value(END_DATE_PRICELIST2))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_PRICE).value(PRICE_PRICELIST2))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_CURRENCY).value(CURRENCY_VALUE));
	}

	@Test
	public void whenGetRequestToPvpEndPointTest3_thenCorrectResponse() throws Exception {
		Integer targetPriceList = 1;
		String requestedDate = "2020-06-14-10.00.00";

		mockMvc.perform(MockMvcRequestBuilders
				.get(REST_ENDPOINT, SEARCHED_BRAND_ID, SEARCHED_PRODUCT_ID, requestedDate)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_PRICE_LIST).value(targetPriceList))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_BRAND_ID).value(SEARCHED_BRAND_ID))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_PRODUCT_ID).value(SEARCHED_PRODUCT_ID))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_START_DATE).value(START_DATE_PRICELIST1))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_END_DATE).value(END_DATE_PRICELIST1))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_PRICE).value(PRICE_PRICELIST1))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_CURRENCY).value(CURRENCY_VALUE));
	}

	@Test
	public void whenGetRequestToPvpEndPointTest4_thenCorrectResponse() throws Exception {
		Integer targetPriceList = 3;
		String requestedDate = "2020-06-15-10.00.00";

		mockMvc.perform(MockMvcRequestBuilders
				.get(REST_ENDPOINT, SEARCHED_BRAND_ID, SEARCHED_PRODUCT_ID, requestedDate)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_PRICE_LIST).value(targetPriceList))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_BRAND_ID).value(SEARCHED_BRAND_ID))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_PRODUCT_ID).value(SEARCHED_PRODUCT_ID))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_START_DATE).value(START_DATE_PRICELIST3))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_END_DATE).value(END_DATE_PRICELIST3))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_PRICE).value(PRICE_PRICELIST3))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_CURRENCY).value(CURRENCY_VALUE));
	}

	@Test
	public void whenGetRequestToPvpEndPointTest5_thenCorrectResponse() throws Exception {
		Integer targetPriceList = 4;
		String requestedDate = "2020-06-16-21.00.00";

		mockMvc.perform(MockMvcRequestBuilders
				.get(REST_ENDPOINT, SEARCHED_BRAND_ID, SEARCHED_PRODUCT_ID, requestedDate)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_PRICE_LIST).value(targetPriceList))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_BRAND_ID).value(SEARCHED_BRAND_ID))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_PRODUCT_ID).value(SEARCHED_PRODUCT_ID))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_START_DATE).value(START_DATE_PRICELIST4))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_END_DATE).value(END_DATE_PRICELIST4))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_PRICE).value(PRICE_PRICELIST4))
				.andExpect(MockMvcResultMatchers.jsonPath("$." + JSONKEY_CURRENCY).value(CURRENCY_VALUE));
	}

}
