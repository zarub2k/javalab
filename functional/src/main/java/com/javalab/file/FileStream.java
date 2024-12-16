package com.javalab.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;

/**
 * @author Tham
 */
public class FileStream {
    public static void main(String[] args) {
        FileStream fileStream = new FileStream();
//        fileStream.doFileStream();
        fileStream.doDirDepthWithWalk();
    }

    private void doFileStream() {
        Path path = Paths.get("./functional/src/main/java/com/javalab");
        try (var stream = Files.list(path)) {
            stream.map(Path::toFile)
                    .filter(Predicate.not(File::isFile))
                    .map(File::getName)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error happened");
            e.printStackTrace();
        }
    }

    private void doDirDepthWithWalk() {
        var start = Paths.get("./functional");
        try (var stream = Files.walk(start)) {
            stream.map(Path::toFile)
                    .filter(Predicate.not(File::isFile))
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
