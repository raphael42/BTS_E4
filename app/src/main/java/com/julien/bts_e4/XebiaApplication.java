package com.julien.bts_e4;

/**
 * Created by julien on 21/04/2017.
 */


import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public final class XebiaApplication extends Application {

    private RequestQueue mVolleyRequestQueue;
    private ImageLoader mVolleyImageLoader;

    @Override
    public void onCreate() {
        super.onCreate();

        // On initialise notre Thread-Pool et notre ImageLoader
        mVolleyRequestQueue = Volley.newRequestQueue(getApplicationContext());
        mVolleyImageLoader = new ImageLoader(mVolleyRequestQueue, new BitmapLruCache());
        mVolleyRequestQueue.start();
    }

    public RequestQueue getVolleyRequestQueue() {
        return mVolleyRequestQueue;
    }

    public ImageLoader getVolleyImageLoader() {
        return mVolleyImageLoader;
    }

    @Override
    public void onTerminate() {
        mVolleyRequestQueue.stop();
        super.onTerminate();
    }
}