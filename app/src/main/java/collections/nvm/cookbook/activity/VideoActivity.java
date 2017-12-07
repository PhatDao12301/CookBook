package collections.nvm.cookbook.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import collections.nvm.cookbook.R;

public class VideoActivity extends YouTubeBaseActivity {
    public static final String MY_API_KEY = "AIzaSyCNI-Kg3jbOxhsau_OzNxYvZdeCVVBgnsY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Bundle extra = getIntent().getExtras();
        if (extra == null)
            return;
        final String Link = extra.getString("link");

        YouTubePlayerView youTubePlayerView =
                (YouTubePlayerView) findViewById(R.id.player);

        youTubePlayerView.initialize(MY_API_KEY,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {

                        // do any work here to cue video, play video, etc.
                        youTubePlayer.loadVideo(Link);
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer
                                                                .Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {

                    }
                });
    }
}
