package com.newbilius.music_background_control;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.SystemClock;
import android.view.KeyEvent;

public class MusicBackgroundControlWrapper {
    public static final String SERVICECMD = "com.android.music.musicservicecommand";

    public static void KeyPressDownAndUp(int key,Context context){ //всегда вызывает только один из плееров, принципа выбора не понял. блин.
        long eventtime = SystemClock.uptimeMillis() - 1;

        Intent downIntent = new Intent(Intent.ACTION_MEDIA_BUTTON, null);
        KeyEvent downEvent = new KeyEvent(eventtime, eventtime,
                KeyEvent.ACTION_DOWN, key, 0);
        downIntent.putExtra(Intent.EXTRA_KEY_EVENT, downEvent);
        context.sendOrderedBroadcast(downIntent, null);

        eventtime++;
        Intent upIntent = new Intent(Intent.ACTION_MEDIA_BUTTON, null);
        KeyEvent upEvent = new KeyEvent(eventtime, eventtime,
                KeyEvent.ACTION_UP, key, 0);
        upIntent.putExtra(Intent.EXTRA_KEY_EVENT, upEvent);
        context.sendOrderedBroadcast(upIntent, null);
    }

    public static void SendCommand(String key,Context context){//todo нормально работает только со станлартным плеером
            Intent i = new Intent(SERVICECMD);
            i.putExtra("command" , key );
            context.sendBroadcast(i);
    }

    public static void TogglePausePlay(Context context){
        KeyPressDownAndUp(KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE,context);
        //SendCommand("togglepause",context);
    }

    public static void Next(Context context){
        KeyPressDownAndUp(KeyEvent.KEYCODE_MEDIA_NEXT, context);
        //SendCommand("next",context);
    }

    public static void Prev(Context context){
        KeyPressDownAndUp(KeyEvent.KEYCODE_MEDIA_PREVIOUS, context);
        //SendCommand("previous",context);
    }
}