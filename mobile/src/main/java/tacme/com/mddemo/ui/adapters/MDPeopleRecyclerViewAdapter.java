package tacme.com.mddemo.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tacme.com.mddemo.R;
import tacme.com.mddemo.ui.viewholders.MDPeopleRecyclerViewHolder;

/**
 * Created by TACME on 2/14/16.
 */
public class MDPeopleRecyclerViewAdapter extends RecyclerView.Adapter<MDPeopleRecyclerViewHolder> {

    private OnMDItemSelectedCallback callback;

    public MDPeopleRecyclerViewAdapter (OnMDItemSelectedCallback callback) {
        super();
        this.callback = callback;
    }

    @Override
    public MDPeopleRecyclerViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                               .inflate(R.layout.listitem_person, parent, false);

        MDPeopleRecyclerViewHolder viewHolder = new MDPeopleRecyclerViewHolder(v, callback);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder (MDPeopleRecyclerViewHolder holder, int position) {
        holder.titleTextview.setText("Person: " + position);
        holder.titleTextview.setTag(position);
    }

    @Override
    public void onBindViewHolder (MDPeopleRecyclerViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemViewType (int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void setHasStableIds (boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
    }

    @Override
    public long getItemId (int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount () {
        return 100;
    }

    @Override
    public void onViewRecycled (MDPeopleRecyclerViewHolder holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public boolean onFailedToRecycleView (MDPeopleRecyclerViewHolder holder) {
        return super.onFailedToRecycleView(holder);
    }

    @Override
    public void onViewAttachedToWindow (MDPeopleRecyclerViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewDetachedFromWindow (MDPeopleRecyclerViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void registerAdapterDataObserver (AdapterDataObserver observer) {
        super.registerAdapterDataObserver(observer);
    }

    @Override
    public void unregisterAdapterDataObserver (AdapterDataObserver observer) {
        super.unregisterAdapterDataObserver(observer);
    }

    @Override
    public void onAttachedToRecyclerView (RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView (RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public interface OnMDItemSelectedCallback{
        void onItemSelected(View view, int position);
    }
}
