package com.jdev.videofilters.render;


public interface IMovieRenderer {
    void surfaceCreated();
    void surfaceChanged(int width, int height);
    void doFrame();
    void surfaceDestroy();
}
