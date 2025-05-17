package nader.app.statusEditor.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nader.app.statusEditor.R;
import nader.app.statusEditor.model.StylePreset;

public class StylePresetAdapter extends RecyclerView.Adapter<StylePresetAdapter.StyleViewHolder> {

    public interface OnStyleSelectedListener {
        void onStyleSelected(StylePreset preset); // Updated to pass the whole object
    }

    private final Context context;
    private final List<StylePreset> styleList;
    private final OnStyleSelectedListener listener;

    public StylePresetAdapter(Context context, List<StylePreset> styleList, OnStyleSelectedListener listener) {
        this.context = context;
        this.styleList = styleList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StyleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_style_preset, parent, false);
        return new StyleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StyleViewHolder holder, int position) {
        StylePreset preset = styleList.get(position);

        // Apply font if available
        if (preset.getFontPath() != null) {
            try {
                Typeface typeface = Typeface.createFromAsset(context.getAssets(), preset.getFontPath());
                holder.sampleText.setTypeface(typeface);
            } catch (Exception e) {
                holder.sampleText.setTypeface(Typeface.defaultFromStyle(preset.getTypefaceStyle()));
            }
        } else {
            holder.sampleText.setTypeface(Typeface.defaultFromStyle(preset.getTypefaceStyle()));
        }

        // Apply text color
        holder.sampleText.setTextColor(preset.getColor());
        holder.sampleText.setText(preset.getName());

        // Handle selection
        holder.itemView.setOnClickListener(v -> listener.onStyleSelected(preset)); // Updated
    }

    @Override
    public int getItemCount() {
        return styleList.size();
    }

    static class StyleViewHolder extends RecyclerView.ViewHolder {
        TextView sampleText;

        public StyleViewHolder(@NonNull View itemView) {
            super(itemView);
            sampleText = itemView.findViewById(R.id.sampleText);
        }
    }
}