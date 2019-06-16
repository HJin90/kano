package com.mynote.kano.gitHubApi.detail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mynote.kano.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

class CommentsRecyclerViewAdapter extends RecyclerView.Adapter<CommentsRecyclerViewAdapter.ViewHolder> {
  private List<String> items = new ArrayList<>();

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    final View itemView = layoutInflater.inflate(R.layout.recycler_view_item, parent, true);
    return new CommentsRecyclerViewAdapter.ViewHolder(itemView);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    holder.bindView(items.get(position));
  }

  @Override public int getItemCount() {
    return items.size();
  }

  void setItems(@NotNull List<String> items) {
    this.items = new ArrayList<>(items);
    notifyDataSetChanged();
  }

  void addItem(@NotNull String comment) {
    items.add(0, comment);
    notifyItemInserted(0);
  }

  static class ViewHolder extends RecyclerView.ViewHolder {

    ViewHolder(View itemView) {
      super(itemView);
    }

    void bindView(String content) {
      ((TextView) itemView).setText(content);
    }
  }
}