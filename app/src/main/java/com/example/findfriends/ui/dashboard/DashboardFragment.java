package com.example.findfriends.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.findfriends.R;
import com.example.findfriends.databinding.ExempleBinding;
import com.example.findfriends.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {


private FragmentDashboardBinding binding;
// contexte = activite qui occupe l'ecran
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

    binding = FragmentDashboardBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        final TextView textView = binding.textDashboard;

        //method oone not used : Button btn = getActivity.findById(R.id.button)
        /*LayoutInflater inf = LayoutInflater.from(getActivity());
        View v= inf.inflate(R.layout.exemple, null);
        ImageView img = v.findViewById(R.id.image_view);*/




        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}