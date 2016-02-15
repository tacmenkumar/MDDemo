package tacme.com.mddemo.fragments.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tacme.com.mddemo.R;
import tacme.com.mddemo.ui.adapters.MDPeopleRecyclerViewAdapter;
import tacme.com.mddemo.ui.adapters.MDPeopleRecyclerViewAdapter.OnMDItemSelectedCallback;

public class MDRecyclerFragment extends Fragment implements OnMDItemSelectedCallback{

    private RecyclerView listPeople;
    private MDPeopleRecyclerViewAdapter peopleRecyclerViewAdapter;
    private RecyclerView.LayoutManager peopleLayoutManager;
    private OnMDItemSelectedFragmentCallback mdItemSelectedCallback;

    public MDRecyclerFragment () {

    }


    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View viewContainer = inflater.inflate(R.layout.fragment_mdrecycler, container, false);
        listPeople = (RecyclerView) viewContainer.findViewById(R.id.list_people);

        listPeople.setHasFixedSize(true);

        // use a linear layout manager
        peopleLayoutManager = new LinearLayoutManager(getActivity());
        listPeople.setLayoutManager(peopleLayoutManager);

        peopleRecyclerViewAdapter = new MDPeopleRecyclerViewAdapter(this);
        listPeople.setAdapter(peopleRecyclerViewAdapter);
        return viewContainer;
    }

    @Override
    public void onAttach (Context context) {
        super.onAttach(context);

        if (context instanceof OnMDItemSelectedFragmentCallback) {
            mdItemSelectedCallback = (OnMDItemSelectedFragmentCallback) context;
        } else {
            throw new RuntimeException(context.toString()
                                               + " must implement OnMDItemSelectedFragmentCallback");
        }
    }

    @Override
    public void onDetach () {
        super.onDetach();
        mdItemSelectedCallback = null;
    }

    @Override
    public void onItemSelected (View view, int position) {
        mdItemSelectedCallback.onMDItemSelectedCallback(view, position);
    }

    /**
     * Callback interface
     */
    public interface OnMDItemSelectedFragmentCallback {
        void onMDItemSelectedCallback(View view,  int position);
    }
}
