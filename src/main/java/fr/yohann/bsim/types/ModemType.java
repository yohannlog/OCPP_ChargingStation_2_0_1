package fr.yohann.bsim.types;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;
import fr.yohann.bsim.exceptions.InvalidFieldValueException;
import fr.yohann.bsim.utils.Utils;

public record ModemType(@Expose String iccid, @Expose String imsi) implements ExclusionStrategy {
    public ModemType {
        if (iccid != null && iccid.isEmpty() || iccid.isBlank()) throw new InvalidFieldValueException("The iccid in ModemType is empty");
        if (!Utils.isIdentifierString(iccid)) throw new InvalidFieldValueException("The iccid in ModemType doesn't respect 'identifierString' type");
        if (iccid.length() > 20) throw new InvalidFieldValueException("The iccid length in ModemType is too high (Limit 2à)");

        if (imsi != null && imsi.isEmpty() || imsi.isBlank()) throw new InvalidFieldValueException("The imsi in ModemType is empty");
        if (!Utils.isIdentifierString(imsi)) throw new InvalidFieldValueException("The imsi in ModemType doesn't respect 'identifierString' type");
        if (imsi.length() > 20) throw new InvalidFieldValueException("The imsi length in ModemType is too high (Limit 20)");
    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        if (f.getName().equals("iccid"))
            return iccid == null;
        if (f.getName().equals("imsi"))
            return imsi == null;
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
