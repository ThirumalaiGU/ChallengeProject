package com.dws.challenge.mapper;

import lombok.Data;
@Data
public class FundTransferResponse {
    private String message;
    private String transactionId;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
    
    
}
