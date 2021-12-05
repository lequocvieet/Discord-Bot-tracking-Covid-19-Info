package io.java.Covid19Bot.component;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Build by Discord4J
@Configuration
public class BotConfiguration {
//
//    @Value("${token}")
//    private String token;
//
//    @Bean
//    public <T extends Event> GatewayDiscordClient gatewayDiscordClient() {
//        return DiscordClientBuilder.create(token)
//                .build()
//                .login()
//                .block();
//    }
}
