package com.waterwest.xpayagent.model;

import com.google.gson.Gson;
import com.waterwest.xpayagent.net.APIResource;

public class Notify {
    class InnerObject {
        String object;
    }

    public static Object parseNotify(String notifyJson) {

        InnerObject innerObject;
        try {
            innerObject = new Gson().fromJson(notifyJson, InnerObject.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        if(innerObject == null || innerObject.object == null || innerObject.object.isEmpty())
            return null;

        if(innerObject.object.equals("charge")) {
            return APIResource.GSON.fromJson(notifyJson, Charge.class);
        }

        return null;
    }
}
