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


public class ContactUsFragment extends Fragment {
    View view;
  private EditText objeName, obEmail,objPhone, objmessage;
   private Button objContactBtn;
    private static final String COLLECTION_NAME="contacts";
    private Dialog objectDialog;
    private FirebaseFirestore firebaseFirestore;



    public ContactUsFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_contact_us, container, false);
        objeName=(EditText) view.findViewById(R.id.contact_name_id);
        obEmail =(EditText) view.findViewById(R.id.contact_email_id);
        objPhone=(EditText) view.findViewById(R.id.contact_phone_id);
        objmessage =(EditText) view.findViewById(R.id.contact_messege_id);
        objContactBtn=view.findViewById(R.id.contact_btn_id);
        firebaseFirestore=FirebaseFirestore.getInstance();
        objectDialog=new Dialog(getActivity());
        objectDialog.setContentView(R.layout.please_wait);
        objectDialog.setCancelable(false);

        objContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContactUsToFirebaseFirestore();

            }
        });

        return view;
    }

    public  void addContactUsToFirebaseFirestore(){
        try {
            if (!objeName.getText().toString().isEmpty() && !obEmail.getText().toString().isEmpty()
                    && !objPhone.getText().toString().isEmpty() && !objmessage.getText().toString().isEmpty())
            {
                objectDialog.show();
                Map<String, Object> objectMap = new HashMap();
                objectMap.put("name", objeName.getText().toString());
                objectMap.put("email", obEmail.getText().toString());
                objectMap.put("phone",objPhone.getText().toString());
                objectMap.put("message", objmessage.getText().toString());
                firebaseFirestore.collection(COLLECTION_NAME)
                        .document(obEmail.getText().toString())
                        .set(objectMap)
                        .addOnSuccessListener(

                                new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        objeName.setText("");
                                        obEmail.setText("");
                                        objPhone.setText("");
                                        objmessage.setText("");
                                        objeName.requestFocus();
                                        objectDialog.dismiss();
                                        Toast.makeText(getActivity(), "Send message", Toast.LENGTH_SHORT).show();
                                    }
                                }
                        )
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        objectDialog.dismiss();

                                        Toast.makeText(getActivity(), "Your do not send" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
            }
            else if(objeName.getText().toString().isEmpty())
            {
                Toast.makeText(getActivity(), "please enter Name", Toast.LENGTH_SHORT).show();
            }
            else if(obEmail.getText().toString().isEmpty())
            {
                Toast.makeText(getActivity(), "please enter the Email", Toast.LENGTH_SHORT).show();
            }
            else if(objPhone.getText().toString().isEmpty())
            {
                Toast.makeText(getActivity(), "please enter Phone no", Toast.LENGTH_SHORT).show();
            }
            else if(objmessage.getText().toString().isEmpty())
            {
                Toast.makeText(getActivity(), "please enter The Message", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            objectDialog.dismiss();
            Toast.makeText(getActivity(), "addContactUsToFirebaseFirestore"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
