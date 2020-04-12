package fr.yohann.bsim.types;

import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;
import fr.yohann.bsim.exceptions.InvalidFieldValueException;

import java.util.List;

public record SalesTariffType(int id, String salesTariffDescription, int numEPriceLevels, List<SalesTariffEntryType> salesTariffEntry) {

    public SalesTariffType {
        if (salesTariffDescription != null) {
            if (salesTariffDescription.length() > 32) {
                throw new InvalidFieldValueException("The salesTariffDescription length in SalesTariffType is too high (Limit 32)");
            }
        }

        if (salesTariffEntry == null || salesTariffEntry.isEmpty()) throw new ArgumentNotInitializedException("The salesTariffEntry in SalesTariffType is null or empty");
        if (salesTariffEntry.size() > 1024) throw new InvalidFieldValueException("The salesTariffEntry list size if too high (Limit 2014)");
    }
}
