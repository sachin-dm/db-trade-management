package com.db.usecase.trades.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude
public class Trade {

    @JsonProperty
    private String tradeId;

    @JsonProperty
    private int version;

    @JsonProperty
    private String counterParty;

    @JsonProperty
    private String bookId;

    @JsonProperty
    private Date maturityDate;

    @JsonProperty
    private Date created;

    @JsonProperty
    private Boolean isExpired;

    public Trade() {
    }

    public Trade(String tradeId, int version, String counterParty, String bookId, Date maturityDate, Date created, Boolean isExpired) {
        this.tradeId = tradeId;
        this.version = version;
        this.counterParty = counterParty;
        this.bookId = bookId;
        this.maturityDate = maturityDate;
        this.created = created;
        this.isExpired = isExpired;
    }

    public Trade(String tradeId, int version, String counterParty, String bookId, Date maturityDate, Date created) {
        this.tradeId = tradeId;
        this.version = version;
        this.counterParty = counterParty;
        this.bookId = bookId;
        this.maturityDate = maturityDate;
        this.created = created;
    }

    public String getTradeId() {
        return tradeId;
    }

    public int getVersion() {
        return version;
    }

    public String getCounterParty() {
        return counterParty;
    }

    public String getBookId() {
        return bookId;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public Date getCreated() {
        return created;
    }

    public Boolean getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Boolean isExpired) {
        this.isExpired = isExpired;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setCounterParty(String counterParty) {
        this.counterParty = counterParty;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setExpired(Boolean expired) {
        isExpired = expired;
    }
}
