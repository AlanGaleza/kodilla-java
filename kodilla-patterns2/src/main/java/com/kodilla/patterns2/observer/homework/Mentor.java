package com.kodilla.patterns2.observer.homework;

public class Mentor implements QueeObserver{
    private final int idMentor;
    private int updateCount;

    public Mentor(int idMentor) {
        this.idMentor = idMentor;
    }

    public int getIdMentor() {
        return idMentor;
    }

    @Override
    public void update(TaskQuee taskQuee) {
        System.out.println("U recived new task: " + taskQuee.getTasksQuee().peekLast() + "from: " + taskQuee.getStudentName());
        updateCount++;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
