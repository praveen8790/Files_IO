import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class Java8WatchServiceExampleTest {
    @Test
    public void givenADirectoryWhenWatchedListsAllTheActivities() throws  IOException {
        Path dir = Paths.get("C:\\Users\\prave\\TempPlayGround");
        Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
        new Java8WatchServiceExample(dir).processEvents();
    }

}