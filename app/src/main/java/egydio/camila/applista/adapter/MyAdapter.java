package egydio.camila.applista.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import egydio.camila.applista.R;
import egydio.camila.applista.activity.MainActivity;
import egydio.camila.applista.model.MyItem;

public class MyAdapter extends RecyclerView.Adapter {

    MainActivity mainActivity;
    List<MyItem> itens;

    public MyAdapter(MainActivity mainActivity, List<MyItem> itens){
        this.mainActivity = mainActivity;
        this.itens = itens;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // inflador usado para ler o layout / cria os elementos de interface guardando em um objeto View/ depois guardado em MyViewHolder)
        LayoutInflater inflater = LayoutInflater.from(mainActivity);
        View v = inflater.inflate(R.layout.item_list,parent,false);
        return new MyViewHolder(v);
    }

    @Override

    // método para preencher com os dados
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // item usado para preencher
        MyItem myItem = itens.get(position);

        // obtem o objeto guardado no holder
        View v = holder.itemView;

        // preenche a UI com os dados
        ImageView imvfoto = v.findViewById(R.id.imvPhoto);
        TextView tvTitle = v.findViewById(R.id.tvTitle);
        TextView tvdesc = v.findViewById(R.id.tvDesc);

        tvTitle.setText(myItem.title);
        imvfoto.setImageBitmap(myItem.photo);
        tvdesc.setText(myItem.description);

    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
