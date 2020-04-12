package fr.yohann.bsim.types;

import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;
import fr.yohann.bsim.exceptions.InvalidFieldValueException;

import java.util.List;

public record SalesTariffEntryType(int ePriceLevel, RelativeTimeIntervalType relativeTimeInterval, List<ConsumptionCostType> consumptionCost) {

    public SalesTariffEntryType {
        if (relativeTimeInterval == null) throw new ArgumentNotInitializedException("The relativeTimeInterval in SalesTariffEntryType is null");

        if (consumptionCost != null) {
            if (consumptionCost.size() > 2) {
                throw new InvalidFieldValueException("The consumptionCost list size in SalesTariffEntryType is too high (Limit 2)");
            }
        }
    }
}
