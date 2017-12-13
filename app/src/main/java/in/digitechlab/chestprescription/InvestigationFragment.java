package in.digitechlab.chestprescription;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.tappx.sdk.android.TappxBanner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import in.digitechlab.chestprescription.data.Card;
import in.digitechlab.chestprescription.data.ChestDBManager;
import in.digitechlab.chestprescription.data.CustomListAdapter;


public class InvestigationFragment extends Fragment {

    private TextView tv1;
    private ListView mListView;
    private AdView adView;

    public InvestigationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_investigation, container, false);
        mListView = (ListView) view.findViewById(R.id.listView1);

        ArrayList<Card> list = new ArrayList<>();

        ArrayList<String> inv_list = ChestDBManager.getInstance(getActivity()).QueryAllActiveInvestigation();

        Set<String> set = new HashSet<String>();
        set.addAll(inv_list);
        inv_list.clear();
        inv_list.addAll(set);

        //Toast.makeText(getActivity(), dg_list.size()+"", Toast.LENGTH_LONG).show();

        if(inv_list.size() > 0) {

            for(int i=0;i<inv_list.size();i++)
            {
                list.add(new Card(inv_list.get(i).toString()));
            }

        } else {

            list.add(new Card("No Investigation Recommended !!\n"+getActivity().getResources().getString(R.string.iv14)));

        }

        CustomListAdapter adapter = new CustomListAdapter(getActivity(), R.layout.card_layout_main, list);
        mListView.setAdapter(adapter);

        tv1 = (TextView) view.findViewById(R.id.tv_inv1);

        tv1.setText("INVESTIGATIONS RECOMMENDED");

        adView = view.findViewById(R.id.adView7);
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
