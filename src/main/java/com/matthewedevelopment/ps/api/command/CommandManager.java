package com.matthewedevelopment.ps.api.command;

/**
 * Created by Matthew E on 4/1/2017.
 */
public class CommandManager {

    private static CommandManager instance;

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }

    public CommandManager() {
        instance = this;
    }

    public void registerCommand(BaseCommand baseCommand) {
        baseCommand.register(baseCommand);
    }
}
