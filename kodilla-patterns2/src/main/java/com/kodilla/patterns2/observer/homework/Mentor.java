package com.kodilla.patterns2.observer.homework;

public class Mentor implements QueueObserver {
    private final int idMentor;
    private int updateCount;

    public Mentor(int idMentor) {
        this.idMentor = idMentor;
    }

    public int getIdMentor() {
        return idMentor;
    }

    @Override
    public void update(TaskQueue taskQuee) {
        System.out.println("U recived new task: " + taskQuee.getTasksQuee().peekLast().getTaskContent() + " from: " + taskQuee.getStudentName());
        updateCount++;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
