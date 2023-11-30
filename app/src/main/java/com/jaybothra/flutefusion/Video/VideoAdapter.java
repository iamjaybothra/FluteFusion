package com.jaybothra.flutefusion.Video;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.jaybothra.flutefusion.R;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<Integer> videoList;
    private List<String> videoTitles;
    private SimpleExoPlayer player;
    private Context context; // Add a Context variable

    public VideoAdapter(Context context, List<Integer> videoList, List<String> videoTitles) {
        this.context = context;
        this.videoList = videoList;
        this.videoTitles = videoTitles;
        player = new SimpleExoPlayer.Builder(context).build();
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item_layout, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        int resourceId = videoList.get(position);
        String videoTitle = videoTitles.get(position);
        holder.bind(holder.itemView.getContext(), resourceId, videoTitle);
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    class VideoViewHolder extends RecyclerView.ViewHolder {

        PlayerView playerView;
        TextView videoTitleTextView;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            playerView = itemView.findViewById(R.id.player_view);
            videoTitleTextView = itemView.findViewById(R.id.VideoTitle);
        }

        void bind(Context context, int resourceId, String videoTitle) {
            SimpleExoPlayer player = new SimpleExoPlayer.Builder(context).build();
            Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/" + resourceId);
            MediaItem mediaItem = MediaItem.fromUri(uri);
            player.setMediaItem(mediaItem);
            player.setPlayWhenReady(true); // Start playing when ready
            player.prepare();

            playerView.setPlayer(player);
            videoTitleTextView.setText(videoTitle);
        }
    }
    public void releasePlayer() {
        if (player != null) {
            player.release();
            player = null;
        }
    }
}
