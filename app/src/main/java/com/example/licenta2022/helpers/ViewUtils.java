package com.example.licenta2022.helpers;

import android.content.Context;
import android.util.DisplayMetrics;

import com.example.licenta2022.customViews.AigiaDateTimeInputView;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.CompositeDateValidator;
import com.google.android.material.datepicker.DateValidatorPointBackward;
import com.google.android.material.datepicker.DateValidatorPointForward;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;

public class ViewUtils {
    private static ViewUtils instance = null;

    public static synchronized ViewUtils getInstance() {
        if (instance == null)
            instance = new ViewUtils();

        return instance;
    }

    public ViewUtils() {
    }

    public int convertDpToPixel(float dp, Context context) {
        return (int) (dp * context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public void setPickerMinDateToday(AigiaDateTimeInputView view) {
        ArrayList<CalendarConstraints.DateValidator> listValidators = new ArrayList<>();
        listValidators.add(DateValidatorPointForward.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant().toEpochMilli()));
        CalendarConstraints.DateValidator validators = CompositeDateValidator.allOf(listValidators);
        view.setDateValidator(validators);
    }
}
