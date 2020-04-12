package fr.yohann.bsim.types;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;
import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;
import fr.yohann.bsim.exceptions.InvalidFieldValueException;
import fr.yohann.bsim.utils.Utils;

import java.util.List;

public record IdTokenType(@Expose String idToken, @Expose IdTokenEnumType type, @Expose List<AdditionalInfoType>additionalInfo) implements ExclusionStrategy {

    public IdTokenType {
        if (idToken == null || idToken.isEmpty() || idToken.isBlank()) throw new ArgumentNotInitializedException("The idToken is null or empty");
        if (!Utils.isIdentifierString(idToken)) throw new InvalidFieldValueException("The idToken is not an ISO valid format");
        if (idToken.length() > 36) throw new InvalidFieldValueException("The idToken length is too high (Limit 36)");

        if (type == null) throw new ArgumentNotInitializedException("The type is null");
    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        if (f.getName().equals("additionalInfo"))
            return additionalInfo == null || additionalInfo.isEmpty();
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
