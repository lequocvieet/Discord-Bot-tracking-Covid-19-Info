package io.java.Covid19Bot.listener;

import io.java.Covid19Bot.entity.Country;
import io.java.Covid19Bot.entity.StatisticsResponse;
import io.java.Covid19Bot.service.StatisticsService;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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
        channel.sendMessageFormat("Country: [" + response.getCountry() + "] \n"
                        + "Continent: " + response.getContinent() + " \n"
                        + "Population: " + response.getPopulation() + " \n"
                        + response.getCases().toString() + " \n"
                        + response.getDeaths().toString() + " \n"
                        + response.getTests().toString() + " \n"
                        + "Day: " + response.getDay() + " \n"
                        + "Time: " + response.getTime() + " \n")
                .queue();

    }
}
