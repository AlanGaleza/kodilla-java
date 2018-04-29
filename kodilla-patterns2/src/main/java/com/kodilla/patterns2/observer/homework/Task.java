package com.kodilla.patterns2.observer.homework;

public class Task {
    private int idTask;
    private String taskContent;

    public Task(int id) {
        this.idTask = id;
        this.taskContent = "This should be content of the Task";
    }

    public int getIdTask() {
        return idTask;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }
}
