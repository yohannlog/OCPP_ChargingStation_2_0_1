package fr.yohann.bsim.messages;

import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;
import fr.yohann.bsim.exceptions.InvalidFieldValueException;
import fr.yohann.bsim.types.AuthorizeCertificateStatusEnumType;
import fr.yohann.bsim.types.IdTokenInfoType;

public record AuthorizeResponse(AuthorizeCertificateStatusEnumType certificateStatus, IdTokenInfoType idTokenInfo) {

    public AuthorizeResponse {
        if (idTokenInfo == null) throw new ArgumentNotInitializedException("The idTokenInfo of AuthorizeResponse is null");
    }
}
