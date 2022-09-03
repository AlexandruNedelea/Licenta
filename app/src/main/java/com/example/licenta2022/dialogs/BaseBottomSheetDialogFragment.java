package com.example.licenta2022.dialogs;

import android.app.Dialog;
import android.view.Window;

import com.example.licenta2022.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BaseBottomSheetDialogFragment extends BottomSheetDialogFragment {
    private Dialog progressDialog;

    public void initProgressDialog() {
        progressDialog = new Dialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
    }

    public void showProgressDialog() {
        progressDialog.show();
    }

    public void dismissProgressDialog() {
        progressDialog.dismiss();
    }
}
