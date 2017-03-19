package com.hfad.messenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onSendMessage(View view)
    {
        EditText messaggio =  (EditText) findViewById(R.id.message);
        String messageText = messaggio.getText().toString();
       // Intent intent = new Intent(this,ReceiveMessageActivity.class);
        //intent.putExtra(Constant.MESSAGE,messaggioTesto);
        String chooserTitle = getString(R.string.chooser);


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,messageText);
        Intent chosenIntent = Intent.createChooser(intent,chooserTitle);


        startActivity(chosenIntent);
    }
}
