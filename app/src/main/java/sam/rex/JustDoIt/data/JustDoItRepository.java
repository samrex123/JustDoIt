package sam.rex.JustDoIt.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import sam.rex.JustDoIt.model.Task;
import sam.rex.JustDoIt.util.TaskRoomDatabase;

import java.util.List;

public class JustDoItRepository {
    private final TaskDao taskDao;
    private final LiveData<List<Task>> allTasks;

    public JustDoItRepository(Application application) {
        TaskRoomDatabase database = TaskRoomDatabase.getDatabase(application);
        taskDao = database.taskDao();
        allTasks = taskDao.getTasks();
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }

    public void insert(Task task) {
        TaskRoomDatabase.databaseWriterExecutor.execute( () -> taskDao.insertTask(task));
    }

    public LiveData<Task> get(int id) { return taskDao.get(id);}

    public void update(Task task) {
        TaskRoomDatabase.databaseWriterExecutor.execute( () -> taskDao.update(task));
    }

    public void delete(Task task) {
        TaskRoomDatabase.databaseWriterExecutor.execute( () -> taskDao.delete(task));
    }





}
