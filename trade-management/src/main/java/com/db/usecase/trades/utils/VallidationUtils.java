package com.db.usecase.trades.utils;

import com.db.usecase.trades.model.Trade;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class VallidationUtils {

    public static List<String> validate(Trade trade) {
        List<String> validationErrors = new ArrayList<>();

        if (Objects.isNull(trade)) {
            validationErrors.add("Trade object cannot be null");
            return validationErrors;
        }

        if (trade.getMaturityDate().compareTo(new Date()) < 0) {
            validationErrors.add("Maturity date cannot be less that current date.");
        }

        return validationErrors;
    }
}
