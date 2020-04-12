package fr.yohann.bsim.messages;

import com.google.gson.annotations.Expose;
import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;
import fr.yohann.bsim.types.MeterValueType;

import java.util.List;

public record MeterValuesRequest(@Expose int evseId, @Expose List<MeterValueType> meterValue) {

    public MeterValuesRequest {
        if (meterValue == null || meterValue.isEmpty()) throw new ArgumentNotInitializedException("The meterValue in MeterValueRequest is null or empty");
    }
}
