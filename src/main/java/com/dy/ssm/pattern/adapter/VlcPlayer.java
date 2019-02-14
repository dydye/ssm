package com.dy.ssm.pattern.adapter;

/**
 * @author daiyun
 * @date 2018-6-30
 */
public class VlcPlayer implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println(fileName + " playVlc");
    }

    @Override
    public void playMp4(String fileName) {

    }
}
