package com.kodilla.patterns2.observer.homework;

public class Task {
    private int idTask;
    private String taskContent;

    public Task(int id, String taskContent) {
        this.idTask = id;
        this.taskContent = taskContent;
    }

    public int getIdTask() {
        return idTask;
    }

    public String getTaskContent() {
        return taskContent;
    }

}
