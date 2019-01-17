package tw.hd.com.guestnumber;
//TODO 這類別要來處理說數字字母

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Speak  extends AppCompatActivity {
    int soundSource;
    String soundName;
    Map<String , Integer> soundMap ;

    public Speak() {
        soundMap = new HashMap<>();
        for (Field field : R.raw.class.getFields()) {
            soundSource = getResources().getIdentifier(field.getName(),"raw",getPackageName());
            soundMap.put(field.getName(),soundSource);
        }
    }

public void speakWord(String word){
        switch (word){
            case "NO":
                MediaPlayer.create(this, soundMap.get(word)).start();
                break;
            case "2A":
                MediaPlayer.create(this, soundMap.get(word)).start();
                break;
                default:
//                    callsplit(word);
                    final char[] words = word.toCharArray();
                    for (int i = 0 ; i < words.length;i++){
                        MediaPlayer.create(this,soundMap.get(words[i])).setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                //todo 要在想好怎麼播完一個字在接著往下一個字播
//                                MediaPlayer.create(this,soundMap.get(words[i+1]));
                            }
                        });
                    }
        }

}

    private void callsplit(String word) {
        ArrayList<String> words = new ArrayList<>();
        char[] wordss = word.toCharArray();
    }
}
