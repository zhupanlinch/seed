package com.mysiteforme.admin.converter;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhupan
 * @description 转换入参，出参中的 LocalDateTime LocalDate LocalTime
 */
@Configuration
public class JavaDateConverter {

    @Bean
    public Converter<String, LocalDateTime> stringLocalDateTimeConverter() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String s) {
                if(StringUtils.isEmpty(s)) {
                    return null;
                }
                return LocalDateTime.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        };
    }

    @Bean
    public Converter<String, LocalDate> stringLocalDateConverter() {
        return new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(String s) {
                if(StringUtils.isEmpty(s)) {
                    return null;
                }
                return LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
        };
    }

    @Bean
    public Converter<String, LocalTime> stringLocalTimeConverter() {
        return new Converter<String, LocalTime>() {
            @Override
            public LocalTime convert(String s) {
                if(StringUtils.isEmpty(s)) {
                    return null;
                }
                return LocalTime.parse(s, DateTimeFormatter.ofPattern("HH:mm:ss"));
            }
        };
    }

}
