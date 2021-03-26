package com.db.usecase.trades.data.dao;

import com.db.usecase.trades.data.mapper.TradeRowMapper;
import com.db.usecase.trades.model.Trade;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.List;

@Component
public class TradeDao {

    private static final String INSERT_QUERY = "INSERT INTO trades VALUES (:tradeId, :version, :counterParty, :bookId, :maturityDate, :created, :isExpired);";
    private static final String SELECT_QUERY = "SELECT * FROM trades WHERE trade_id = :tradeId;";

    @Inject
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     *
     * @param tradeId
     * @return
     */
    public Trade getTradeById(String tradeId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("tradeId", tradeId);
        List<Trade> trade = namedParameterJdbcTemplate.query(SELECT_QUERY, paramSource, new TradeRowMapper());
        return CollectionUtils.isEmpty(trade) ? null : trade.get(0);
    }

    /**
     *
     * @param trade
     */
    public void addTrade(Trade trade) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("tradeId", trade.getTradeId());
        paramSource.addValue("version", trade.getVersion());
        paramSource.addValue("counterParty", trade.getCounterParty());
        paramSource.addValue("bookId", trade.getBookId());
        paramSource.addValue("maturityDate", trade.getMaturityDate());
        paramSource.addValue("created", trade.getCreated());
        paramSource.addValue("isExpired", trade.getIsExpired());

        namedParameterJdbcTemplate.update(INSERT_QUERY, paramSource);
    }
}
