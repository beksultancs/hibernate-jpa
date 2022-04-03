package peaksoft.hibernatejpa.model.converters;

import javax.persistence.AttributeConverter;

/**
 * @author Beksultan
 */
public class YesOrNoBooleanConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        return aBoolean ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String s) {
       return s.equals("Y");
    }
}

