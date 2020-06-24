package com.pvpmanager.springboot.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pvpmanager.springboot.app.model.entitys.Price;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "price")
public interface PriceApi {

	@Operation(
			summary = "Find all Prices in the database", 
			description = "Find all Prices in the database", 
			tags = { "price" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", 
                content = @Content(array = @ArraySchema(schema = @Schema(implementation = Price.class)))) })
	@GetMapping(value="price")
	public List<Price> getPrices();
	
	
	@Operation(
			summary = "Add a new Price", 
			description = "Add a new Price", 
			tags = { "price" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation",
                content = @Content(schema = @Schema(implementation = Price.class))) })
	@PostMapping(value="price")
	public Price addPrice(@RequestBody Price price);
	
	
	@Operation(
			summary = "Update an existing Price. If the Price doesn't exist in database, it is added", 
			description = "Update an existing Price. If the Price doesn't exist in database, it is added", 
			tags = { "price" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation",
        		content = @Content(schema = @Schema(implementation = Price.class))) })
	@PutMapping(value="price")
	public Price updatePrice(@RequestBody Price price);
	
	@Operation(
			summary = "Deletes a Price", 
			description = "", 
			tags = { "price" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation"),
        @ApiResponse(responseCode = "404", description = "price not found") })
	@DeleteMapping(value="price/{brandId}/{productId}/{priceList}" )
	public boolean deletePrice(
			@PathVariable(value="brandId") Integer brandId, 
			@PathVariable(value="productId") Integer productId,
			@PathVariable(value="priceList") Integer priceList);
}
