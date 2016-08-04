package com.prokarma.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

@ApiModel(description = "")

public class Customer {

	private Long id = null;
	private String custFirstName = null;
	private String custLastName = null;
	private Long acctNum = null;
	private String acctType = null;
	private String acctStatus = null;
	private Long acctBalance = null;
	private Items items = null;

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("custFirstName")
	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("custLastName")
	public String getCustLastName() {
		return custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("acctNum")
	public Long getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(Long acctNum) {
		this.acctNum = acctNum;
	}

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("acctType")
	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("acctStatus")
	public String getAcctStatus() {
		return acctStatus;
	}

	public void setAcctStatus(String acctStatus) {
		this.acctStatus = acctStatus;
	}

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("acctBalance")
	public Long getAcctBalance() {
		return acctBalance;
	}

	public void setAcctBalance(Long acctBalance) {
		this.acctBalance = acctBalance;
	}

	@ApiModelProperty(value = "")
	@JsonProperty("items")
	public Items getItems() {
		
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Customer customer = (Customer) o;
		return Objects.equals(id, customer.id)
				&& Objects.equals(custFirstName, customer.custFirstName)
				&& Objects.equals(custLastName, customer.custLastName)
				&& Objects.equals(acctNum, customer.acctNum)
				&& Objects.equals(acctType, customer.acctType)
				&& Objects.equals(acctStatus, customer.acctStatus)
				&& Objects.equals(acctBalance, customer.acctBalance);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, custFirstName, custLastName, acctNum, acctType,
				acctStatus, acctBalance);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Customer {\n");

		sb.append("  id: ").append(id).append("\n");
		sb.append("  custFirstName: ").append(custFirstName).append("\n");
		sb.append("  custLastName: ").append(custLastName).append("\n");
		sb.append("  acctNum: ").append(acctNum).append("\n");
		sb.append("  acctType: ").append(acctType).append("\n");
		sb.append("  acctStatus: ").append(acctStatus).append("\n");
		sb.append("  acctBalance: ").append(acctBalance).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
