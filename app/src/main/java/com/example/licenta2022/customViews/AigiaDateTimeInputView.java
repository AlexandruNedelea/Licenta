package com.example.licenta2022.customViews;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.example.licenta2022.R;
import com.example.licenta2022.helpers.AppExecutors;
import com.example.licenta2022.helpers.DateTimeHelper;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.TextStyle;
import java.util.Locale;

public class AigiaDateTimeInputView extends RelativeLayout {
    public interface OnDateChangedListener {
        void dateOrTimeChanged();
    }

    private AppCompatTextView timeTv;
    private AppCompatTextView dayTv;
    private AppCompatTextView dateTv;
    private AppCompatTextView primaryTitleTv;
    private AppCompatTextView secondaryTitleTv;
    private AppCompatImageView primaryIv;
    private AppCompatImageView secondaryIv;
    private RelativeLayout containerRl;
    private View separatorView;
    private Dialog progressDialog;
    private LocalDate date;
    private LocalTime time;
    private CalendarConstraints.DateValidator dateValidator;
    private OnDateChangedListener onDateChanged;
    private OnDateChangedListener onTimeChanged;
    private Context activityContext;

    public AigiaDateTimeInputView(Context context) {
        super(context);
        init();
    }

    public AigiaDateTimeInputView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        setValuesFromAttrs(attrs);
    }

    public AigiaDateTimeInputView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        setValuesFromAttrs(attrs);
    }

    public void setActivityContext(FragmentActivity activityContext) {
        this.activityContext = activityContext;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDateTime(LocalDateTime date) {
        setDate(date.toLocalDate());
        setTime(date.toLocalTime());
    }

    public void setDate(LocalDate date) {
        this.date = date;
        setDateStrings(date);
        if (onDateChanged != null) {
            onDateChanged.dateOrTimeChanged();
        }
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
        timeTv.setText(DateTimeHelper.getInstance().timeToString(time));
        if (onTimeChanged != null) {
            onTimeChanged.dateOrTimeChanged();
        }
    }

    public void setOnDateChanged(OnDateChangedListener onDateChanged) {
        this.onDateChanged = onDateChanged;
    }

    public void setOnTimeChanged(OnDateChangedListener onTimeChanged) {
        this.onTimeChanged = onTimeChanged;
    }

    public void setDateValidator(CalendarConstraints.DateValidator dateValidator) {
        this.dateValidator = dateValidator;
    }

    public String getFullSelectedDate() {
        return DateTimeHelper.getInstance().toServerFormat(date, time);
    }

    public void setPrimaryImage(Drawable drawable) {
        Glide.with(primaryIv.getContext())
                .load(drawable)
                .into(primaryIv);
    }

    public void setSecondaryImage(Drawable drawable) {
        Glide.with(secondaryIv.getContext())
                .load(drawable)
                .into(secondaryIv);
    }

    private void init() {
        inflate(getContext(), R.layout.aigia_date_time_input_view, this);
        initView();
        setCurrentDate();
        setClickListeners();
        initProgressDialog();
    }

    private void setClickListeners() {
        dayTv.setOnClickListener(view -> AppExecutors.getInstance().mainThread().execute(this::showDatePicker));
        dateTv.setOnClickListener(view -> AppExecutors.getInstance().mainThread().execute(this::showDatePicker));
        timeTv.setOnClickListener(view -> AppExecutors.getInstance().mainThread().execute(() -> {
            showProgressDialog();
            MaterialTimePicker materialTimePicker = getTimePicker(time);
            materialTimePicker.addOnPositiveButtonClickListener(view1 -> {
                setTime(LocalTime.of(materialTimePicker.getHour(), materialTimePicker.getMinute()));
                dismissProgressDialog();
            });

            if (getContext() instanceof AppCompatActivity) {
                materialTimePicker.show(((AppCompatActivity) getContext()).getSupportFragmentManager(), "timePickerFragment");
            } else if (activityContext != null) {
                materialTimePicker.show(((FragmentActivity) activityContext).getSupportFragmentManager(), "timePickerFragment");
            } else {
                dismissProgressDialog();
            }

            materialTimePicker.addOnCancelListener(dialogInterface -> dismissProgressDialog());
            materialTimePicker.addOnDismissListener(dialogInterface -> dismissProgressDialog());
            materialTimePicker.addOnNegativeButtonClickListener(dialogInterface -> dismissProgressDialog());
        }));
    }

    private MaterialTimePicker getTimePicker(LocalTime localTime) {
        return new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(localTime.getHour())
                .setMinute(localTime.getMinute())
                .build();
    }

    private void showDatePicker() {
        showProgressDialog();
        MaterialDatePicker.Builder<Long> materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTitleText("Select date");
        materialDateBuilder.setSelection(date.atStartOfDay().atZone(ZoneOffset.UTC).toInstant().toEpochMilli());

        if (dateValidator != null) {
            CalendarConstraints.Builder constraintsBuilder = new CalendarConstraints.Builder();
            constraintsBuilder.setValidator(dateValidator);
            materialDateBuilder.setCalendarConstraints(constraintsBuilder.build());
        }

        MaterialDatePicker<Long> materialDatePicker = materialDateBuilder.build();

        if (getContext() instanceof AppCompatActivity) {
            materialDatePicker.show(((AppCompatActivity) getContext()).getSupportFragmentManager(), "datePickerFragment");
        }  else if (activityContext != null) {
            materialDatePicker.show(((FragmentActivity) activityContext).getSupportFragmentManager(), "datePickerFragment");
        } else {
            dismissProgressDialog();
        }

        materialDatePicker.addOnPositiveButtonClickListener(selection -> {
            LocalDate selectedDate = Instant.ofEpochMilli(selection).atZone(ZoneOffset.UTC).toLocalDate();
            setDate(selectedDate);
            dismissProgressDialog();
        });

        materialDatePicker.addOnCancelListener(dialogInterface -> dismissProgressDialog());
        materialDatePicker.addOnDismissListener(dialogInterface -> dismissProgressDialog());
        materialDatePicker.addOnNegativeButtonClickListener(dialogInterface -> dismissProgressDialog());
    }

    private void initProgressDialog() {
        progressDialog = new Dialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
    }

    private void dismissProgressDialog() {
        progressDialog.dismiss();
    }

    private void showProgressDialog() {
        progressDialog.show();
    }

    private void initView() {
        timeTv = findViewById(R.id.tv_date_time_input_time);
        dateTv = findViewById(R.id.tv_date_time_input_date);
        dayTv = findViewById(R.id.tv_date_time_input_day);
        primaryTitleTv = findViewById(R.id.tv_date_time_input_date_text);
        secondaryTitleTv = findViewById(R.id.tv_date_time_input_time_text);
        containerRl = findViewById(R.id.rl_date_time_input_container);
        primaryIv = findViewById(R.id.iv_date_time_primary);
        secondaryIv = findViewById(R.id.iv_date_time_secondary);
        separatorView = findViewById(R.id.v_date_time_input_center_view);
    }

    private void setValuesFromAttrs(AttributeSet attrs) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs, R.styleable.DateTimeInputView, 0, 0);

        try {
            String primaryTitleText = a.getString(R.styleable.DateTimeInputView_dateTimeInputPrimaryTitle);
            if (primaryTitleText != null && !primaryTitleText.isEmpty()) {
                primaryTitleTv.setText(primaryTitleText);
            }
            String secondaryTitleText = a.getString(R.styleable.DateTimeInputView_dateTimeInputSecondaryTitle);
            if (secondaryTitleText != null && !secondaryTitleText.isEmpty()) {
                secondaryTitleTv.setText(secondaryTitleText);
            }
        } finally {
            a.recycle();
        }
    }

    private void setCurrentDate() {
        setDate(LocalDate.now());
        setTime(LocalTime.now());
    }

    private void setDateStrings(LocalDate date) {
        dayTv.setText(getDay(date));
        dateTv.setText(getMonthAndYear(date));
    }

    private String getDay(LocalDate localDate) {
        if (localDate == null) {
            return "";
        }
        return String.valueOf(localDate.getDayOfMonth());
    }

    private String getMonthAndYear(LocalDate localDate) {
        if (localDate == null) {
            return "";
        }

        return localDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.UK) + "\n" + localDate.getYear();
    }
}
