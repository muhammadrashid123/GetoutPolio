package Fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.getoutpolio.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class ComplainFragment extends Fragment {
    View view;
      private EditText objname,objemail,objComplain;
      private Button objComplainBtn;
    private static final String COLLECTION_NAME="complains";
    private Dialog objectDialog;
    private FirebaseFirestore firebaseFirestore;

    public ComplainFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_complain, container, false);
        objname=(EditText) view.findViewById(R.id.name_complain_id);
        objemail=(EditText) view.findViewById(R.id.email_complain_Id);
        objComplain=(EditText) view.findViewById(R.id.compain_text_Id);
        objComplainBtn=view.findViewById(R.id.button_complain_id);
        firebaseFirestore=FirebaseFirestore.getInstance();
        objectDialog=new Dialog(getActivity());
        objectDialog.setContentView(R.layout.please_wait);
        objectDialog.setCancelable(false);
        objComplainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addComplainToFirebaseFirestore();
            }
        });


        return view;
    }
    public  void addComplainToFirebaseFirestore(){
        try {
            if (!objname.getText().toString().isEmpty() && !objemail.getText().toString().isEmpty()
                    && !objComplain.getText().toString().isEmpty())
            {
                objectDialog.show();
                Map<String, Object> objectMap = new HashMap();
                objectMap.put("name", objname.getText().toString());
                objectMap.put("email", objemail.getText().toString());
                objectMap.put("complain",objComplain.getText().toString());
                firebaseFirestore.collection(COLLECTION_NAME)
                        .document(objemail.getText().toString())
                        .set(objectMap)
                        .addOnSuccessListener(

                                new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        objname.setText("");
                                        objemail.setText("");
                                        objComplain.setText("");
                                        objname.requestFocus();
                                        objectDialog.dismiss();
                                        Toast.makeText(getActivity(), "complain added to collection", Toast.LENGTH_SHORT).show();
                                    }
                                }
                        )
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        objectDialog.dismiss();

                                        Toast.makeText(getActivity(), "fails complain add to collection" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
            }
            else if(objname.getText().toString().isEmpty())
            {
                Toast.makeText(getActivity(), "please enter Name", Toast.LENGTH_SHORT).show();
            }
            else if(objemail.getText().toString().isEmpty())
            {
                Toast.makeText(getActivity(), "please enter the Email", Toast.LENGTH_SHORT).show();
            }
            else if(objComplain.getText().toString().isEmpty())
            {
                Toast.makeText(getActivity(), "please enter The Complain", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            objectDialog.dismiss();
            Toast.makeText(getActivity(), "addComplainToFirebaseFirestore"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
