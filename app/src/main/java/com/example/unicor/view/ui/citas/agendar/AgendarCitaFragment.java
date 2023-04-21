package com.example.unicor.view.ui.citas.agendar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.unicor.databinding.FragmentAgendarCitaBinding;

public class AgendarCitaFragment extends Fragment {

    private FragmentAgendarCitaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AgendarCitaViewModel agendarCitaViewModel =
                new ViewModelProvider(this).get(AgendarCitaViewModel.class);

        binding = FragmentAgendarCitaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        agendarCitaViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}