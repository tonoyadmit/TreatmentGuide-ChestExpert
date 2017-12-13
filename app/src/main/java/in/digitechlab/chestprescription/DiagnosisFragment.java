package in.digitechlab.chestprescription;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.tappx.sdk.android.TappxBanner;

import java.util.ArrayList;

import in.digitechlab.chestprescription.data.Card;
import in.digitechlab.chestprescription.data.ChestDBManager;
import in.digitechlab.chestprescription.data.CustomListAdapter;

public class DiagnosisFragment extends Fragment {

    private TextView tv1;
    private ListView mListView;
    private AdView adView;

    public DiagnosisFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_diagnosis, container, false);
        mListView = (ListView) view.findViewById(R.id.listView);

        ArrayList<Card> list = new ArrayList<>();

        ArrayList<String> dg_list = ChestDBManager.getInstance(getActivity()).QueryAllActiveDiagnosis();

        //Toast.makeText(getActivity(), dg_list.size()+"", Toast.LENGTH_LONG).show();

        if(dg_list.size() > 0) {

            for(int i=0;i<dg_list.size();i++)
            {
                list.add(new Card(dg_list.get(i).toString()));
            }

        } else {

            list.add(new Card("No Chest Disease Found !!\n"+getActivity().getResources().getString(R.string.dg18)));

        }

        CustomListAdapter adapter = new CustomListAdapter(getActivity(), R.layout.card_layout_main, list);
        mListView.setAdapter(adapter);

        tv1 = (TextView) view.findViewById(R.id.tv_dg1);

        tv1.setText(" "+dg_list.size()+" DISEASE IDENTIFIED!!");

        adView = view.findViewById(R.id.adView6);
        final AdRequest adRequest=new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(adRequest);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (adView != null) adView.destroy();
    }
}
