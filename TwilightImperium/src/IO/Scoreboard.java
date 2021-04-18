package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Scoreboard {
    public static void test(){
        writeToFile(Paths.get("scorboard.txt"), "your mom");
    }
    private static void writeToFile(Path path, String content){
        try(OutputStream os = Files.newOutputStream(path)) {
            os.write(content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println("Unable to write to path: " + path);
            e.printStackTrace();
        }
    }
}
