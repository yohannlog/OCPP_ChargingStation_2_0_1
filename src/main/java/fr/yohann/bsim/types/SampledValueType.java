package fr.yohann.bsim.types;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;
import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;

public record SampledValueType(@Expose float value, @Expose ReadingContextEnumType context, @Expose MeasurandEnumType measurand, @Expose PhaseEnumType phase, @Expose LocationEnumType location,
                               @Expose SignedMeterValueType signedMeterValue, UnitOfMeasure unitOfMeasure) implements ExclusionStrategy {


    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        if (f.getName().equals("context"))
            return context == null;
        if (f.getName().equals("measurand"))
            return measurand == null;
        if (f.getName().equals("phase"))
            return phase == null;
        if (f.getName().equals("location"))
            return location == null;
        if (f.getName().equals("signedMeterValue"))
            return signedMeterValue == null;
        if (f.getName().equals("unitOfMeasure"))
            return unitOfMeasure == null;
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
