package fr.yohann.bsim.types;

import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;

public record CostType(CostKindEnumType costKind, int amount, int amountMultiplier) {

    public CostType {
        if (costKind == null) throw new ArgumentNotInitializedException("The costKind in CostType is null");
    }
}
