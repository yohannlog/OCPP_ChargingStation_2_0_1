package fr.yohann.bsim.messages;

import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;
import fr.yohann.bsim.types.ChargingProfileType;
import fr.yohann.bsim.types.IdTokenType;

public record RequestStartTransaction(int evseId, int remoteStartId, IdTokenType idToken, ChargingProfileType chargingProfile) {

    public RequestStartTransaction {
        if (idToken == null) throw new ArgumentNotInitializedException("The idToken in RequestStartTransaction is null");
    }
}
