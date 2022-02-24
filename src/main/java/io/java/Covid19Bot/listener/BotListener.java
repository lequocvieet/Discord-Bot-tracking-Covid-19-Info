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
        EmbedBuilder embed = new EmbedBuilder();
        String message = event.getMessage().getContentDisplay();
        String array[] = message.split("\\s+");
        // System.out.println(array[1]);
        String country = array[1];

        MessageChannel channel = event.getChannel();
        long time = System.currentTimeMillis();
        StatisticsResponse statistic = statisticsService.getStatisticByCountryName(country);
        String code = statisticsService.getCodeFlagByName(country);
        if (code.length() > 7 || statistic == null) {
            embed.setImage("https://6dollarshirts.com/image/cache//data/designs/sorryyourewrong/sorryyourewrong-t-shirt-black-midnight-swatch-400x400.jpg");
            embed.setTitle(code);
            embed.setColor(Color.red);
            Long timeResponse = System.currentTimeMillis() - time;
            embed.setFooter("Request made by Viet vs Chung And received response after " + timeResponse + " ms");
            channel.sendMessage(embed.build()).queue();


        } else {
            embed.setImage("https://flagcdn.com/w320/" + code + ".jpg");
            Country response = statistic.getResponse().get(0);
            embed.setTitle("Covid 19 info for " + response.getCountry());
            embed.setColor(Color.GRAY);
            embed.addField("Cases", "New cases: " + response.getCases().getNewCases()
                    + "\nActive cases: " + response.getCases().getActive()
                    + "\nCritical cases: " + response.getCases().getCritical()
                    + "\nRecovered: " + response.getCases().getRecovered()
                    + "\nTotal cases: " + response.getCases().getTotal(), true);
            embed.addField("Deaths", "New deaths: " + response.getDeaths().getNewDeath() +
                    "\nTotal deaths: " + response.getDeaths().getTotal(), true);


            Long timeResponse = System.currentTimeMillis() - time;
            embed.setFooter("Request made by Viet vs Chung And received response after " + timeResponse + " ms");
            channel.sendMessage(embed.build()).queue();
        }
    }
}
