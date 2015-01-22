package edu.adu.bsse.biespana.audioplaybackservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

/**
 * Created by biespana on 1/22/15.
 */
public class PlaybackService extends Service{
    private MediaPlayer player;
    private Intent playIntent;
    private String command;

    @Override
    public void onCreate(){
        player = MediaPlayer.create(getApplicationContext(),R.raw.audiofile);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        command = intent.getStringExtra("COMMAND");
        if (command.equals("START")){
            player.start();
        }else if (command.equals("PAUSE")){
            player.pause();
        }else if (command.equals("RESUME")){
            player.start();
        }

        return 0;
    }

    @Override
    public IBinder onBind(Intent intent){
        return null;
    }

    @Override
    public void onDestroy(){
        player.release();
    }

}
