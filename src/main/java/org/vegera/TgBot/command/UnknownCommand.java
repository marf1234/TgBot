package org.vegera.TgBot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.vegera.TgBot.service.SendBotMessageService;

public class UnknownCommand implements Command{

    public static final String UNKNOWN_MESSAGE = "Неизвестная команда, напишите /help для выдачи рабочих команд.";

    private final SendBotMessageService sendBotMessageService;

    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }


}