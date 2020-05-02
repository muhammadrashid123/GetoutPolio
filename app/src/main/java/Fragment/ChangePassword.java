package Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.getoutpolio.LoginActivity;
import com.example.getoutpolio.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ChangePassword extends Fragment {
    View view;
    private EditText newPassword;

    private Button btn_confirm;
    private FirebaseAuth firebaseAuth;
    private ProgressBar objectWaitPB;
    private EditText userEmailET;

    public ChangePassword() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_change_password, container, false);
        firebaseAuth = FirebaseAuth.getInstance();


        connectXML();

        return view;
    }

    private void connectXML() {
        try {


            newPassword = view.findViewById(R.id.New_password_Id);
            btn_confirm=view.findViewById(R.id.button_Confirm);

            objectWaitPB = view.findViewById(R.id.waitProgressBar);
            btn_confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changePassword();
                }
            });


        } catch (Exception e) {
            Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
        }
    }

    public void changePassword() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        try {
            if (!newPassword.getText().toString().isEmpty()) {

                if (user != null) {
                    objectWaitPB.setVisibility(View.VISIBLE);

                    user.updatePassword(newPassword.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        objectWaitPB.setVisibility(View.INVISIBLE);
                                        Toast.makeText(getActivity(), "Your password has been change Successful", Toast.LENGTH_SHORT).show();
                                        firebaseAuth.signOut();

                                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                                        startActivity(intent);
                                        getActivity().finish();
                                    } else {
                                        objectWaitPB.setVisibility(View.INVISIBLE);
                                        Toast.makeText(getActivity(), "Your password could not be channge", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
            else
            {
                Toast.makeText(getActivity(), "Please enter new Password", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            objectWaitPB.setVisibility(View.INVISIBLE);
            btn_confirm.setEnabled(true);
            Toast.makeText(getActivity(), "signInUser" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

}