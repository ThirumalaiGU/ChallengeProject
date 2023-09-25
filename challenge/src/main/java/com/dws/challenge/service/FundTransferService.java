package com.dws.challenge.service;


import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.dws.challenge.FundTransferMapper;
import com.dws.challenge.domain.FundTransferRequest;
import com.dws.challenge.mapper.FundTransferResponse;
import com.dws.challenge.repository.FundTransferEntity;
import com.dws.challenge.repository.FundTransferRepository;
import com.dws.challenge.web.AccountsController;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class FundTransferService {
    private  FundTransferRepository fundTransferRepository;
    private FundTransferMapper mapper = new FundTransferMapper();
	 Logger log = LogManager.getLogger(AccountsController.class);
	 
	 @Transactional
    public FundTransferResponse fundTransfer(FundTransferRequest request) {
		 try {
        log.info("Sending fund transfer request {}" + request.toString());
        FundTransferEntity entity = new FundTransferEntity();
        BeanUtils.copyProperties(request, entity);
        fundTransferRepository.save(entity);
        FundTransferResponse fundTransferResponse = new FundTransferResponse();
        fundTransferResponse.setTransactionId(UUID.randomUUID().toString());
        fundTransferResponse.setMessage("Success");
        return fundTransferResponse;
		 }
		 catch(Exception e){
	            throw new InternalException("Enterd value is not correct, Please check.");

		 }
    }
   
}
