package com.example.lastversion;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lastversion.R;

import java.util.Calendar;


public class editprofil extends AppCompatActivity {

    //var
    private static final String TAG = "editprofil";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    ImageView img;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprofil);
        //CalenderDisplay

        mDisplayDate =  findViewById(R.id.birthDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        editprofil.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth
                        , mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mDisplayDate.getApplicationWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);


            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: date" + year + "/" + month + "/" + day);
                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);

            }
        };

        img = (ImageView) findViewById(R.id.select);
        img.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
photo(v);
            }
        });
    }


    public void photo(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        intent.putExtra("crop","true");
        intent.putExtra("aspacetX",1);
        intent.putExtra("aspacetY",1);

        intent.putExtra("outputX",200);
        intent.putExtra("outputY",200);
        intent.putExtra("return-data",true);

        startActivityForResult(intent, 100);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
          //  Uri uri = data.getData();
            //img.setImageURI(uri);
            img.setImageBitmap((Bitmap)data.getExtras().get("data"));
        }
    }

}

