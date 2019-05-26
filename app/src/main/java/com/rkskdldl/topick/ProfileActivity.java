package com.rkskdldl.topick;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
SharedPreferences prefs =getSharedPreferences("rkskdldl",MODE_PRIVATE);
EditText nickname;
Button register;
public static boolean first_open =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        if(first_open==false) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("nickname", "");
            editor.commit();
            first_open=true;
        }else {

        }
    }
void initView(){
        nickname=(EditText)findViewById(R.id.nickname);
        register =(Button)findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nickname.getText().length()>=4){
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("nickname", nickname.getText().toString());
                    editor.commit();
                }else {
                    Toast.makeText(getApplicationContext(),"아이디를 4글자 이상 해주세요",Toast.LENGTH_SHORT);
                }
            }
        });
    }

}
