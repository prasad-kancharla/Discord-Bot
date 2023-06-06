package com.prasad;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScoldingBot extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        String message = event.getMessage().getContentRaw();
        if (containsInappropriateLanguage(message)) {
            User user = event.getAuthor();
            sendScoldingMessage(user);
        }
    }

    private boolean containsInappropriateLanguage(String input) {
        String pattern = "(?i)kirat\\s(bhaiya|sir|baia|bhaaiyaaa)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        return matcher.find();
    }

    private void sendScoldingMessage(User user) {
        user.openPrivateChannel().queue(channel -> {
            String message = "You have been scolded for using inappropriate language.";
            channel.sendMessage(message).queue();
        });
        System.out.println("sent scolding message to user : " + user.getName());
    }
}
