package com.waterwest.xpayagent.model;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class WaterWestRawJsonObjectDeserializer implements JsonDeserializer<WaterWestRawJsonObject> {
	public WaterWestRawJsonObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		WaterWestRawJsonObject object = new WaterWestRawJsonObject();
		object.json = json.getAsJsonObject();
		return object;
	}

}
