package com.example.icare;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1, btn2;
    EditText text1, text2, text3, text4, text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.updateNoRumahsakit);
        text2 = (EditText) findViewById(R.id.updateNamaRumahsakit);
        text3 = (EditText) findViewById(R.id.updateFasilitasRumahsakit);
        text4 = (EditText) findViewById(R.id.updateJenisRumahsakit;
        text5 = (EditText) findViewById(R.id.updateAlamatRumahsakit);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM datarumahsakit WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
        btn1 = (Button) findViewById(R.id.btnUpdate);
        btn2 = (Button) findViewById(R.id.btnBack);
        // daftarkan even onClick pada btnSimpan
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db =
                        dbHelper.getWritableDatabase();
                db.execSQL("UPDATE datarumahsakit SET nama='"+
                        text2.getText().toString() +"', fasilitas='" +
                        text3.getText().toString()+"', jenis='"+
                        text4.getText().toString() +"', alamat='" +
                        text5.getText().toString() + "' WHERE NO ='" +
                        text1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Update Success...", Toast.LENGTH_LONG).show();
                AdminActivity.data.RefreshList();
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_admin, menu);
        return true;
    }
}