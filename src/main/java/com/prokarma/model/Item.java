package com.prokarma.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@ApiModel(description = "")

public class Item {

	private Long sku = null;
	private String prodDesc = null;
	private String ratePlan = null;
	private Long mobileNumber = null;
	private Long listPrice = null;
	private Long extendedPrice = null;

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("sku")
	public Long getSku() {
		return sku;
	}

	public void setSku(Long sku) {
		this.sku = sku;
	}

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("prodDesc")
	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("ratePlan")
	public String getRatePlan() {
		return ratePlan;
	}

	public void setRatePlan(String ratePlan) {
		this.ratePlan = ratePlan;
	}

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("mobileNumber")
	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("listPrice")
	public Long getListPrice() {
		return listPrice;
	}

	public void setListPrice(Long listPrice) {
		this.listPrice = listPrice;
	}

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("extendedPrice")
	public Long getExtendedPrice() {
		return extendedPrice;
	}

	public void setExtendedPrice(Long extendedPrice) {
		this.extendedPrice = extendedPrice;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Item item = (Item) o;
		return Objects.equals(prodDesc, item.prodDesc)
				&& Objects.equals(ratePlan, item.ratePlan)
				&& Objects.equals(mobileNumber, item.mobileNumber)
				&& Objects.equals(listPrice, item.listPrice)
				&& Objects.equals(extendedPrice, item.extendedPrice);
	}

	@Override
	public int hashCode() {
		return Objects.hash(prodDesc, ratePlan, mobileNumber, listPrice,
				extendedPrice);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Item {\n");

		sb.append("  prodDesc: ").append(prodDesc).append("\n");
		sb.append("  ratePlan: ").append(ratePlan).append("\n");
		sb.append("  mobileNumber: ").append(mobileNumber).append("\n");
		sb.append("  listPrice: ").append(listPrice).append("\n");
		sb.append("  extendedPrice: ").append(extendedPrice).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
