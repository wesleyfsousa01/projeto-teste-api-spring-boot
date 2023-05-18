package projetoteste.apispringboot.services.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class URLConverter {
    public static LocalDate converterData(String dateString){
        try{
            LocalDate date = LocalDate.parse(dateString);

            return date;

        }catch (DateTimeParseException e) {
            throw new DateTimeException("Formato inválido" + dateString);
        }
    }
}
