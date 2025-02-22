
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class Task {
    public void longRunningTask() throws InterruptedException {
        Thread.sleep(3000);
    }
}

public class TaskTest {
    Task task = new Task();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    public void testLongRunningTask() throws InterruptedException {
        task.longRunningTask();
    }
}
