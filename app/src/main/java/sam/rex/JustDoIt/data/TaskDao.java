package sam.rex.JustDoIt.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import sam.rex.JustDoIt.model.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insertTask(Task task);

    @Query("DELETE FROM task_table")
    void deleteAll();

    @Query("SELECT * FROM task_table")
    LiveData<List<Task>> getTasks();

    @Query("SELECT * FROM task_table WHERE task_table.task_id == :id")
    LiveData<Task> get (int id);

    @Update
    void update(Task task);

    @Delete
    void delete(Task task);
}
