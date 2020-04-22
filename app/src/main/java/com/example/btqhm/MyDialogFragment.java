package com.example.btqhm;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class MyDialogFragment extends AppCompatDialogFragment {

    private EditText editTestEntryKey;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog,null);
        builder.setView(view)
                .setTitle("Entry Key")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String entryKey = editTestEntryKey.getText().toString();

                if (entryKey.equals("Principal")){

                    startActivity(new Intent(getContext(),PrincipalActivity.class));
                }
                if (entryKey.equals("Teacher")){
                    startActivity(new Intent(getContext(),TeacherActivity.class));

                }
                if (entryKey.equals("Student")){

                    startActivity(new Intent(getContext(),StudentActivity.class));
                }
            }
        });

        editTestEntryKey = view.findViewById(R.id.passwordET);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);

        try {

        }catch (ClassCastException e){

            throw new ClassCastException(context.toString()+"Must Implement Example Dialog");
        }



    }

}
