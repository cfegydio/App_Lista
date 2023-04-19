package egydio.camila.applista.model;

import android.net.Uri;

public class NewItemActivityViewModel {
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
