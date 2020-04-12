package fr.yohann.bsim.types;

import com.google.gson.annotations.Expose;
import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;
import fr.yohann.bsim.exceptions.InvalidFieldValueException;

public record SignedMeterValueType(@Expose String signedMeterData, @Expose String signingMethod, @Expose String encodingMethod, @Expose String publicKey) {

    public SignedMeterValueType {
        if (signedMeterData == null || signedMeterData.isEmpty()) throw new ArgumentNotInitializedException("The signedMeterData in SignedMeterValueType is null or empty");
        if (signedMeterData.length() > 2500) throw new InvalidFieldValueException("The signedMeterData length in SignedMeterValueType is too high (Limit 2500)");

        if (signingMethod == null || signingMethod.isEmpty()) throw new ArgumentNotInitializedException("The signingMethod in SignedMeterValueType is null or empty");
        if (signingMethod.length() > 50) throw new InvalidFieldValueException("The signingMethod length in SignedMeterValueType is too high (Limit 50)");

        if (encodingMethod == null || encodingMethod.isEmpty()) throw new ArgumentNotInitializedException("The encodingMethod in SignedMeterValueType is null or empty");
        if (encodingMethod.length() > 50) throw new InvalidFieldValueException("The encodingMethod length in SignedMeterValueType is too high (Limit 50)");

        if (publicKey == null || publicKey.isEmpty()) throw new ArgumentNotInitializedException("The publicKey in SignedMeterValueType is null or empty");
        if (publicKey.length() > 2500) throw new InvalidFieldValueException("The publicKey length in SignedMeterValueType is too high (Limit 250)");
    }
}
