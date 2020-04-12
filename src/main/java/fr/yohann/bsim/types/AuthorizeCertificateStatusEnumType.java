package fr.yohann.bsim.types;

public enum AuthorizeCertificateStatusEnumType
{
    Accepted,
    SignatureError,
    CertificateExpired,
    CertificateRevoked,
    NoCertificateAvailable,
    CertChainError,
    ContractCancelled
}
