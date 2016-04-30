package com.abcmeasure.andyzhou.ruler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abcmeasure.andyzhou.ruler.databinding.InchGridBinding;

public class RulerRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    int length = 0;
    float dpi = 0;

    public RulerRecyclerAdapter(int length, float dpi) {
        this.length = length;
        this.dpi = dpi;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        InchGridBinding binding = InchGridBinding.inflate(inflater, parent, false);
        return new InchGridViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RulerGridViewModel viewModel = new RulerGridViewModel(String.valueOf(position), dpi);
        ((InchGridViewHolder) holder).getBinding().setGridModel(viewModel);
    }

    @Override
    public int getItemCount() {
        return length;
    }

    public class InchGridViewHolder extends RecyclerView.ViewHolder {
        InchGridBinding binding;

        public InchGridViewHolder(View itemView) {
            super(itemView);
        }

        public InchGridViewHolder(InchGridBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public InchGridBinding getBinding() {
            return binding;
        }
    }
}
