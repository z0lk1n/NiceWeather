package online.z0lk1n.android.niceweather.database;

import android.arch.persistence.room.Database;

@Database(entities = (WeatherEntity.class), version = 1)
public abstract class WeatherDataBase {
}
