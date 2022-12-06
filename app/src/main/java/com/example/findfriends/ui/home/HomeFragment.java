package com.example.findfriends.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.findfriends.MainActivity;
import com.example.findfriends.R;
import com.example.findfriends.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnEnvoieHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = binding.edNumeHome.getText().toString();

                // faire un appel
                // intent n7elllou activite (impplicite ou explicite)
                // call yotlob direct, dial yabaathek ll app
            /*Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:"+numero));
            startActivity(i);*/

                //envoie SMS
                if (MainActivity.sms_permission) {

                    SmsManager manager = SmsManager.getDefault();
                    manager.sendTextMessage(numero, null,
                            "findFriends: Envoyer Moi Votre Position",
                            null, null);
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}