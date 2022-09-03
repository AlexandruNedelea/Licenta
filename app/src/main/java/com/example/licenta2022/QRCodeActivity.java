package com.example.licenta2022;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.res.ResourcesCompat;

import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.databinding.ActivityQrcodeBinding;
import com.example.licenta2022.helpers.DataStorageHelper;
import com.example.licenta2022.helpers.ViewUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.android.BeepManager;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.Size;

public class QRCodeActivity extends BaseActivity<ActivityQrcodeBinding> implements BarcodeCallback {
    private static final int PERMISSION_REQUEST_CAMERA = 5235;

    private CaptureManager capture;
    private BeepManager beepManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding= ActivityQrcodeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);

        requestCamera();
        setQrImage();
        setupScannerView(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        capture.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        capture.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        capture.onDestroy();
    }

    private void setupScannerView(Bundle savedInstanceState){
        beepManager = new BeepManager(this);
        capture = new CaptureManager(this, dataBinding.zxingBarcodeScanner);

        capture.initializeFromIntent(getIntent(), savedInstanceState);
        capture.setShowMissingCameraPermissionDialog(true);
        capture.decode();

        var size = Resources.getSystem().getDisplayMetrics().widthPixels - (2 * ViewUtils.getInstance().convertDpToPixel(28f, this));
        dataBinding.zxingBarcodeScanner.getBarcodeView().setFramingRectSize(new Size(size, size));

        setSizeForView(size, dataBinding.vWithRoundedBorder);
        dataBinding.vWithRoundedBorder.setScanAreaSize(size);
        dataBinding.zxingBarcodeScanner.decodeSingle(this);
    }

    private void setSizeForView(int size, View view) {
        var scannerLp = view.getLayoutParams();
        scannerLp.height = size;
        scannerLp.width = size;
        view.setLayoutParams(scannerLp);
    }

    private void requestCamera() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
        } else {
            ActivityCompat.requestPermissions(QRCodeActivity.this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CAMERA) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void setQrImage() {
        var imageSize = Resources.getSystem().getDisplayMetrics().widthPixels - (int)(2 *
                getResources().getDimension(R.dimen.default_margin));
        dataBinding.ivQrCode.setImageBitmap(generateQrCode("2", imageSize));
    }


    private Bitmap generateQrCode(String Value, int size) {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(Value, BarcodeFormat.QR_CODE, size, size, null
            );
        } catch (IllegalArgumentException Illegalargumentexception) {
            return null;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
        int backgroundColor = ResourcesCompat.getColor(getResources(), R.color.white, null);
        int bitMatrixWidth = bitMatrix.getWidth();
        int bitMatrixHeight = bitMatrix.getHeight();
        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];
        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;
            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ?
                        Color.BLACK : backgroundColor;
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);
        bitmap.setPixels(pixels, 0, bitMatrixWidth, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }

    @Override
    public void barcodeResult(BarcodeResult result) {
        beepManager.playBeepSoundAndVibrate();
        var resultString = result.getResult().toString();
        if (!resultString.isEmpty()) {
            DataStorageHelper.getInstance().setRoomNumber(result.getResult().getText());
            startHotelActivity();
        }
    }

    private void startHotelActivity() {
        startActivity(new Intent(this, HotelActivity.class));
        finish();
    }
}