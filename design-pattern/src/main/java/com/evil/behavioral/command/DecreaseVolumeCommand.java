package com.evil.behavioral.command;

/**
 * DecreaseVolumeCommand
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-03
 */
public class DecreaseVolumeCommand implements Command {
    private Television television;

    public DecreaseVolumeCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.decreaseVolume();
    }
}
