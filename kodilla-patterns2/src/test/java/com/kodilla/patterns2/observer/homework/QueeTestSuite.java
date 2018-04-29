package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class QueeTestSuite {

    @Test
    public void queeTasksUpdate() {
        //Given
        Mentor mentor = new Mentor(1);
        Task task1 = new Task(1, "First Task");
        Task task2 = new Task(2, "Second Task");
        TaskQuee quee = new TaskQuee(1, "Alan Galeza");
        quee.registerQueeObserver(mentor);

       //When
        quee.addTaskToQuee(task1);
        quee.addTaskToQuee(task2);
        //Then
        assertThat(2).isEqualTo(mentor.getUpdateCount());

    }
}
