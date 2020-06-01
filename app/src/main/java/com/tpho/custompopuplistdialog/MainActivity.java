package com.tpho.custompopuplistdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent(this, ListItemActivity.class);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
                @Override
                    public void onClick(View v) {
                            startActivityForResult(intent, 1);
                    }
            });
    }
        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                if(requestCode == 1 && resultCode == Activity.RESULT_OK){
                        String itemCode = data.getStringExtra(ListItemActivity.RESULT_ITEMCODE);
                        Toast.makeText(this, "You selected item code: " + itemCode, Toast.LENGTH_LONG).show();
                }
        }

}
