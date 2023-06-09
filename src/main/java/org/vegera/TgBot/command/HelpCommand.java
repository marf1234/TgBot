package org.vegera.TgBot.command;


import org.telegram.telegrambots.meta.api.objects.Update;
import org.vegera.TgBot.service.SendBotMessageService;

import static org.vegera.TgBot.command.CommandName.*;


/**
 * Help {@link Command}.
 */
public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("✨<b>Доcтупные команды</b>✨\n\n"

            + "<b>Начать\\закончить работу с ботом</b>\n" + "%s - начать работу со мной\n" + "%s - приостановить работу со мной\n\n" + "%s - получить помощь в работе со мной\n", START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}