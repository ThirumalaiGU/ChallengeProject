package com.dws.challenge;


import org.springframework.beans.BeanUtils;

import com.dws.challenge.domain.FundTransfer;
import com.dws.challenge.repository.FundTransferEntity;
public class FundTransferMapper {
    public FundTransferEntity convertToEntity(FundTransfer dto, Object... args) {
        FundTransferEntity entity = new FundTransferEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }
    public FundTransfer convertToDto(FundTransferEntity entity, Object... args) {
        FundTransfer dto = new FundTransfer();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }
}