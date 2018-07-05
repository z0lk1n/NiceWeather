package online.z0lk1n.android.niceweather.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface CitiesDAO {
    @Query("SELECT * FROM CitiesEntity")
    List<CitiesEntity> getAll();

//    @Query("SELECT * FROM CitiesEntity WHERE name LIKE :name")
//    CitiesEntity getLocationByName(String name);

    @Query("DELETE FROM CitiesEntity")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(CitiesEntity entity);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(List<CitiesEntity> entities);

    @Update
    void update(CitiesEntity entity);

    @Delete
    void delete(CitiesEntity entity);
}
