package egydio.camila.applista.activity;

import static egydio.camila.applista.R.id.fabAddNewItem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import egydio.camila.applista.R;

public class MainActivity extends AppCompatActivity {

    static int NEW_ITEM_REQUEST =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fabAddItem = findViewById(fabAddNewItem);
        fabAddItem.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NewItemActivity.class);
                startActivityForResult(i,NEW_ITEM_REQUEST);
            }
        }));

    }
}