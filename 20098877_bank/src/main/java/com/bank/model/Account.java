package com.bank.model;

public class Account {
	
	private Integer accountrId;
	private String accountName;
	private String customerBranchName;
	
	public Account() {
		super();
	}
	public Account(Integer accountrId, String accountName, String customerBranchName) {
		super();
		this.accountrId = accountrId;
		this.accountName = accountName;
		this.customerBranchName = customerBranchName;
	}
	@Override
	
	public String toString() {
		return "Account [accountrId=" + accountrId + ", accountName=" + accountName + ", customerBranchName="
				+ customerBranchName + "]";
	}
	
	public Integer getAccountrId() {
		return accountrId;
	}
	public void setAccountrId(Integer accountrId) {
		this.accountrId = accountrId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getCustomerBranchName() {
		return customerBranchName;
	}
	public void setCustomerBranchName(String customerBranchName) {
		this.customerBranchName = customerBranchName;
	}

}
