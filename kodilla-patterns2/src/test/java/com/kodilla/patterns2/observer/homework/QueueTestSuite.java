package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class QueueTestSuite {

    @Test
    public void queeTasksUpdate() {
        //Given
        Mentor mentor = new Mentor(1);
        Task task1 = new Task(1, "First Task");
        Task task2 = new Task(2, "Second Task");
        TaskQueue queue = new TaskQueue(1, "Alan Galeza");
        queue.registerQueueObserver(mentor);

       //When
        queue.addTaskToQueue(task1);
        queue.addTaskToQueue(task2);
        //Then
        assertThat(2).isEqualTo(mentor.getUpdateCount());

    }
}
