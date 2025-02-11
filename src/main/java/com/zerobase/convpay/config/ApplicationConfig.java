package com.zerobase.convpay.config;

import com.zerobase.convpay.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class ApplicationConfig {

    @Bean
    public ConveniencePayService conveniencePayService(){
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(moneyAdapter(), cardAdapter())
                ),
                discountInterface()
        );
    }

    @Bean
    public static CardAdapter cardAdapter() {
        return new CardAdapter();
    }

    @Bean
    public static MoneyAdapter moneyAdapter() {
        return new MoneyAdapter();
    }

    @Bean
    private static DiscountByConvenience discountInterface() {
        return new DiscountByConvenience();
    }

}
