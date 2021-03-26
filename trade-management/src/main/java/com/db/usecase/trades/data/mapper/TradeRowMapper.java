package com.db.usecase.trades.data.mapper;

import com.db.usecase.trades.model.Trade;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TradeRowMapper implements RowMapper<Trade> {

    @Override
    public Trade mapRow(ResultSet resultSet, int i) throws SQLException {
       return new Trade(
                resultSet.getString("trade_id"),
                resultSet.getInt("version"),
                resultSet.getString("counter_party"),
                resultSet.getString("book_id"),
                resultSet.getDate("maturity_date"),
                resultSet.getDate("create"),
                resultSet.getBoolean("is_expired")
        );
    }
}
