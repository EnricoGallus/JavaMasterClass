import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private static final String SECTION_NAME = "Section14_7FileTree";

    public static void main(String[] args) {
        /*DirectoryStream.Filter<Path> filter = Files::isRegularFile;

        Path directory = FileSystems.getDefault().getPath(SECTION_NAME, "FileTree", "Dir2");
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
            for (Path file: contents) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException ex) {
            System.out.println(ex.getMessage());
        }

        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        try {
            Path tempFile = Files.createTempFile("myapp", ".appext");
            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store: stores) {
            System.out.println(store);
            System.out.println(store.name());
        }

        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for (Path path : rootPaths) {
            System.out.println(path);
        }*/

        Path dir2Path = FileSystems.getDefault().getPath(SECTION_NAME, "FileTree", "Dir2");
        try {
            Files.walkFileTree(dir2Path, new PrintNames());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        /*Path copyPath = FileSystems.getDefault().getPath(SECTION_NAME, "FileTree", "Dir4", "Dir2Copy");
        try {
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/

        File file = new File(SECTION_NAME + "/Examples/file.txt");
        Path convertedPath = file.toPath();
        System.out.println("Converted Path = " + convertedPath);

        File parent = new File(SECTION_NAME + "/Examples");
        File resolveFile = new File(parent, "dir/file.txt");
        System.out.println(resolveFile.toPath());

        resolveFile = new File(SECTION_NAME + "/Examples", "dir/file.txt");
        System.out.println(resolveFile.toPath());

        Path parentPath = Paths.get(SECTION_NAME + "/Examples");
        Path childRelativePath = Paths.get("dir/file.txt");
        System.out.println(parentPath.resolve(childRelativePath));

        File workingDirectory = new File(SECTION_NAME).getAbsoluteFile();
        System.out.println("Working directory = " + workingDirectory.getAbsolutePath());

        File dir2File = new File(workingDirectory, "/FileTree/Dir2");
        String[] dir2Contents = dir2File.list();
        for (int i = 0; i < dir2Contents.length; i++) {
            String content = dir2Contents[i];
            System.out.println("i = " + i + " name = " + content);
        }

        File[] dir2Files = dir2File.listFiles();
        for (int i = 0; i < dir2Files.length; i++) {
            System.out.println("i = " + i + " file = " + dir2Files[i].getName());
        }
    }
}
