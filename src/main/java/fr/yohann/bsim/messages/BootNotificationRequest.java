package fr.yohann.bsim.messages;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;
import fr.yohann.bsim.types.BootReasonEnumType;
import fr.yohann.bsim.types.ChargingStationType;

public record BootNotificationRequest(@Expose BootReasonEnumType reason, @Expose ChargingStationType chargingStation) implements ExclusionStrategy {

    public BootNotificationRequest {
        if (reason == null) throw new ArgumentNotInitializedException("reason is null");
        if (chargingStation == null) throw new ArgumentNotInitializedException("chargingStation is null");
    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
