package com.evil.command;

/**
 * IncreaseVolumeCommand
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-03
 */
public class IncreaseVolumeCommand implements Command {
    private Television television;

    public IncreaseVolumeCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.increaseVolume();
    }
}
