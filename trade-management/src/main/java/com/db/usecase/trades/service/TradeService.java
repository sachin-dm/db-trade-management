package com.db.usecase.trades.service;

import com.db.usecase.trades.data.dao.TradeDao;
import com.db.usecase.trades.model.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Objects;

@Component
public class TradeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradeService.class);

    @Inject
    private TradeDao tradeDao;

    public synchronized boolean processTrade(final Trade newTrade) {
        LOGGER.info("Trade processing - START");
        try {
            Trade existingTrade = tradeDao.getTradeById(newTrade.getTradeId());

            if (Objects.nonNull(existingTrade) && existingTrade.getVersion() > newTrade.getVersion()) {
                LOGGER.warn("Received lower version -> {} of trade -> {}. Current trade version is -> {}.", newTrade.getVersion(), existingTrade.getTradeId(), existingTrade.getTradeId());
                return false;
            } else {
                tradeDao.addTrade(newTrade);
                LOGGER.info("Added new Trade -> {} successfully.", newTrade.getTradeId());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            LOGGER.info("Trade processing - END");
        }
        return true;
    }
}
