package nio;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class PathExamples {
    public static void main(String[] args) throws IOException {
        /*
       String p="1/2/3/4/5/h.txt";
        Path path=Paths.get("1", "2","3/4/5","h.txt");
        System.out.println(path);
        System.out.println(path.toAbsolutePath());

        System.out.println(path.getRoot());
        System.out.println(path.toAbsolutePath().getRoot());

        System.out.println(path.getParent());
        System.out.println(path.toAbsolutePath().getParent());
*/
        Path path=Paths.get("client/1/2");
        Path path1=Paths.get("client");

        System.out.println(path.getParent());
        System.out.println(path.toAbsolutePath().getParent());
        System.out.println(path.resolve(path1));

        WatchService service= FileSystems.getDefault()
                .newWatchService();
        new Thread(()->{
        while(true) {
            try {
                WatchKey key = service.take();//block
                List<WatchEvent<?>> events = key.pollEvents();
                if (key.isValid()) {
                    for (WatchEvent<?> event : events) {
                        System.out.println(event.count() + " "
                                + event.kind() + " " + event.context());
                    }
                }
                key.reset();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        }).start();
                path.register(service,StandardWatchEventKinds.ENTRY_CREATE,
                        StandardWatchEventKinds.ENTRY_DELETE,
                        StandardWatchEventKinds.ENTRY_MODIFY);

    }
}
