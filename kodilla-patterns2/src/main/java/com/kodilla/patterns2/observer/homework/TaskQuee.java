package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class TaskQuee implements QueeObservable {
    private final int idQuee;
    private final ArrayDeque<Task> tasksQuee;
    private final List<QueeObserver> queeObservers;
    private final String studentName;


    public TaskQuee(int idQuee, String studentName) {
        this.idQuee = idQuee;
        this.tasksQuee = new ArrayDeque<>();
        this.queeObservers = new ArrayList<>();
        this.studentName = studentName;
    }

    public void addTaskToQuee(Task task) {
        tasksQuee.offer(task);
        notifyObserver();
    }

    public int getIdQuee() {
        return idQuee;
    }

    public ArrayDeque<Task> getTasksQuee() {
        return tasksQuee;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public void registerQueeObserver(QueeObserver queeObserver) {
        queeObservers.add(queeObserver);
    }

    @Override
    public void notifyObserver() {
        queeObservers.stream().forEach(n -> n.update(this));
    }
}
