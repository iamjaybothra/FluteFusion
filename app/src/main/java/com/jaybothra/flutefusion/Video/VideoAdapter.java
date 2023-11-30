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
    private int currentPlayingPosition = -1;
    private Context context;

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
        holder.bind(resourceId, videoTitle);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull VideoViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.stopVideo();
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    class VideoViewHolder extends RecyclerView.ViewHolder {

        PlayerView playerView;
        TextView videoTitleTextView;
        SimpleExoPlayer player;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            playerView = itemView.findViewById(R.id.player_view);
            videoTitleTextView = itemView.findViewById(R.id.VideoTitle);
            player = new SimpleExoPlayer.Builder(itemView.getContext()).build();

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    if (currentPlayingPosition != position) {
                        stopPlayback();
                        playVideo(videoList.get(position), position);
                    } else {
                        togglePlayback();
                    }
                }
            });
        }

        void togglePlayback() {
            if (player.isPlaying()) {
                stopVideo();
            } else {
                player.setPlayWhenReady(true);
            }
        }

        void stopVideo() {
            if (player != null) {
                player.setPlayWhenReady(false);
                currentPlayingPosition = -1;
            }
        }

        void playVideo(int resourceId, int position) {
            stopPlayback();
            currentPlayingPosition = position;

            Uri uri = Uri.parse("android.resource://" + itemView.getContext().getPackageName() + "/" + resourceId);
            MediaItem mediaItem = MediaItem.fromUri(uri);
            player.setMediaItem(mediaItem);
            player.setPlayWhenReady(true);
            player.prepare();
            playerView.setPlayer(player);
        }

        void bind(int resourceId, String videoTitle) {
            videoTitleTextView.setText(videoTitle);

            Uri uri = Uri.parse("android.resource://" + itemView.getContext().getPackageName() + "/" + resourceId);
            MediaItem mediaItem = MediaItem.fromUri(uri);
            player.setMediaItem(mediaItem);
            player.prepare();
            playerView.setPlayer(player);
        }
    }

    public void stopPlayback() {
        for (int i = 0; i < videoList.size(); i++) {
            if (i != currentPlayingPosition) {
                notifyItemChanged(i);
            }
        }
    }
}
