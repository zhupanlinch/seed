package com.mysiteforme.admin.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhupan
 * @description 转换入参，出参中的 LocalDateTime LocalDate LocalTime
 */
@JsonComponent
public class JavaTimeJsonComponent {

    /**
     *
     */
    public static class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
        @Override
        public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime));
        }
    }

    /**
     *
     */
    public static class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
        @Override
        public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if(StringUtils.isEmpty(jsonParser.getText())) {
                return null;
            }
            return LocalDateTime.parse(jsonParser.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }

    /**
     *
     */
    public static class LocalDateSerializer extends JsonSerializer<LocalDate> {
        @Override
        public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate));
        }
    }

    /**
     *
     */
    public static class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
        @Override
        public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if(StringUtils.isEmpty(jsonParser.getText())) {
                return null;
            }
            return LocalDate.parse(jsonParser.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
    }

    /**
     *
     */
    public static class LocalTimeSerializer extends JsonSerializer<LocalTime> {
        @Override
        public void serialize(LocalTime localTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(DateTimeFormatter.ofPattern("HH:mm:ss").format(localTime));
        }
    }

    /**
     *
     */
    public static class LocalTimeDeserializer extends JsonDeserializer<LocalTime> {
        @Override
        public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if(StringUtils.isEmpty(jsonParser.getText())) {
                return null;
            }
            return LocalTime.parse(jsonParser.getText(), DateTimeFormatter.ofPattern("HH:mm:ss"));
        }
    }

}
