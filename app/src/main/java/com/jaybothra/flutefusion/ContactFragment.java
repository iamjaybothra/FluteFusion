package com.jaybothra.flutefusion;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final int PERMISSION_SEND_SMS = 1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ContactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        String loc = "geo:0,0?q=42.24755556552809, -83.01971133570451 (FluteFusion)";
        String phone = "1234567890";
        String sms_email_body = "Hi FluteFusion! I have some issues regarding...";
        String[] emailID = {"bothrajay445@gmail.com"};
        String[] emailCC = {"techsupport@flutefusion.com"};
        String subject = "Issue with \"FluteFusion\"";
        String instaSite = "https://www.instagram.com/jaybothramusic";
        String website = "https://jbothra.scweb.ca/Sem1,Sem2/Jay%20Bothra%20Website/";

        ImageView email = view.findViewById(R.id.emailBtn);
        email.setOnClickListener(e -> {
            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("mailto:"));
            i.putExtra(Intent.EXTRA_EMAIL, emailID);
            i.putExtra(Intent.EXTRA_CC, emailCC);
            i.putExtra(Intent.EXTRA_SUBJECT, subject);
            i.putExtra(Intent.EXTRA_TEXT, sms_email_body);
            startActivity(i);
        });

        ImageView phoneBtn = view.findViewById(R.id.callBtn);
        phoneBtn.setOnClickListener(e -> {
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
            startActivity(i);
        });

        ImageView smsBtn = view.findViewById(R.id.smsBtn);
        smsBtn.setOnClickListener(e -> {
            // IF SMS PERMISSION IS NOT AVAILABLE
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                // HAVE I ASKED FOR PERMISSION
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.SEND_SMS)) {

                    final AlertDialog alertDialog = new
                            AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("SMS PERMISSION");
                    alertDialog.setMessage("We need Access to your SMS for us to send a SMS");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ok",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    alertDialog.dismiss();
                                    ActivityCompat.requestPermissions(getActivity(),
                                            new String[]{Manifest.permission.SEND_SMS}, PERMISSION_SEND_SMS);
                                }
                            });

                    alertDialog.show();

                } else {
                    // ASK FOR PERMISSION
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.SEND_SMS},
                            PERMISSION_SEND_SMS);
                }

            } else {
                Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:1234567890"));
                i.putExtra("sms_body", "Hi ElevateU! Excited to begin my journey of self-improvement with your app.");
                startActivity(i);
            }
        });

        ImageView locationBtn = view.findViewById(R.id.locationBtn);
        locationBtn.setOnClickListener(e->{
            Uri location = Uri.parse(loc);
            Intent i = new Intent(Intent.ACTION_VIEW, location);
            startActivity(i);
        });

        ImageView instaBtn = view.findViewById(R.id.instaBtn);
        instaBtn.setOnClickListener(e->{
            Intent i = new Intent();
            i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(instaSite));
            startActivity(i);
        });

        ImageView web = view.findViewById(R.id.webBtn);
        web.setOnClickListener(e -> {
            boolean isInstagramAppInstalled = isAppInstalled("com.instagram.android");

            if (isInstagramAppInstalled) {
                Intent instaIntent = new Intent(Intent.ACTION_VIEW);
                instaIntent.setData(Uri.parse(instaSite));
                instaIntent.setPackage("com.instagram.android");
                startActivity(instaIntent);
            } else {
                // Open Instagram profile in browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                startActivity(browserIntent);
            }
        });

        return view;
    }

    private boolean isAppInstalled(String packageName) {
        PackageManager pm = requireActivity().getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}