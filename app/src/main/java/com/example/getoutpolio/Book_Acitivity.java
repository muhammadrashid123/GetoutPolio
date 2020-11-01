package com.example.getoutpolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Book_Acitivity extends AppCompatActivity {
   private TextView textTitle,textDescription,textCategory;
   private ImageView imge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book__acitivity);

        textTitle=(TextView) findViewById(R.id.textName_title_id);
        textCategory=(TextView) findViewById(R.id.Category_id);
        textDescription=(TextView) findViewById(R.id.des_id);
        imge=(ImageView) findViewById(R.id.book_imgee_id);
        Intent intent=getIntent();
        String Title=intent.getStringExtra("Title");
        String Discription=intent.getStringExtra("Description");
        int image=intent.getExtras().getInt("Thembail");



        textTitle.setText(Title);
        textDescription.setText(Discription);
        imge.setImageResource(image);
    }
}
