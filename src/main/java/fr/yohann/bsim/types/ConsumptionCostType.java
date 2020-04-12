package fr.yohann.bsim.types;

import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;
import fr.yohann.bsim.exceptions.InvalidFieldValueException;

import java.util.List;

public record ConsumptionCostType(float startValue, List<CostType> cost) {

    public ConsumptionCostType {
        if (cost == null || cost.isEmpty()) throw new ArgumentNotInitializedException("The cost in ConsumptionCostType is null or empty");
        if (cost.size() > 2) throw new InvalidFieldValueException("The cost list size in ConsumptionCosType is too high (Limit 2)");
    }
}
