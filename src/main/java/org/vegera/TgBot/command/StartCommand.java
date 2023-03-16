package org.vegera.TgBot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.vegera.TgBot.service.SendBotMessageService;

public class StartCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    public final static String START_MESSAGE = "Hello from custom TgBot)";
    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
