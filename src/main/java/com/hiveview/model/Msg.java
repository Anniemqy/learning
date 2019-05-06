package com.hiveview.model;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: xiaomeng
 * Date: 2019-05-06
 * Time: 17:56
 */
public class Msg {
    Msg() {

    }

    public static Map<String, String> sessionIdMap = null;

    public synchronized static Map<String, String> getInstance() {
        if (sessionIdMap == null) {
            sessionIdMap = Maps.newHashMap();
        }
        return sessionIdMap;
    }
}
