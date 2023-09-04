package com.evil.structural.adapter;

public class Client {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaAdapter(new OldMediaPlayer());

        mediaPlayer.play("mp3", "song.mp3");
        mediaPlayer.play("mp4", "video.mp4");
    }
}
