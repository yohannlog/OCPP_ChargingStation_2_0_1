package fr.yohann.bsim.types;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;
import fr.yohann.bsim.exceptions.InvalidFieldValueException;

public record UnitOfMeasure(@Expose String unit, @Expose int multiplier) implements ExclusionStrategy{

    public UnitOfMeasure {
        if (unit != null && unit.isEmpty()) throw new InvalidFieldValueException("The unit in UnitOfMeasure is empty");
        if (unit != null && unit.length() > 20) throw new InvalidFieldValueException("The unit length in UnitOfMeasure is too high (Limit 20)");
    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        if (f.getName().equals("unit"))
            return unit == null;
        if (f.getName().equals("multiplier"))
            return multiplier == 0;
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
