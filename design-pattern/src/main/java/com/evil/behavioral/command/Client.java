package com.evil.behavioral.command;

public class Client {
    public static void main(String[] args) {
        Television television = new Television();
        RemoteControl remoteControl = new RemoteControl();

        Command turnOnCommand = new TurnOnCommand(television);
        Command turnOffCommand = new TurnOffCommand(television);
        Command increaseVolumeCommand = new IncreaseVolumeCommand(television);
        Command decreaseVolumeCommand = new DecreaseVolumeCommand(television);

        remoteControl.setCommand(turnOnCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(increaseVolumeCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(decreaseVolumeCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(turnOffCommand);
        remoteControl.pressButton();
    }
}
