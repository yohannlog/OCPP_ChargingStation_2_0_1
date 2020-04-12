package fr.yohann.bsim.messages;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;
import fr.yohann.bsim.exceptions.InvalidFieldValueException;
import fr.yohann.bsim.types.IdTokenType;
import fr.yohann.bsim.types.OCSPRequestDataType;

import java.util.List;

public record AuthorizeRequest(@Expose String certificate, @Expose IdTokenType idToken, @Expose List<OCSPRequestDataType> iso15118CertificateHashData) implements ExclusionStrategy {

    public AuthorizeRequest {
        if (certificate != null && (certificate.isEmpty() || certificate.isBlank())) throw new InvalidFieldValueException("The certificate in AuthorizeRequest is empty");
        if (certificate != null) {
            if (certificate.length() > 5500) throw new InvalidFieldValueException("The certificate length is too high (Limit 5500)");
        }

        if (idToken == null) throw new InvalidFieldValueException("The idToken is null");

        if (!iso15118CertificateHashData.isEmpty()) {
            if (iso15118CertificateHashData.size() > 4) throw new InvalidFieldValueException("The isoCertificateHashData list size is too high (Limit 4)");
        }
    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        if (f.getName().equals("certificate"))
            return certificate == null;
        if (f.getName().equals("iso15118CertificateHashData"))
            return iso15118CertificateHashData == null || iso15118CertificateHashData.isEmpty();
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
