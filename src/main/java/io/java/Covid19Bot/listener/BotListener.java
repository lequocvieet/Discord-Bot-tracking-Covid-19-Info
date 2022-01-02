package io.java.Covid19Bot.listener;

import io.java.Covid19Bot.entity.Country;
import io.java.Covid19Bot.entity.StatisticsResponse;
import io.java.Covid19Bot.service.StatisticsService;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.text.SimpleDateFormat;


@Component
public class BotListener extends ListenerAdapter {

    @Autowired
    private StatisticsService statisticsService;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {     //Message in discord -> Console
        if (event.isFromType(ChannelType.PRIVATE)) {
            System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(),
                    event.getMessage().getContentDisplay());
        } else {
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(),
                    event.getTextChannel().getName(), event.getMember().getEffectiveName(),
                    event.getMessage().getContentDisplay());
        }

        String content = event.getMessage().getContentDisplay();
        if (content.contains("!help")) {
            help(event);
        } else if (content.contains("!statistics")) {
            statistics(event);
        }
    }

    private void help(MessageReceivedEvent event) {  //Test
        MessageChannel channel = event.getChannel();
        long time = System.currentTimeMillis();
        channel.sendMessage("Pong!") /* => RestAction<Message> */
                .queue(response /* => Message */ -> {
                    response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue();
                });
    }

    private void statistics(MessageReceivedEvent event) {    //!statistics + Tên Nước
        String message = event.getMessage().getContentDisplay();
        String array[] = message.split("\\s+");
        System.out.println(array[1]);
        String country = array[1];

        MessageChannel channel = event.getChannel();
        StatisticsResponse statistic = statisticsService.getStatisticByCountryName(country);
        Country response = statistic.getResponse().get(0);
        String code =statisticsService.getCodeFlagByName(response.getCountry());
        SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        EmbedBuilder embed=new EmbedBuilder();
        embed.setTitle("Covid 19 info for "+response.getCountry());
        embed.setColor(Color.blue);
        embed.addField("Cases", "New cases: "+response.getCases().getNewCases()
                                     +"\nActive cases: " +response.getCases().getActive()
                                     +"\nCritical cases: " +response.getCases().getCritical()
                                     + "\nRecovered: "+response.getCases().getRecovered()
                                     + "\nTotal cases: "+response.getCases().getTotal(),true);
        embed.addField("Deaths","New deaths: "+response.getDeaths().getNewDeath()+
                                "\nTotal deaths: "+response.getDeaths().getTotal(),true);
        embed.setImage("https://flagcdn.com/w320/"+code+".jpg");
        formatter.format(response.getDay());
        embed.setFooter(formatter+"Request made by Viet vs Chung");
        channel.sendMessage(embed.build()).queue();
    }
}
