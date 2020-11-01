package Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.getoutpolio.AreaActivity;
import com.example.getoutpolio.AreasActivity;
import com.example.getoutpolio.CampaignDatesActivity;
import com.example.getoutpolio.CampaignDatesShowUserActivity;
import com.example.getoutpolio.ForgotPasswordActivity;
import com.example.getoutpolio.LoginActivity;
import com.example.getoutpolio.MainActivity;
import com.example.getoutpolio.MapsActivity;
import com.example.getoutpolio.R;
import com.example.getoutpolio.RegistraionActivity;
import com.example.getoutpolio.TaskActivity;
import com.example.getoutpolio.Team01ByUserActivity;
import com.example.getoutpolio.Team01UserTaskActivity;
import com.example.getoutpolio.TeamActivity;
import com.example.getoutpolio.TeamApp;


public class DashboardFragment extends Fragment {

View view;
    ImageView objTeam,objMaps,objRegistraion,objAreas,objTask,objCampaigndate,objSecurityThreats ;
    public DashboardFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_dashboard, container, false);
         objTeam=(ImageView) view.findViewById(R.id.team_item_id);
         objMaps=(ImageView) view.findViewById(R.id.maps_item_id);
         objAreas=(ImageView) view.findViewById(R.id.areas_item_id);
         objRegistraion=(ImageView) view.findViewById(R.id.registraion_id);
         objTask=(ImageView) view.findViewById(R.id.task_des_id);
         objCampaigndate=(ImageView) view.findViewById(R.id.campaign_dates_id);
         objSecurityThreats=(ImageView) view.findViewById(R.id.security_threats_id);
        objTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), TeamApp.class);
                    startActivity(intent);


            }
        });
        objRegistraion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RegistraionActivity.class);
                startActivity(intent);
            }
        });
        objMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);

            }
        });
        objAreas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), AreaActivity.class);
                startActivity(intent);
            }
        });
        objTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Team01UserTaskActivity.class);
                startActivity(intent);
            }
        });
        objTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Team01ByUserActivity.class);
                startActivity(intent);
            }
        });
        objCampaigndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), CampaignDatesShowUserActivity.class);
                startActivity(intent);
            }
        });
        objSecurityThreats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Send Your Location to admin", Toast.LENGTH_LONG).show();
            }
        });
//        objTeam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment fragment=new TeamFragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragment_container, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//            }
//        });

//        objMaps.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment fragment = new MapsFragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragment_container, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//            }
//        });


        return view;
    }

}
