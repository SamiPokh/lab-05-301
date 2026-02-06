package com.example.lab5_starter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DelCityFragment extends DialogFragment {
    interface DeleteCityDialogListener {
        void deleteCity(String cityName);
    }

    private DeleteCityDialogListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof DeleteCityDialogListener) {
            listener = (DeleteCityDialogListener) context;
        } else {
            throw new RuntimeException("Implement DeleteCityDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.fragment_delete_city, null);
        EditText editCityName = view.findViewById(R.id.edit_delete_city_name);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        return builder
                .setView(view)
                .setTitle("Delete City")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Delete", (dialog, which) -> {
                    String cityName = editCityName.getText().toString().trim();
                    if (!cityName.isEmpty()) {
                        listener.deleteCity(cityName);
                    }
                })
                .create();
    }
}