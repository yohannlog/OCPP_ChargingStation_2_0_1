package fr.yohann.bsim.types;

public record ChargingSchedulePeriodType(int startPeriod, float limit, int numberPhases, int phasesToUse) {
}
