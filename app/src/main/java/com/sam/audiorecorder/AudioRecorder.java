package com.sam.audiorecorder;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.IBinder;
import android.telephony.TelephonyManager;


public class AudioRecorder extends Service {

    private MediaRecorder recorder ;
    Random random ;
    String RandomAudioFileName = "ABCDEFGHI123456789";


    @Override
    public void onCreate() {

        startRecording();

  }

    public void startRecording() {

        random = new Random();
        File folder = new File(Environment.getExternalStorageDirectory(), "/AudioRecorder");
        if (!folder.exists()) {
            folder.mkdirs();
        }
                try {
                    if (recorder == null) {
                        recorder = new MediaRecorder();
                        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        recorder.setOutputFile(folder.getAbsolutePath() +"/" + CreateRandomAudioFileName(3)+ ".amr");
                        recorder.prepare();
                        recorder.start();


                    }

                } catch (IllegalStateException ise) {

                } catch (IOException ioe) {
                }

    }

    public String CreateRandomAudioFileName(int string){
        StringBuilder stringBuilder = new StringBuilder( string );
        int i = 0 ;
        while(i < string ) {
            stringBuilder.append(RandomAudioFileName.
                    charAt(random.nextInt(RandomAudioFileName.length())));

            i++ ;
        }
        return stringBuilder.toString();
    }


    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }
}

