package com.example.mongo.order;

import java.util.Collections;
import java.util.Optional;

import org.joda.time.DateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.mongodb.core.convert.CustomConversions;

@SpringBootApplication
public class OrderApplication {

 @SuppressWarnings("deprecation")
@Bean
 CustomConversions customConversions() {
  return new CustomConversions(
   Collections.singletonList(new LongToDateTimeConverter()));
 }

 @ReadingConverter
 public static class LongToDateTimeConverter implements
  Converter<Long, DateTime> {

  @Override
  public DateTime convert(Long source) {
   return Optional.ofNullable(source).map(DateTime::new).orElse(null);
  }
 }

 public static void main(String[] args) {
  SpringApplication.run(OrderApplication.class, args);
 }
 
}
