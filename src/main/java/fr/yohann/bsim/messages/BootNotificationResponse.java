package fr.yohann.bsim.messages;

import com.google.gson.*;
import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;
import fr.yohann.bsim.types.RegistrationStatusEnumType;
import fr.yohann.bsim.types.StatusInfoType;

import java.lang.reflect.Type;
import java.net.http.WebSocket;
import java.util.Date;

public record BootNotificationResponse(Date dateTime, int interval, RegistrationStatusEnumType status, StatusInfoType statusInfo) implements JsonDeserializer {

    public BootNotificationResponse {
        if (dateTime == null) throw new ArgumentNotInitializedException("The dateTime is null");
        if (status == null) throw new ArgumentNotInitializedException("The status is null");
    }


    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return null;
    }
}
