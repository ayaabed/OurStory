package org.tsofen.ourstory;

import android.net.Uri;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class FirebaseImageWrapper {
    FirebaseStorage storage;
    StorageReference storageReference, ref;

    public FirebaseImageWrapper(String folder) {
        super();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        ref = storageReference.child(folder + "/");
    }

    public FirebaseImageWrapper() {
        super();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        ref = storageReference.child("images/");
    }

    public UploadTask uploadImg(Uri path) {
        return ref.child(UUID.randomUUID().toString()).putFile(path);
    }

    public void removeImg(String path) {
        // TODO: Right now we don't do that.
    }
}
