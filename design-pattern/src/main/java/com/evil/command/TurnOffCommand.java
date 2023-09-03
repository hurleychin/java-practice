package com.evil.command;

/**
 * TurnOffCommand
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-03
 */
public class TurnOffCommand implements Command {
    private Television television;

    public TurnOffCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.turnOff();
    }
}
