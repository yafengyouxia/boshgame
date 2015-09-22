package com.waterwest.xpayagent.model;

import com.google.gson.*;

import java.lang.reflect.Type;

public class ChargeDeserializer implements JsonDeserializer<Charge> {

	@Override
	public Charge deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
				.registerTypeAdapter(WaterWestRawJsonObject.class, new WaterWestRawJsonObjectDeserializer()).create();
		Charge charge = gson.fromJson(jsonElement, Charge.class);

		return charge;
	}
}
