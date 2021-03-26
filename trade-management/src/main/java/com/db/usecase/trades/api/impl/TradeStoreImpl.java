package com.db.usecase.trades.api.impl;

import com.db.usecase.trades.api.ITradeStore;
import com.db.usecase.trades.model.Trade;
import com.db.usecase.trades.service.TradeService;
import com.db.usecase.trades.utils.VallidationUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import javax.inject.Inject;
import java.util.List;

@Component
public class TradeStoreImpl implements ITradeStore {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradeStoreImpl.class);

    @Inject
    private TradeService tradeService;

    @Override
    public ResponseEntity<String> store(String data) {
        ObjectMapper objectMapper = new ObjectMapper();

        Trade trade = null;
        boolean processingFlag = false;

        try {
            trade = objectMapper.readValue(data, Trade.class);

            LOGGER.info("Trade API - START !!");
            List<String> validationErrors = VallidationUtils.validate(trade);
            if (validationErrors.isEmpty()) {
                processingFlag = tradeService.processTrade(trade);
            } else {
                LOGGER.error("Validation failed for trade.");
                validationErrors.forEach(System.out::println);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        LOGGER.info("Trade API - END !!");
        if (processingFlag) {
            LOGGER.info("Request processed successfully");
            return new ResponseEntity<>(
                    "Processing successful! ",
                    HttpStatus.OK);
        } else {
            LOGGER.error("Invalid Request");
            return new ResponseEntity<>(
                            "Received Invalid request! ",
                            HttpStatus.BAD_REQUEST);
        }
    }
}
