package com.pvpmanager.springboot.app;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pvpmanager.springboot.app.model.dao.IPriceDao;
import com.pvpmanager.springboot.app.model.entitys.Price;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
/**
 * We use the same H2 database for these tests that is used in the deployment of
 * the application, also with the initial data loading
 * 
 * @author David Rojo
 *
 */
public class IPriceDaoTests {

	public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd-HH.mm.ss";

	public static final Integer SEARCHED_BRAND_ID = 1;
	public static final Integer SEARCHED_PRODUCT_ID = 35455;

	public static final String CURRENCY_VALUE = "EUR";

	public static final String START_DATE_PRICELIST1 = "2020-06-14-00.00.00";
	public static final String END_DATE_PRICELIST1 = "2020-12-31-23.59.59";
	public static final Double PRICE_PRICELIST1 = 35.5;
	public static final String START_DATE_PRICELIST2 = "2020-06-14-15.00.00";
	public static final String END_DATE_PRICELIST2 = "2020-06-14-18.30.00";
	public static final Double PRICE_PRICELIST2 = 25.45;
	public static final String START_DATE_PRICELIST3 = "2020-06-15-00.00.00";
	public static final String END_DATE_PRICELIST3 = "2020-06-15-11.00.00";
	public static final Double PRICE_PRICELIST3 = 30.5;
	public static final String START_DATE_PRICELIST4 = "2020-06-15-16.00.00";
	public static final String END_DATE_PRICELIST4 = "2020-12-31-23.59.59";
	public static final Double PRICE_PRICELIST4 = 38.95;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN);

	@Autowired
	private IPriceDao priceDao;

	@Test
	public void test1() {
		Integer targetPriceList = 1;
		String searchedDate = "2020-06-14-10.00.00";
		LocalDateTime ldtSearchedDate = LocalDateTime.parse(searchedDate, formatter);
		LocalDateTime ldtStartDate = LocalDateTime.parse(START_DATE_PRICELIST1, formatter);
		LocalDateTime ldtEndDate = LocalDateTime.parse(END_DATE_PRICELIST1, formatter);

		Price price = priceDao.getPvp(SEARCHED_BRAND_ID, SEARCHED_PRODUCT_ID, ldtSearchedDate);

		assertNotNull(price);
		assertEquals(new BigDecimal(price.getPriceList()), new BigDecimal(targetPriceList));
		assertEquals(new BigDecimal(price.getBrandId()), new BigDecimal(SEARCHED_BRAND_ID));
		assertEquals(new BigDecimal(price.getProductId()), new BigDecimal(SEARCHED_PRODUCT_ID));
		assertEquals(new BigDecimal(price.getPrice()), new BigDecimal(PRICE_PRICELIST1));
		assertEquals(price.getCurrency(), CURRENCY_VALUE);
		assertThat(price.getStartDate().isEqual(ldtStartDate), is(true));
		assertThat(price.getEndDate().isEqual(ldtEndDate), is(true));
	}

	@Test
	public void test2() {
		Integer targetPriceList = 2;
		String searchedDate = "2020-06-14-16.00.00";
		LocalDateTime ldtSearchedDate = LocalDateTime.parse(searchedDate, formatter);
		LocalDateTime ldtStartDate = LocalDateTime.parse(START_DATE_PRICELIST2, formatter);
		LocalDateTime ldtEndDate = LocalDateTime.parse(END_DATE_PRICELIST2, formatter);

		Price price = priceDao.getPvp(SEARCHED_BRAND_ID, SEARCHED_PRODUCT_ID, ldtSearchedDate);

		assertNotNull(price);
		assertEquals(new BigDecimal(price.getPriceList()), new BigDecimal(targetPriceList));
		assertEquals(new BigDecimal(price.getBrandId()), new BigDecimal(SEARCHED_BRAND_ID));
		assertEquals(new BigDecimal(price.getProductId()), new BigDecimal(SEARCHED_PRODUCT_ID));
		assertEquals(new BigDecimal(price.getPrice()), new BigDecimal(PRICE_PRICELIST2));
		assertEquals(price.getCurrency(), CURRENCY_VALUE);
		assertThat(price.getStartDate().isEqual(ldtStartDate), is(true));
		assertThat(price.getEndDate().isEqual(ldtEndDate), is(true));
	}

	@Test
	public void test3() {
		Integer targetPriceList = 1;
		String searchedDate = "2020-06-14-21.00.00";
		LocalDateTime ldtSearchedDate = LocalDateTime.parse(searchedDate, formatter);
		LocalDateTime ldtStartDate = LocalDateTime.parse(START_DATE_PRICELIST1, formatter);
		LocalDateTime ldtEndDate = LocalDateTime.parse(END_DATE_PRICELIST1, formatter);

		Price price = priceDao.getPvp(SEARCHED_BRAND_ID, SEARCHED_PRODUCT_ID, ldtSearchedDate);

		assertNotNull(price);
		assertEquals(new BigDecimal(price.getPriceList()), new BigDecimal(targetPriceList));
		assertEquals(new BigDecimal(price.getBrandId()), new BigDecimal(SEARCHED_BRAND_ID));
		assertEquals(new BigDecimal(price.getProductId()), new BigDecimal(SEARCHED_PRODUCT_ID));
		assertEquals(new BigDecimal(price.getPrice()), new BigDecimal(PRICE_PRICELIST1));
		assertEquals(price.getCurrency(), CURRENCY_VALUE);
		assertThat(price.getStartDate().isEqual(ldtStartDate), is(true));
		assertThat(price.getEndDate().isEqual(ldtEndDate), is(true));
	}

	@Test
	public void test4() {
		Integer targetPriceList = 3;
		String searchedDate = "2020-06-15-10.00.00";
		LocalDateTime ldtSearchedDate = LocalDateTime.parse(searchedDate, formatter);
		LocalDateTime ldtStartDate = LocalDateTime.parse(START_DATE_PRICELIST3, formatter);
		LocalDateTime ldtEndDate = LocalDateTime.parse(END_DATE_PRICELIST3, formatter);

		Price price = priceDao.getPvp(SEARCHED_BRAND_ID, SEARCHED_PRODUCT_ID, ldtSearchedDate);

		assertNotNull(price);
		assertEquals(new BigDecimal(price.getPriceList()), new BigDecimal(targetPriceList));
		assertEquals(new BigDecimal(price.getBrandId()), new BigDecimal(SEARCHED_BRAND_ID));
		assertEquals(new BigDecimal(price.getProductId()), new BigDecimal(SEARCHED_PRODUCT_ID));
		assertEquals(new BigDecimal(price.getPrice()), new BigDecimal(PRICE_PRICELIST3));
		assertEquals(price.getCurrency(), CURRENCY_VALUE);
		assertThat(price.getStartDate().isEqual(ldtStartDate), is(true));
		assertThat(price.getEndDate().isEqual(ldtEndDate), is(true));
	}

	@Test
	public void test5() {
		Integer targetPriceList = 4;
		String searchedDate = "2020-06-16-21.00.00";
		LocalDateTime ldtSearchedDate = LocalDateTime.parse(searchedDate, formatter);
		LocalDateTime ldtStartDate = LocalDateTime.parse(START_DATE_PRICELIST4, formatter);
		LocalDateTime ldtEndDate = LocalDateTime.parse(END_DATE_PRICELIST4, formatter);

		Price price = priceDao.getPvp(SEARCHED_BRAND_ID, SEARCHED_PRODUCT_ID, ldtSearchedDate);

		assertNotNull(price);
		assertEquals(new BigDecimal(price.getPriceList()), new BigDecimal(targetPriceList));
		assertEquals(new BigDecimal(price.getBrandId()), new BigDecimal(SEARCHED_BRAND_ID));
		assertEquals(new BigDecimal(price.getProductId()), new BigDecimal(SEARCHED_PRODUCT_ID));
		assertEquals(new BigDecimal(price.getPrice()), new BigDecimal(PRICE_PRICELIST4));
		assertEquals(price.getCurrency(), CURRENCY_VALUE);
		assertThat(price.getStartDate().isEqual(ldtStartDate), is(true));
		assertThat(price.getEndDate().isEqual(ldtEndDate), is(true));
	}
}
