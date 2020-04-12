package fr.yohann.bsim.types;

import com.google.gson.annotations.Expose;
import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;

import java.util.Date;
import java.util.List;

public record MeterValueType(@Expose Date timestamp, @Expose List<SampledValueType> sampledValue) {

    public MeterValueType {
        if (timestamp == null) throw new ArgumentNotInitializedException("The timestamp in MeterValueType is null");

        if (sampledValue == null || sampledValue.isEmpty()) throw new ArgumentNotInitializedException("The sampledValue in MeterValueType is null or empty");
    }
}
