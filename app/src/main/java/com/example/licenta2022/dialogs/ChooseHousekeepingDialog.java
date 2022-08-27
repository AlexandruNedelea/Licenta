package com.example.licenta2022.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.licenta2022.FirebaseHelper;
import com.example.licenta2022.R;
import com.example.licenta2022.databinding.DialogChooseHousekeepingBinding;
import com.example.licenta2022.helpers.DataStorageHelper;
import com.example.licenta2022.helpers.ViewUtils;
import com.example.licenta2022.models.network.HouseKeepingModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class ChooseHousekeepingDialog extends BaseBottomSheetDialogFragment {
    private DialogChooseHousekeepingBinding dataBinding;

    public ChooseHousekeepingDialog() {
    }

    public static ChooseHousekeepingDialog newInstance() {
        return new ChooseHousekeepingDialog();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        var dialog = new BottomSheetDialog(getActivity(), R.style.TransparentContainerBottomSheetDialogTheme);
        dialog.setOnShowListener(dialogInterface -> {
            FrameLayout container = dialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
            BottomSheetBehavior.from(container).setState(BottomSheetBehavior.STATE_EXPANDED);
        });
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = DialogChooseHousekeepingBinding.inflate(getLayoutInflater());
        return dataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        dataBinding.dtvAddLabResultsDateTimeInput.setActivityContext(requireActivity());
        ViewUtils.getInstance().setPickerMinDateToday(dataBinding.dtvAddLabResultsDateTimeInput);
        setListeners();
    }

    private void setListeners() {
        dataBinding.btnDialogChooseHousekeepingSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRequireHousekeeping();
            }
        });
    }

    private void onRequireHousekeeping() {
        var selectedDate = dataBinding.dtvAddLabResultsDateTimeInput.getFullSelectedDate();
        var housekeeping = new HouseKeepingModel(DataStorageHelper.getInstance().getRoomNumber(),selectedDate);

        FirebaseHelper.getInstance().getHousekeepingDatabaseReference()
                .child(housekeeping.getRoomNumber())
                .push()
                .setValue(housekeeping)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        dismiss();
                    }
                });
    }
}