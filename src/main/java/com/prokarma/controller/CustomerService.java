package com.prokarma.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Iterator;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prokarma.api.NotFoundException;
import com.prokarma.dao.CustomerDao;
import com.prokarma.model.Customer;
import com.prokarma.model.Item;
import com.prokarma.model.Items;
import com.prokarma.model.Note;
import com.prokarma.util.AppUtil;
import com.prokarma.util.db.MongoDBHandler;

import ch.qos.logback.core.db.dialect.DBUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@PropertySource("classpath:swagger.properties")
@Controller
@RequestMapping(value = "/customers", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/customers", description = "The Customers API")
@CrossOrigin
public class CustomerService {

	@ApiOperation(value = "T-Mobile Customers", notes = "Gets `Customer` object.\nCustomers endpoint returns information about T-Mobile customer.\n", response = Customer.class)
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "successful operation"),
			@io.swagger.annotations.ApiResponse(code = 400, message = "Invalid SKU supplied"),
			@io.swagger.annotations.ApiResponse(code = 404, message = "Customer not found") })
	@RequestMapping(value = "/{customerId}", produces = { "application/json" },

			method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomerById(
			@ApiParam(value = "ID of customer that needs to be fetched", required = true) @PathVariable("customerId") Long customerId

	) throws NotFoundException {
		CustomerDao customerDao = new CustomerDao();
		return new ResponseEntity<Customer>(customerDao.getCustomer(customerId), HttpStatus.OK);
	}

	@ApiOperation(value = "T-Mobile Customers", notes = "Gets All Customers.\nCustomers endpoint returns information about T-Mobile customers.\n", response = Customer.class)
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "successful operation") })
	@RequestMapping(produces = { "application/json" },

			method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getCustomers(

	) throws NotFoundException {
		CustomerDao customerDao = new CustomerDao();
		return new ResponseEntity<List<Customer>>(customerDao.listAllCustomer(), HttpStatus.OK);
	}

	@ApiOperation(value = "Perform CRUD Operation in MongoDB", notes = "Creates/Retrieves/Updates/Deletes Note in Mongo DB.\n", response = Note.class)
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Successful Operation"),
			@io.swagger.annotations.ApiResponse(code = 200, message = "Un-Successful Operation") })
	@RequestMapping(value = "/{noteOwner}/{note}", produces = { "application/json" },

			method = RequestMethod.GET)
	public ResponseEntity<Note> performMongoDBCRUDOperation(
			@ApiParam(value = "Note Owner", required = true) @PathVariable("noteOwner") String noteOwner,
			@ApiParam(value = "Actual Note", required = true) @PathVariable("note") String note)
			throws NotFoundException {
		CustomerDao customerDao = new CustomerDao();
		if (MongoDBHandler.dbOperations.toUpperCase().contains("INSERT")) {
			System.out.println("NOTES INSERTED :::: " + MongoDBHandler.putNote(noteOwner, note));
			MongoDBHandler.getNote(noteOwner);
		}
		if (MongoDBHandler.dbOperations.toUpperCase().contains("UPDATE")) {
			System.out.println("NOTES UPDATED :::: " + MongoDBHandler.postNote(note, note + "::::UPDATED"));
			MongoDBHandler.getNote(noteOwner);
		}
		if (MongoDBHandler.dbOperations.toUpperCase().contains("DELETE")) {
			System.out.println("NOTES DELETED :::: " + MongoDBHandler.deleteNote(noteOwner));
			MongoDBHandler.getNote(noteOwner);
		}
		return new ResponseEntity<Note>(new Note(), HttpStatus.OK);
	}

	@ApiOperation(value = "Item for T-Mobile Customer", notes = "Gets `Item` object, based on the SKU\nOptional query param of **size** determines\nsize of returned array. Customers endpoint returns information about TMobile customer.\n", response = Item.class)
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "successful operation"),
			@io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied"),
			@io.swagger.annotations.ApiResponse(code = 404, message = "Item not found") })
	@RequestMapping(value = "/{customerId}/items/{sku}", produces = { "application/json" },

			method = RequestMethod.GET)
	public ResponseEntity<Item> getItemBySKU(
			@ApiParam(value = "SKU for the item to be fetched", required = true) @PathVariable("sku") Long sku,
			@ApiParam(value = "ID of customer that needs to be fetched", required = true) @PathVariable("customerId") Long customerId

	) throws NotFoundException {
		CustomerDao customerDao = new CustomerDao();
		List<Item> items = customerDao.getCustomer(customerId).getItems();
		Iterator<Item> iter = items.iterator();
		Item item = null;
		while (iter.hasNext()) {
			item = iter.next();
			if (item.getSku().equals(sku)) {
				break;
			}

		}
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}

	@ApiOperation(value = "Items for T-Mobile Customer", notes = "Gets `Item` object associated with customer\n", response = Items.class)
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "successful operation"),
			@io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied") })
	@RequestMapping(value = "/{customerId}/items", produces = { "application/json" },

			method = RequestMethod.GET)
	public ResponseEntity<Items> getItems(
			@ApiParam(value = "ID of customer that needs to be fetched", required = true) @PathVariable("customerId") Long customerId

	) throws NotFoundException {
		CustomerDao customerDao = new CustomerDao();
		return new ResponseEntity<Items>(customerDao.getCustomer(customerId).getItems(), HttpStatus.OK);
	}

	@Bean
	ApiInfo apiInfo() {
		System.out.println("apiInfo.................................................................");
		ApiInfo apiInfo = new ApiInfo("TMobile", "ProKarkma POC for mPOS", "0.0.0", "", "", "", "");
		return apiInfo;
	}

	@Bean
	public Docket customImplementation() {
		System.out.println("customImplementation.................................................................");
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().paths(regex("/customers.*")).build();

	}

	@Bean
	public Object getMongoDbCon() {
		System.out.println("loadAllDBProps.................................................................");
		AppUtil.loadAllDBProps();
		/*if(MongoDBHandler.dbHost != null && MongoDBHandler.dbPort != null){
			AppUtil.loadDBProps();
		}
		else{
			AppUtil.loadAllDBProps();
		}
		System.out.println("getMongoCon.................................................................");*/
		MongoDBHandler.getMongoCon(MongoDBHandler.dbHost, MongoDBHandler.dbPort);
		return new Object();
	}

}
