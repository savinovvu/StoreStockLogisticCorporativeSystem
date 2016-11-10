package ru.inbox.savinov_vu.util.bd;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
    @Override
    public final Timestamp convertToDatabaseColumn(LocalDateTime locDatetime) {
        return (locDatetime == null ? null : Timestamp.valueOf(locDatetime));
    }

    @Override
    public final LocalDateTime convertToEntityAttribute(Timestamp sqlDate) {
        return (sqlDate == null ? null : sqlDate.toLocalDateTime());
    }

}

