package com.fise.autowallpaper;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.io.IOException;

public class ChangeService extends Service {
    int[] wallpapers = new int[]{
            R.drawable.wallpaper_01, R.drawable.wallpaper_02, R.drawable.wallpaper_03
    };
    WallpaperManager wallpaperManager;
    int current = 0;
    @Override
    public void onCreate() {
        super.onCreate();
        wallpaperManager = WallpaperManager.getInstance(this);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (current >= 3) {
            current = 0;
        } try {
            wallpaperManager.setResource(wallpapers[current++]);
        } catch (IOException e) {
            e.printStackTrace();
        } return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
