package com.prokarma.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.prokarma.model.Customer;
import com.prokarma.model.Item;
import com.prokarma.model.Items;

public class CustomerDao {
	static Map<Long, Customer> customerData = new HashMap();

	enum firstName {
		John, Rohit, Ninod, Anshuman, Praveen
	};

	enum lastName {
		Doe, Kumar, Pillai, Singh, Karampudi
	};

	static {
		for (int i = 0; i < 5; i++) {
			Customer customer = CustomerDao.createCustomer(i + 1L);
			CustomerDao.customerData.put(i + 1L, customer);

		}
	}

	public Customer getCustomer(Long customerId) {
		return (Customer) this.customerData.get(customerId);
	}

	public List<Customer> listAllCustomer() {
		List customerList = new ArrayList(this.customerData.values());
		return customerList;
	}

	private static Customer createCustomer(Long customerId) {
		long LOWER_RANGE = 0; // assign lower range value
		long UPPER_RANGE = 1000000; // assign upper range value
		Random random = new Random();

		long randomValue = LOWER_RANGE
				+ (long) (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE));
		Customer customer = new Customer();
		customer.setAcctBalance(randomValue);
		customer.setAcctNum(randomValue * 2 / 10);
		customer.setAcctStatus("OPEN");
		customer.setAcctType("individual");
		customer.setId(customerId);
		customer.setCustFirstName(firstName.values()[(int) (customerId - 1)]
				.toString());
		customer.setCustLastName(lastName.values()[(int) (customerId - 1)]
				.toString());
		Items items = new Items();
		for (int i = 0; i < 6; i++) {
			
			Item item = createItem(i+1L);
			items.add(item);

		}
		customer.setItems(items);
		return customer;
	}

	private static Item createItem(Long sku) {
		Item item = new Item();
		item.setSku(sku);
		long LOWER_RANGE =10000; // assign lower range value
		long UPPER_RANGE = 99999; // assign upper range value
		Random random = new Random();

		long randomValue = LOWER_RANGE
				+ (long) (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE));
		String phNo = "079393" + randomValue;
		item.setMobileNumber(Long.valueOf(phNo));
		item.setProdDesc("Unlimited LTE smartphone data");
		item.setRatePlan("3 lines, $50 each/mo. 4th line FREE");
		item.setListPrice(Long.valueOf("50"));
		item.setExtendedPrice(Long.valueOf("100"));
		return item;
	}
}