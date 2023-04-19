package egydio.camila.applista.activity;

import static egydio.camila.applista.R.id.fabAddNewItem;
import static egydio.camila.applista.R.id.rvItens;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import egydio.camila.applista.R;
import egydio.camila.applista.adapter.MyAdapter;
import egydio.camila.applista.model.MyItem;
import egydio.camila.applista.model.Util;

public class MainActivity extends AppCompatActivity {

    static int NEW_ITEM_REQUEST =1;
    List<MyItem> itens = new ArrayList<>();
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fabAddItem = findViewById(fabAddNewItem);
        // ouvidor de clique
        fabAddItem.setOnClickListener((new View.OnClickListener() {
            @Override

            // intent de navegação para new activity e retorna os dados no request
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NewItemActivity.class);
                startActivityForResult(i,NEW_ITEM_REQUEST);
            }
        }));

        RecyclerView rvItens = findViewById(R.id.rvItens);

        // criando myAdapter e setando no recycleView
        myAdapter = new MyAdapter(this,itens);
        rvItens.setAdapter(myAdapter);

        // mantem o padrao de tamanho dos itens
        rvItens.setHasFixedSize(true);

        // gerenciador de layout para mostrar a lista em sequencia
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvItens.setLayoutManager(layoutManager);

        // separar os itens da lista
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvItens.getContext(),DividerItemDecoration.VERTICAL);
        rvItens.addItemDecoration(dividerItemDecoration);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // verificação de retorno
        if (requestCode == NEW_ITEM_REQUEST){
            if (resultCode == Activity.RESULT_OK){
                MyItem myItem = new MyItem();

                // dados retornados por newItemActiviy e guarda em myItem
                myItem.title = data.getStringExtra("title");
                myItem.description = data.getStringExtra("description");
                Uri selectedPhotoURI = data.getData();

                // carrega a imagem e guarda uma cópia no Bitmap
                try {
                    Bitmap photo = Util.getBitmap(MainActivity.this, selectedPhotoURI, 100,100);
                    myItem.photo = photo;
                }

                //guarda o Bitmap dentro de um objeto do MyItem
                catch (FileNotFoundException e){
                    e.printStackTrace();
                }

                // adiciona na lista
                itens.add(myItem);

                // notifica o adapter para mostrar o novo item no RecicleView
                myAdapter.notifyItemInserted(itens.size()-1);

            }
        }
    }
}