package com.example.test1;

import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    //recycler view
    private RecyclerView recyclerView;
    private static MainActivity inst;
    ArrayList<SmsModel> smsModel=new ArrayList<>();
    ArrayAdapter adapter=new ArrayAdapter(this);
    public   String messageContent;
    public   String messageSender;
    private static int iD;
    public static MainActivity instance() {
        return inst;
    }
    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.smsRecycler);
        if(ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.READ_SMS") == PackageManager.PERMISSION_GRANTED) {


            refreshSmsInbox();
        }else {
            // Todo : Then Set Permission
            final int REQUEST_CODE_ASK_PERMISSIONS = 123;
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{"android.permission.READ_SMS"}, REQUEST_CODE_ASK_PERMISSIONS);
        }
        }

    private void show() {

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            messageContent = extras.getString("msgContent");
            messageSender = extras.getString("sender");
            Toast.makeText(this, "before message", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, messageContent, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Empty message", Toast.LENGTH_SHORT).show();
        }


        int Id= adapter.getItemCount();
        if(Id>=0){

            smsModel.add(new SmsModel(Id,messageSender,messageContent,"8:20",messageSender));
            adapter.setSmsModel(smsModel);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            Toast.makeText(this, "Show ", Toast.LENGTH_SHORT).show();

        }



    }

    public void refreshSmsInbox() {

        ContentResolver contentResolver = getContentResolver();
        Cursor smsInboxCursor = contentResolver.query(Uri.parse("content://sms/inbox"), null, null, null, null);
        int indexBody = smsInboxCursor.getColumnIndex("body");
        int indexAddress = smsInboxCursor.getColumnIndex("address");
        if (indexBody < 0 || !smsInboxCursor.moveToFirst()) return;
        smsModel.clear();
        Toast.makeText(this, "refresh", Toast.LENGTH_SHORT).show();
        do {
            String str = "SMS From: " + smsInboxCursor.getString(indexAddress) +
                    "\n" + smsInboxCursor.getString(indexBody) + "\n";
            show();
        } while (smsInboxCursor.moveToNext());
        Toast.makeText(this, "Refresh inbox", Toast.LENGTH_SHORT).show();
    }

    public void updateList(final String msgs) {
//        adapter.setSmsModel(new ArrayList(Collections.singleton(msgs)));
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


}