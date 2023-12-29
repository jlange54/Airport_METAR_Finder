package helper;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileRWTest {

    @Test
    public void file_exists () throws Exception {
        String relativePath = "/airports.txt";
        Path path = Paths.get(FileRWTest.class.getResource(relativePath).getPath().substring(1));
        assertTrue(Files.exists(path));
    }
}