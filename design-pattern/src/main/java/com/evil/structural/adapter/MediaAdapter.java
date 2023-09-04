package com.evil.structural.adapter;

// 适配器类
class MediaAdapter implements MediaPlayer {
    private OldMediaPlayer oldMediaPlayer;

    public MediaAdapter(OldMediaPlayer oldMediaPlayer) {
        this.oldMediaPlayer = oldMediaPlayer;
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            oldMediaPlayer.playMp3(fileName);
        } else {
            System.out.println("不支持的音频类型: " + audioType);
        }
    }
}
