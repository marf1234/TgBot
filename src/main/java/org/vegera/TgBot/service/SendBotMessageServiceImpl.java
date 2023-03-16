package org.vegera.TgBot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.vegera.TgBot.bot.TgBot;

public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final TgBot tgbot;

    @Autowired
    public SendBotMessageServiceImpl(TgBot tgbot) {
        this.tgbot = tgbot;
    }
    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            tgbot.execute(sendMessage);
        } catch (TelegramApiException e) {
            //todo add logging to the project.
            e.printStackTrace();
        }
    }
}
