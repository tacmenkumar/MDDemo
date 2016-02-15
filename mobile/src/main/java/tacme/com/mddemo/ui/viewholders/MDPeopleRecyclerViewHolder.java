package tacme.com.mddemo.ui.viewholders;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;

import tacme.com.mddemo.R;
import tacme.com.mddemo.ui.adapters.MDPeopleRecyclerViewAdapter.OnMDItemSelectedCallback;

/**
 * Created by TACME on 2/14/16.
 */
public class MDPeopleRecyclerViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

    public CardView personCardView;
    public AppCompatTextView titleTextview, subTitleTextview;

    private OnMDItemSelectedCallback callback;

    public MDPeopleRecyclerViewHolder (View itemView, OnMDItemSelectedCallback callback) {
        super(itemView);

        this.callback = callback;

        personCardView = (CardView) itemView.findViewById(R.id.person_cardview);
        personCardView.setOnClickListener(this);
        titleTextview = (AppCompatTextView) itemView.findViewById(R.id.title_textview);
        subTitleTextview = (AppCompatTextView) itemView.findViewById(R.id.subtitle_textview);
    }

    @Override
    public String toString () {
        return super.toString();
    }

    @Override
    public void onClick (View v) {
        callback.onItemSelected(v, (int)titleTextview.getTag());
    }
}
