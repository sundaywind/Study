package com.wind.bean;

import java.util.Date;

public class ColumnsPriv {
    private String host;

    private String db;

    private String user;

    private String tableName;

    private String columnName;

    private Date timestamp;

    private String columnPriv;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db == null ? null : db.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getColumnPriv() {
        return columnPriv;
    }

    public void setColumnPriv(String columnPriv) {
        this.columnPriv = columnPriv == null ? null : columnPriv.trim();
    }
}