package com.example.alibaba.stmcapturerobo;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button start;
    Button about;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button)findViewById(R.id.start);
        about = (Button)findViewById(R.id.about_aplication);
        exit = (Button)findViewById(R.id.exit);
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        OnClickButton();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public void onStop() {
        super.onStop();
    }


    protected void OnClickButton()
    {
        if (null != start) {
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkConnection()) {
                        Toast.makeText(getApplicationContext(), "Connection ON", Toast.LENGTH_LONG).show();
                        Intent intent;
                        intent = new Intent(getApplicationContext(), StartActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Connection OFF", Toast.LENGTH_LONG).show();
                        Intent intent;
                        intent = new Intent(getApplicationContext(), StartActivity.class);
                        startActivity(intent);

                    }

                }
            });
        }


        if (null != about) about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


            }
        });

        if (null != exit) exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }

    protected  boolean checkConnection()
    {
        boolean result = false;
        StartActivity startActivity = new StartActivity();
        if(startActivity.check_connection_bool) result=true;
        return result;

    }
}



