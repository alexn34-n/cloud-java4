package nio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;

public class FileExamples {
    public static void main(String[] args) throws IOException {
        StandardCopyOption co;
        StandardOpenOption oo;
        StandardCharsets sc;

        //CREATE-пересоздание
        //APPEND-дописывание

        Files.write(Paths.get("client/2.txt"),
                "Hello people!".getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.APPEND);

        Files.copy(Paths.get("client/2.txt"),
                Paths.get("client/4.txt"),
                StandardCopyOption.REPLACE_EXISTING);

        

        Files.walkFileTree(Paths.get("./"), 
        new SimpleFileVisitor<Path>(){

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                return super.visitFile(file, attrs);
            }
        });

    }
}
