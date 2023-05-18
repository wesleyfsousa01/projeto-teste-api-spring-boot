package projetoteste.apispringboot.controllers.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class URLConverter {
    public static LocalDate converterData(String dateString) throws DateTimeException {
        try{
            LocalDate date = LocalDate.parse(dateString);

            return date;

        }catch (DateTimeParseException e) {
            throw new DateTimeException("Formato inválido" + dateString);
        }
    }
}
