package fr.yohann.bsim.types;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;
import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;
import fr.yohann.bsim.exceptions.InvalidFieldValueException;
import fr.yohann.bsim.utils.Utils;

public record AdditionalInfoType(@Expose String additionalIdToken, @Expose String type){

    public AdditionalInfoType {
        if (additionalIdToken == null || additionalIdToken.isEmpty()) throw new ArgumentNotInitializedException("The additionalIdToken is null or empty");
        if (additionalIdToken.length() > 26) throw new InvalidFieldValueException("The additionalIdToken length is too high (Limit 26)");
        if (!Utils.isIdentifierString(additionalIdToken)) throw new InvalidFieldValueException("The additionalIdToken is not an ISO UTC format");

        if (type == null || type.isEmpty()) throw new ArgumentNotInitializedException("The type is null or empty");
        if (type.length() > 50) throw new InvalidFieldValueException("The type length is too high (Limit 50)");
    }
}
