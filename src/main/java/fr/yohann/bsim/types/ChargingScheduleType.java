package fr.yohann.bsim.types;

import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;
import fr.yohann.bsim.exceptions.InvalidFieldValueException;

import java.util.Date;
import java.util.List;

public record ChargingScheduleType(int id, Date startSchedule, int duration, ChargingRateUnitEnumType chargingRateUnit, float minChargingRate,
                                   List<ChargingSchedulePeriodType> chargingSchedulePeriod, SalesTariffType salesTariff) {

    public ChargingScheduleType {
        if (chargingRateUnit == null) throw new ArgumentNotInitializedException("The chargingRateUnit in ChargingScheduleType is null");

        if (chargingSchedulePeriod == null || chargingSchedulePeriod.isEmpty()) throw new ArgumentNotInitializedException("The chargingSchedulePeriod in ChargingScheduleType is null or empty");
        if (chargingSchedulePeriod.size() > 1024) throw new InvalidFieldValueException("The chargingSchedulePeriod size in ChargingScheduleType is too high (Limit 1024)");
    }
}
