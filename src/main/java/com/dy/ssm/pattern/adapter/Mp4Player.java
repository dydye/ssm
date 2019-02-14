package com.dy.ssm.pattern.adapter;

/**
 * @author daiyun
 * @date 2018-6-30
 */
public class Mp4Player implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println(fileName + " playMp4");
    }
}
