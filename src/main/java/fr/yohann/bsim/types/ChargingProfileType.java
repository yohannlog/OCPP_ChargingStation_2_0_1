package fr.yohann.bsim.types;

import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;

import java.util.Date;
import java.util.List;

public record ChargingProfileType(int id, int stackLevel, ChargingProfilePurposeEnumType chargingProfilePurpose, ChargingProfileKindEnumType chargingProfileKind,
                                  RecurrencyKindEnumType reccurencyKind, Date validFrom, Date validTo, String transactionId, List<ChargingScheduleType> chargingSchedule) {

    public ChargingProfileType {
        if (chargingProfilePurpose == null) throw new ArgumentNotInitializedException("The chargingProfilePurpose in ChargingProfileType is null");

        if (chargingProfileKind == null) throw new ArgumentNotInitializedException("The chargingProfileKind in ChargingProfileType is null");

        if (transactionId != null && transactionId.isEmpty()) throw new ArgumentNotInitializedException("The transactionId in chargingProfileKind is empty");
        if (transactionId != null && transactionId.length() > 36) throw new ArgumentNotInitializedException("The transactionId length in chargingProfileKind is too high (Limit 36)");

        if (chargingSchedule == null || chargingSchedule.isEmpty()) throw new ArgumentNotInitializedException("The chargingSchedule in ChargingProfileType is null or empty");
        if (chargingSchedule.size() > 3) throw new ArgumentNotInitializedException("The chargingSchedule size in ChargingProfileType is too high (Limit 3)");
    }
}
