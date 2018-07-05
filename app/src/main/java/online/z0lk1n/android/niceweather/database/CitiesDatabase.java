package online.z0lk1n.android.niceweather.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {CitiesEntity.class}, version = 1)
public abstract class CitiesDatabase extends RoomDatabase {
    private static final String DATABASE = "cities_database";

    public abstract CitiesDAO citiesDAO();

    private static CitiesDatabase instance;

    static CitiesDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (CitiesDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            CitiesDatabase.class, DATABASE)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }
}
