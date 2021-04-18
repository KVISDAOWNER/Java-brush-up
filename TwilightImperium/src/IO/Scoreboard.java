package IO;

import galaxy.Galaxy;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Scoreboard {
    public static void writeScoreboard(Galaxy g) {
        String data = "Blue has: " + g.getPlanets(g.getBluePlayer()).toString();
        data += "\n";
        data += "Red has: " + g.getPlanets(g.getRedPlayer()).toString();
        writeToFile(Paths.get("scoreboard.txt"), data);
    }

    private static void writeToFile(Path path, String content) {
        try (OutputStream os = Files.newOutputStream(path)) {
            os.write(content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println("Unable to write to path: " + path);
            e.printStackTrace();
        }
    }
}
