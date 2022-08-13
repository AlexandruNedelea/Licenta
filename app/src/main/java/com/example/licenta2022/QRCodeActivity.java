package com.example.licenta2022;

import static androidx.camera.core.CameraX.getContext;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.res.ResourcesCompat;

import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.databinding.ActivityQrcodeBinding;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class QRCodeActivity extends BaseActivity<ActivityQrcodeBinding> {
    private static final int PERMISSION_REQUEST_CAMERA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding= ActivityQrcodeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
//        requestCamera();

        setQrImage();
    }

    private void requestCamera() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            startCamera();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ActivityCompat.requestPermissions(QRCodeActivity.this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
            }
        }
    }

    private void startCamera() {
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CAMERA) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startCamera();
            } else {
                Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void setQrImage() {
        var imageSize = Resources.getSystem().getDisplayMetrics().widthPixels - (int)(2 *
                getResources().getDimension(R.dimen.default_margin));
        dataBinding.ivQrCode.setImageBitmap(generateQrCode("continut cod qr", imageSize));
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
}