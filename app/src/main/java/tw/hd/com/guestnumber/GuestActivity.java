package tw.hd.com.guestnumber;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuestActivity extends AppCompatActivity {

    private static final String TAG = GuestActivity.class.getSimpleName();
    private EditText guestNum;
    private Button okbutton;
    private GNumber gNumber;
    private TextView showtext;
    private int sec;
    private Map<String, Integer> sounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        guestNum = findViewById(R.id.edit_g_Num);
        okbutton = findViewById(R.id.button_enter);
        gNumber = new GNumber();
        sec = gNumber.getY_guestNum();

//        List<MediaPlayer> sounds = new ArrayList<>();
        sounds = new HashMap();
        showtext = findViewById(R.id.textshow);

        for (Field field: R.raw.class.getFields()) {
            int resId = getResources().getIdentifier(field.getName(),"raw",getPackageName());
            sounds.put(field.getName(),resId);
            Log.d(TAG, "field  " + field.getName());
        }
        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int g_Nums = Integer.parseInt(guestNum.getText().toString());
                Log.d(TAG, "g_Nums:  "+g_Nums);
                Log.d(TAG, "sec:  "+sec);

                if (gNumber.ChickDouble(g_Nums)) {

                    String str = gNumber.isSame(g_Nums, sec);
                    showtext.setVisibility(View.VISIBLE);
                    showtext.setText(str);
                    if(str.equals("NO")){
                        MediaPlayer.create(GuestActivity.this, sounds.get("nanswer")).start();

                    }



                } else {
                    Toast toast = Toast.makeText(GuestActivity.this, "請輸入不重覆的數字", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                }


            }
        });

    }
}
