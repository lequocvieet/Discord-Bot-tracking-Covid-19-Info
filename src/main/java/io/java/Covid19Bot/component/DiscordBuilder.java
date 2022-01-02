package io.java.Covid19Bot.component;

import io.java.Covid19Bot.listener.BotListener;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;

@Component
public class DiscordBuilder {

    @Value("${token}")
    private String botToken;

    @Autowired
    private BotListener botListener;

    @PostConstruct
    public void buildDiscordBot() throws LoginException {
        JDA jda = JDABuilder.createDefault(botToken)
                .addEventListeners(botListener)
                .setActivity(Activity.playing("Vieet & Chung")).build();//initialized by create a JDA instance


    }
}
