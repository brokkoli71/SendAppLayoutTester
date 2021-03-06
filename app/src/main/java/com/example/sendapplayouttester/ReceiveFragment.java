package com.example.sendapplayouttester;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Dialog;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.qrcode.QRCodeWriter;

import net.glxn.qrgen.android.QRCode;

public class ReceiveFragment extends Fragment {
    ViewPager viewPager;
    Dialog qrDialog;
    Context context;
    String receiveID;

    public ReceiveFragment(ViewPager viewPager) {
        this.viewPager = viewPager;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        context = container.getContext();
        View view = inflater.inflate(R.layout.fragment_receive, container, false);

        final ImageView arrow1 =  view.findViewById(R.id.arrow1);
        ImageView imageView =  view.findViewById(R.id.imageView);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_data_placeholder));


        final ArrowIndicatorAnimator arrowIndicatorAnimator = new ArrowIndicatorAnimator(arrow1) {
            @Override
            void onClickArrow() {
                viewPager.setCurrentItem(1,true);
            }
        };

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (positionOffset > 0.5){
                    arrowIndicatorAnimator.cancel();
                    arrow1.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        qrDialog = new Dialog(container.getContext());

        final String qrContent = "testetsdflkdklfsmdvclkmsvclkmsdvlkmsdlkvmsldkmvlksdmvlksmdvklmsdvlkmsdlkvcm";
        final Button qrButton = view.findViewById(R.id.button_qr_generate);
        qrButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                qrDialog.setContentView(R.layout.dialog_qr);
                qrDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                qrDialog.show();
                ImageView qrImageView = qrDialog.findViewById(R.id.qr_image_view);
                qrImageView.setImageBitmap(QRCode.from(qrContent).withSize(500, 500).bitmap());
            }
        });

        Button buttonReceiveID = view.findViewById(R.id.button_receive);
        buttonReceiveID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new InputDialog(context) {
                    @Override
                    public void onResult(String result) {
                        receiveID = result;
                        Log.w("send_id", "key:" + receiveID);
                        Toast.makeText(context, receiveID, Toast.LENGTH_LONG).show();
                    }
                };
            }
        });

        return view;
    }



}
