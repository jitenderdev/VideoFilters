package com.jdev.videofilters.ui.activities;

import android.graphics.Point;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jdev.videofilters.R;
import com.jdev.videofilters.filter.helper.MagicFilterType;
import com.jdev.videofilters.ui.adapters.FilterAdapter;
import com.jdev.videofilters.ui.views.VideoFilterView;
import com.jdev.videofilters.utils.ConfigUtils;
import com.jdev.videofilters.utils.Permissions;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private VideoFilterView mVideoFilterView;
    private View mFilterLayout;
    private FilterAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private boolean mIsPlaying = true;
    private ImageView mIVController;
    private View mSavingLayout;
    private View mControllerLayout;
    private ProgressBar mProgressBar;
    private static String VIDEO_PATH = Environment.getExternalStorageDirectory() + "/jatin/" + "laptop.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (Permissions.checkPermissionReadStorage(this)) {
            loadVideoFile();
        }
    }


    private void loadVideoFile() {
        ConfigUtils.getInstance().setVideoPath(VIDEO_PATH);
        MediaFormat format = ConfigUtils.getInstance().getMediaFormat();
        if (format == null) {
            Toast.makeText(this, "Video Parsing Error", Toast.LENGTH_SHORT).show();
            finish();
        }
        int videoFrameRate = format.getInteger(MediaFormat.KEY_FRAME_RATE);
        int frameInterval = 1000 / videoFrameRate;
        ConfigUtils.getInstance().setFrameInterval(frameInterval);
        setUpLayout();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mVideoFilterView != null)
            mVideoFilterView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mVideoFilterView != null)
        mVideoFilterView.onPause();
    }

    private void controlPlaying(boolean isPlaying) {
        if (isPlaying) {
            mVideoFilterView.resume();
        } else {
            mVideoFilterView.pause();
        }
        mIsPlaying = isPlaying;
        mIVController.setSelected(mIsPlaying);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.control:
                controlPlaying(!mIsPlaying);
                break;
            case R.id.cancel:
                mVideoFilterView.stopRecord();
                mFilterLayout.setVisibility(View.VISIBLE);
                mSavingLayout.setVisibility(View.GONE);
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_save:

                if (mIsPlaying) {
                    controlPlaying(false);
                }
                mProgressBar.setProgress(0);
                mVideoFilterView.startRecord();
                mControllerLayout.setVisibility(View.GONE);
                mSavingLayout.setVisibility(View.VISIBLE);

                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void setUpLayout() {
        mVideoFilterView = (VideoFilterView) findViewById(R.id.video_filter_view);
        Point screenSize = new Point();
        getWindowManager().getDefaultDisplay().getSize(screenSize);
        ViewGroup.LayoutParams params = mVideoFilterView.getLayoutParams();
        params.width = screenSize.x;
        params.height = screenSize.x;


        mVideoFilterView.setLayoutParams(params);
        mVideoFilterView.setOnSaveProgress(new VideoFilterView.OnSaveProgress() {
            @Override
            public void onProgress(int progress) {
                mProgressBar.setProgress(progress);
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_filter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new FilterAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnFilterChangeListener(new FilterAdapter.onFilterChangeListener() {
            @Override
            public void onFilterChanged(MagicFilterType filterType) {
                mVideoFilterView.getMovieRender().setFilter(filterType);
            }

            @Override
            public void onNoChanged(int pos) {
                // mSBFilter.setVisibility(mSBFilter.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
            }
        });

        mSavingLayout = findViewById(R.id.layout_saving);
        mControllerLayout = findViewById(R.id.layout_controller);
        mFilterLayout = findViewById(R.id.layout_filter);
        mFilterLayout.setVisibility(View.VISIBLE);

        findViewById(R.id.save).setOnClickListener(this);
        findViewById(R.id.cancel).setOnClickListener(this);
        mProgressBar = (ProgressBar) findViewById(R.id.progress);

        mIVController = (ImageView) findViewById(R.id.control);
        mIVController.setOnClickListener(this);
        mIVController.setSelected(true);


    }

    @Override
    protected void setDataInViewObjects() {

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {

            case Permissions.MY_PERMISSIONS_REQUEST_READ_STORAGE: {

                if (grantResults.length > 0) {
                    loadVideoFile();
                } else {
                    Toast.makeText(this, "Please provide storage permissions", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
