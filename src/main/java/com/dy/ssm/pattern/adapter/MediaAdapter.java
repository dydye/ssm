package com.dy.ssm.pattern.adapter;

/**
 * @author daiyun
 * @date 2018-6-30
 */
public class MediaAdapter implements MediaPlayer {


    AdvanceMediaPlayer advanceMediaPlayer;

    public MediaAdapter(String audioType){

        if (audioType.equalsIgnoreCase("vlc")){
            advanceMediaPlayer =  new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")){
            advanceMediaPlayer = new Mp4Player();
        }

    }

    @Override
    public void play(String audioType, String fileName) {

        if (audioType.equalsIgnoreCase("vlc")){
            advanceMediaPlayer.playVlc("vlc");
        } else if (audioType.equalsIgnoreCase("mp4")){
            advanceMediaPlayer.playMp4("mp4");
        }
    }
}
