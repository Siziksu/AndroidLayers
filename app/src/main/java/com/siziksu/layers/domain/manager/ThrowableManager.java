package com.siziksu.layers.domain.manager;

import android.util.Log;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.HttpException;

public final class ThrowableManager {

    private static final int CONNECTION_EXCEPTION = 0;
    private static final int TIME_OUT_EXCEPTION = 1;
    private static final int UNAUTHORIZED_EXCEPTION = 2;
    private static final int SERVER_EXCEPTION = 3;
    private static final int GENERIC_EXCEPTION = 4;

    private static final String TAG = "ThrowableManager";

    private ThrowableManager() {}

    public static String getErrorString(Throwable throwable) {
        int error = handleException(throwable);
        String message;
        switch (error) {
            case ThrowableManager.CONNECTION_EXCEPTION:
                message = "Error: there was a connection error";
                break;
            case ThrowableManager.SERVER_EXCEPTION:
                message = "Error: there was a server error";
                break;
            case ThrowableManager.TIME_OUT_EXCEPTION:
                message = "Error: there was a time out";
                break;
            case ThrowableManager.UNAUTHORIZED_EXCEPTION:
                message = "Error: unauthorized call";
                break;
            case ThrowableManager.GENERIC_EXCEPTION:
            default:
                message = "There was an error";
                break;
        }
        return message;
    }

    private static int handleException(Throwable throwable) {
        Log.e(TAG, throwable.getMessage(), throwable);
        int type;
        if (throwable instanceof HttpException) {
            Log.e(TAG, "HttpException");
            type = handleHttpException(throwable);
        } else if (throwable instanceof ConnectException) {
            Log.e(TAG, "ConnectException");
            type = CONNECTION_EXCEPTION;
        } else if (throwable instanceof SocketTimeoutException) {
            Log.e(TAG, "SocketTimeoutException");
            type = TIME_OUT_EXCEPTION;
        } else {
            Log.e(TAG, "GenericException");
            type = GENERIC_EXCEPTION;
        }
        return type;
    }

    private static int handleHttpException(Throwable throwable) {
        int code = ((HttpException) throwable).response().code();
        if (code >= 500) {
            return SERVER_EXCEPTION;
        } else if (code == 401) {
            return UNAUTHORIZED_EXCEPTION;
        }
        return GENERIC_EXCEPTION;
    }
}
