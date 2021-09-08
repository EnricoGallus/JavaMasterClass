import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFiles extends SimpleFileVisitor<Path> {

    private final Path sourceRoot;
    private final Path targetRoot;

    public CopyFiles(Path sourceRoot, Path targetRoot) {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accessing file " + file.toAbsolutePath() + " " + exc.getMessage());
        return super.visitFileFailed(file, exc);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path relativize = sourceRoot.relativize(dir);
        System.out.println("Relativize Path = " + relativize);
        Path copyDir = targetRoot.resolve(relativize);

        try {
            Files.copy(dir, copyDir);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return FileVisitResult.SKIP_SUBTREE;
        }

        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativize = sourceRoot.relativize(file);
        System.out.println("Relativize Path = " + relativize);
        Path copyDir = targetRoot.resolve(relativize);

        try {
            Files.copy(file, copyDir);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return super.visitFile(file, attrs);
    }
}
