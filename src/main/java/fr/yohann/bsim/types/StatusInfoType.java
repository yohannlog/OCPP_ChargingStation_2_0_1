package fr.yohann.bsim.types;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;
import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;
import fr.yohann.bsim.exceptions.InvalidFieldValueException;

public record StatusInfoType(@Expose(serialize = true, deserialize = false) String reasonCode, @Expose(serialize = true, deserialize = false) String additionalInfo) implements ExclusionStrategy {

    public StatusInfoType {
        if (reasonCode == null || reasonCode.isEmpty()) throw new ArgumentNotInitializedException("The reasonCode is null or empty");

        if (additionalInfo != null && additionalInfo.isEmpty()) throw new InvalidFieldValueException("The additionalInfo in StatusInfoType is empty");
        if (additionalInfo != null && additionalInfo.length() > 512) throw new InvalidFieldValueException("The additionalInfo length in StatusInfoType is too high (Limit 512)");

    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        if (f.getName().equals("additionalInfo"))
            return additionalInfo == null;
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
