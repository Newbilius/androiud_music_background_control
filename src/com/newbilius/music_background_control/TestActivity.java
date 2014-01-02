package com.newbilius.music_background_control;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

//Данные взяты отсюда: https://android.googlesource.com/platform/packages/apps/Music/+/master/src/com/android/music/MediaPlaybackService.java

public class TestActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button buttonTogglePause = (Button)findViewById(R.id.buttonTogglePause);
        Button buttonNext = (Button)findViewById(R.id.buttonNext);
        Button buttonPrev = (Button)findViewById(R.id.buttonPrev);

        buttonTogglePause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicBackgroundControlWrapper.TogglePausePlay(v.getContext());
            }
        });
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicBackgroundControlWrapper.Next(v.getContext());
            }
        });
        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicBackgroundControlWrapper.Prev(v.getContext());
            }
        });
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent keyevent) {
        Log.d("hh42 Name ", keyevent.toString());
        return super.dispatchKeyEvent(keyevent);
    }
}
/*
01-02 19:50:02.170    4340-4340/com.newbilius.music_background_control D/hh42 Name﹕ KeyEvent { action=ACTION_DOWN, keyCode=KEYCODE_MEDIA_PLAY, scanCode=200, metaState=0, flags=0x8, repeatCount=0, eventTime=12561895, downTime=12561895, deviceId=8, source=0x101 }
01-02 19:50:02.180    4340-4340/com.newbilius.music_background_control D/hh42 Name﹕ KeyEvent { action=ACTION_UP, keyCode=KEYCODE_MEDIA_PLAY, scanCode=200, metaState=0, flags=0x8, repeatCount=0, eventTime=12561901, downTime=12561895, deviceId=8, source=0x101 }

01-02 19:50:05.130    4340-4340/com.newbilius.music_background_control D/hh42 Name﹕ KeyEvent { action=ACTION_DOWN, keyCode=KEYCODE_MEDIA_PAUSE, scanCode=201, metaState=0, flags=0x8, repeatCount=0, eventTime=12564844, downTime=12564844, deviceId=8, source=0x101 }
01-02 19:50:05.170    4340-4340/com.newbilius.music_background_control D/hh42 Name﹕ KeyEvent { action=ACTION_UP, keyCode=KEYCODE_MEDIA_PAUSE, scanCode=201, metaState=0, flags=0x8, repeatCount=0, eventTime=12564890, downTime=12564844, deviceId=8, source=0x101 }

01-02 19:50:30.710    4340-4340/com.newbilius.music_background_control D/hh42 Name﹕ KeyEvent { action=ACTION_DOWN, keyCode=KEYCODE_MEDIA_NEXT, scanCode=163, metaState=0, flags=0x8, repeatCount=0, eventTime=12590436, downTime=12590436, deviceId=8, source=0x101 }
01-02 19:50:30.720    4340-4340/com.newbilius.music_background_control D/hh42 Name﹕ KeyEvent { action=ACTION_UP, keyCode=KEYCODE_MEDIA_NEXT, scanCode=163, metaState=0, flags=0x8, repeatCount=0, eventTime=12590443, downTime=12590436, deviceId=8, source=0x101 }

01-02 19:50:33.370    4340-4340/com.newbilius.music_background_control D/hh42 Name﹕ KeyEvent { action=ACTION_DOWN, keyCode=KEYCODE_MEDIA_PREVIOUS, scanCode=165, metaState=0, flags=0x8, repeatCount=0, eventTime=12593086, downTime=12593086, deviceId=8, source=0x101 }
01-02 19:50:33.400    4340-4340/com.newbilius.music_background_control D/hh42 Name﹕ KeyEvent { action=ACTION_UP, keyCode=KEYCODE_MEDIA_PREVIOUS, scanCode=165, metaState=0, flags=0x8, repeatCount=0, eventTime=12593122, downTime=12593086, deviceId=8, source=0x101 }
 */