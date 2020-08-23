package com.bank.model;

import javax.validation.constraints.Size;

public class Customer {


	private Integer customerId;
	@Size(min=2, message="Name should have atleast 2 characters")
	private String customerName;
	private String customerAccountType;

	public Customer() {

	}

	public Customer(Integer customerId, String customerName, String customerAccountType) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAccountType = customerAccountType;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAccountType() {
		return customerAccountType;
	}

	public void setCustomerAccountType(String customerAccountType) {
		this.customerAccountType = customerAccountType;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAccountType="
				+ customerAccountType + "]";
	}
}
