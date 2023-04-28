package egydio.camila.applista.model;

import android.net.Uri;
import android.view.View;

import androidx.lifecycle.ViewModel;

public class NewItemActivityViewModel extends ViewModel {
    // guarda o endereço da foto
    Uri selectPhotoLocation =null;

    // obtem os itens da lista
    public Uri getSelectPhotoLocation(){
        return selectPhotoLocation;
    }

    // seta o endereço da URI dentro de ViewModel
    public void setSelectPhotoLocation(Uri selectPhotoLocation) {
        this.selectPhotoLocation = selectPhotoLocation;
    }
}
