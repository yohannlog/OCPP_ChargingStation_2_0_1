package fr.yohann.bsim.types;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;
import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;
import fr.yohann.bsim.exceptions.InvalidFieldValueException;

public record ChargingStationType(@Expose String serialNumber, @Expose String model, @Expose String vendorName, @Expose String firmwareVersion, @Expose ModemType modem) implements ExclusionStrategy
{
    public ChargingStationType {

        if (serialNumber != null && serialNumber.isEmpty()) throw new InvalidFieldValueException("The serialNumber in ChargingStationType is empty");
        if (serialNumber != null && serialNumber.length() > 25) throw new InvalidFieldValueException("The serialNumber length in ChargingStationType is too high (Limit 25)");

        if (model == null || model.isEmpty()) throw new ArgumentNotInitializedException("model is null or empty");
        if (model.length() > 20) throw new InvalidFieldValueException("The model length in ChargingStationType is too high (Limit 20)");

        if (vendorName == null || vendorName.isEmpty()) throw new ArgumentNotInitializedException("vendorName is null or empty");
        if (vendorName.length() > 50) throw new InvalidFieldValueException("The vendorName length in ChargingStationType is too high (Limit 50)");

        if (firmwareVersion != null && firmwareVersion.isEmpty()) throw new InvalidFieldValueException("The firmwareVersion in ChargingStationType is empty");
        if (firmwareVersion != null && firmwareVersion.length() > 50) throw new InvalidFieldValueException("The firmwareVersion length in ChargingStationType is too high (Limit 50)");
    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        if (f.getName().equals("serialNumber"))
            return serialNumber == null;
        if (f.getName().equals("firmwareVersion"))
            return firmwareVersion == null;
        if (f.getName().equals("modem"))
            return modem == null;
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
