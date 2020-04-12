package fr.yohann.bsim.messages;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class Test implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
