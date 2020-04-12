package fr.yohann.bsim.types;

import fr.yohann.bsim.exceptions.InvalidFieldValueException;
import fr.yohann.bsim.utils.Utils;

import java.util.Date;
import java.util.List;

public record IdTokenInfoType(AuthorizeCertificateStatusEnumType status, Date cacheExpiryDateTime, int chargingPriority, String language1
                                , List<Integer> evseId, String language2, IdTokenType groupIdToken, MessageContentType personalMessage) {

    public IdTokenInfoType {
        if (status == null) throw new InvalidFieldValueException("The status is null");

        if (language1 != null) {
            if (language1.isEmpty()) throw new InvalidFieldValueException("The language1 is empty");
            if (language1.length() > 8) throw new InvalidFieldValueException("The language1 length is too high (Limit 8)");
        }

        if (language2 != null) {
            if (language2.isEmpty()) throw new InvalidFieldValueException("The language2 is empty");
            if (language2.length() > 8) throw new InvalidFieldValueException("The language2 length is too high (Limit 8)");
        }
    }
}
