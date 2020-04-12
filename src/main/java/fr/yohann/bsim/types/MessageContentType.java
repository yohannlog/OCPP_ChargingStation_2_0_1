package fr.yohann.bsim.types;

import fr.yohann.bsim.exceptions.InvalidFieldValueException;

public record MessageContentType(MessageFormatEnumType type, String language, String content) {

    public MessageContentType {
        if (type == null) throw new InvalidFieldValueException("The type is null");

        if (language != null && language.isEmpty()) throw new InvalidFieldValueException("The language is empty");
        if (language.length() > 8) throw new InvalidFieldValueException("The language length is too high (Limit 8)");

        if (content == null ) throw new InvalidFieldValueException("The content is null");
        if (content != null && content.isEmpty()) throw new InvalidFieldValueException("The content is empty");
        if (content.length() > 512) throw new InvalidFieldValueException("The content length is too high (Limit 512)");
    }
}
