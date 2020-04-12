package fr.yohann.bsim.types;

import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;
import fr.yohann.bsim.exceptions.InvalidFieldValueException;
import fr.yohann.bsim.utils.Utils;

public record OCSPRequestDataType(HashAlgorithmEnumType hashAlgorithm, String issuerNameHash, String issuerKeyHash, String serialNumber, String responderURL) {

    public OCSPRequestDataType {
        if (hashAlgorithm == null) throw new ArgumentNotInitializedException("The hashAlgorithm is null");

        if (issuerNameHash == null || issuerNameHash.isEmpty()) throw new ArgumentNotInitializedException("The issuerNameHash is null or empty");
        if (!Utils.isIdentifierString(issuerNameHash)) throw new InvalidFieldValueException("The issuerNameHash is not an RFC valid format");
        if (issuerNameHash.length() > 128) throw new InvalidFieldValueException("The issuersNameHash length is too high (Limit 128)");

        if (serialNumber == null || serialNumber.isEmpty()) throw new ArgumentNotInitializedException("The serial number is null or empty");
        if (!Utils.isIdentifierString(serialNumber)) throw new InvalidFieldValueException("The serialNumber is not an RFC string valid format");

        if (responderURL == null || responderURL.isEmpty() || responderURL.isBlank()) throw new ArgumentNotInitializedException("The responderURL is null or empty");
        if (responderURL.length() > 512) throw new InvalidFieldValueException("The responderURL length is too high (Limit 512)");
    }
}
