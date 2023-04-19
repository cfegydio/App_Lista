package egydio.camila.applista.model;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {
    // guarda os items da lista
    List<MyItem> itens = new ArrayList<>();

    // obtem a lista
    public List<MyItem> getItens() {
        return itens;
    }
}
