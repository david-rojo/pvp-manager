# PVP Manager scenario

In the electronic commerce database of the company exists the **PRICES** table that contains the recommended retail price (known is Spanish as pvp) and the rate that is applied to a product of a chain between specific dates. Here you are an example of the table with the relevant fields:

| BRAND_ID | START_DATE          | END_DATE            | PRICE_LIST | PRODUCT_ID | PRIORITY | PRICE | CURR |
|----------|---------------------|---------------------|------------|------------|----------|-------|------|
| 1        | 2020-06-14-00.00.00 | 2020-12-31-23.59.59 | 1          | 35455      | 0        | 35.50 | EUR  |
| 1        | 2020-06-14-15.00.00 | 2020-06-14-18.30.00 | 2          | 35455      | 1        | 25.45 | EUR  |
| 1        | 2020-06-15-00.00.00 | 2020-06-15-11.00.00 | 3          | 35455      | 1        | 30.50 | EUR  |
| 1        | 2020-06-15-16.00.00 | 2020-12-31-23.59.59 | 4          | 35455      | 1        | 38.95 | EUR  |

Fields:

- **BRAND_ID**: foreign key of the group chain (1 = COMPANY1), the brand identifier
- **START_DATE**, **END_DATE**: date range when the indicated price rate applies.
- **PRICE_LIST**: applicable price rate identifier.
- **PRODUCT_ID**: product code identifier.
- **PRIORITY**: price application disambiguator. If two rates coincide in a date range, the one with the highest priority (higher numerical value) is applied.
- **PRICE**: final sale price.
- **CURR**: [currency ISO](https://en.wikipedia.org/wiki/ISO_4217) code.

Is asked:

* Implements a SpringBoot application/service that exposes a REST API with a query endpoint that: 
  * accept as input parameters: application date, product identifier and brand identifier.
  * return as output parameters: product identifier, brand identifier, rate that will be applied, date range when the price is applied and final sale price.
  
A in-memory database (h2 like) must be used and it can be initialized with the example data shown previosluy, (the name of the fields can be changed and more fields can be added if is desired, choose the data type that consider right per each field).

* Develop endpoint REST API tests that validate the following requests to the service with the example data:
  * Test 1: request at 10:00 of the day 14th of the product 35455 for brand 1
  * Test 2: request at 16:00 of the day 14th of the product 35455 for brand 1
  * Test 3: request at 21:00 of the day 14th of the product 35455 for brand 1
  * Test 4: request at 10:00 of the day 15th of the product 35455 for brand 1
  * Test 5: request at 21:00 of the day 16th of the product 35455 for brand 1

