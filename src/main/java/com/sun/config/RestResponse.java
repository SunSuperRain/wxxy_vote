package com.sun.config;

import lombok.Data;

import java.time.Instant;

/**
 * @AUTHOR soft
 * @DATE 2018/10/30 14:55
 * @DESCRIBE 统一的Json返回类
 */
@Data
public class RestResponse<T> {
    private T payload;

    private boolean success;
    private String msg;
    private Integer status = 0;
    private long timestamp;

    public RestResponse() {
        this.timestamp = nowUnix();
    }

    public RestResponse(boolean success) {
        this.timestamp = nowUnix();
        this.success = success;
    }

    public RestResponse(boolean success, T payload) {
        this.timestamp = nowUnix();
        this.success = success;
        this.payload = payload;
    }

    public RestResponse<T> success(boolean success) {
        this.success = success;
        return this;
    }

    public RestResponse<T> payload(T payload) {
        this.payload = payload;
        return this;
    }

    public RestResponse<T> status(Integer status) {
        this.status = status;
        return this;
    }

    public RestResponse<T> message(String msg) {
        this.msg = msg;
        return this;
    }

    public static <T> RestResponse<T> ok() {
        return new RestResponse<T>().success(true).status(200);
    }

    public static <T> RestResponse<T> tip(String message) {
        return new RestResponse<T>().success(true).message(message).status(200);
    }

    public static <T> RestResponse<T> tip(String message, Integer status) {
        return new RestResponse<T>().success(true).message(message).status(status);
    }

    public static <T> RestResponse<T> ok(T payload) {
        return new RestResponse<T>().success(true).payload(payload).status(200);
    }

    public static <T> RestResponse ok(T payload, Integer code) {
        return new RestResponse<T>().success(true).payload(payload).status(code);
    }

    public static <T> RestResponse<T> fail() {
        return new RestResponse<T>().success(false).status(404);
    }

    public static <T> RestResponse<T> fail(String message) {
        return new RestResponse<T>().success(false).message(message).status(404);
    }

    public static <T> RestResponse fail(Integer code, String message) {
        return new RestResponse<T>().success(false).message(message).status(code);
    }

    public static <T> RestResponse fail(Integer code, T payload) {
        return new RestResponse<T>().success(false).payload(payload).status(code);
    }

    private long nowUnix() {
        return Instant.now().getEpochSecond();
    }
}
