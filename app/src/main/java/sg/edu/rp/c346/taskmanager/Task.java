package sg.edu.rp.c346.taskmanager;

import java.io.Serializable;

/**
 * Created by 15056158 on 30/5/2017.
 */

public class Task  implements Serializable {
    private int id;
    private String taskName;
    private String taskDescrption;


    public Task(int id, String taskName, String taskDescrption) {
        this.id = id;
        this.taskName = taskName;
        this.taskDescrption = taskDescrption;

    }

    public int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescrption() {
        return taskDescrption;
    }
}


