package com.tw.apistackbase.exception;

import org.hibernate.exception.DataException;

import java.sql.SQLException;

public class DataToLongException extends DataException {
    public DataToLongException(String message, SQLException root) {
        super(message, root);
    }

    public DataToLongException(String message, SQLException root, String sql) {
        super(message, root, sql);
    }
}
