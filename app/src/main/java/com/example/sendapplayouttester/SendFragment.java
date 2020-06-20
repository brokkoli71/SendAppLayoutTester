package com.example.sendapplayouttester;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class SendFragment extends Fragment {
    Context context;
    ViewPager viewPager;
    String sendID;

    public SendFragment(ViewPager viewPager) {
        this.viewPager = viewPager;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        this.context = container.getContext();
        final View view = inflater.inflate(R.layout.fragment_send, container, false);

        final ImageView imageView = view.findViewById(R.id.imageView2);
        final TextView imageViewText = view.findViewById(R.id.imageViewText);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_data_placeholder));
                imageViewText.setVisibility(View.GONE);
                imageView.setOnClickListener(null);
            }
        });

        final Button buttonQR = view.findViewById(R.id.button_send_qr);
        buttonQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                IntentIntegrator integrator = new IntentIntegrator(SendFragment.this.getActivity());
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
                integrator.setOrientationLocked(true);
                Log.w("scan", integrator.toString());
            }
        });

        Button buttonSendID = view.findViewById(R.id.button_send_id);
        buttonSendID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new InputDialog(context) {
                    @Override
                    public void onResult(String result) {
                        sendID = result;
                        Log.w("send_id", "key:" + sendID);
                        Toast.makeText(context, sendID, Toast.LENGTH_LONG).show();
                    }
                };
            }
        });
        return view;
    }

    void onReceiveQR(IntentResult result){
        if(result.getContents() == null) {
            Log.e("Scan", "Cancelled scan");

        } else {
            Log.w("Scan", "Scanned: "+ result.getContents());

            Toast.makeText(context, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
        }

    }

}

