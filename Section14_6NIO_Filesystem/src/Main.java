import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    private static final String SECTION_NAME = "Section14_6NIO_Filesystem";

    public static void main(String[] args) {
        try {
            /*Path fileToCreate = FileSystems.getDefault().getPath(SECTION_NAME, "Examples", "file2.txt");
            Files.createFile(fileToCreate);*/
            /*Path dirToCreate = FileSystems.getDefault().getPath(SECTION_NAME, "Examples", "Dir4");
            Files.createDirectory(dirToCreate);*/
            /*Path dirToCreate = FileSystems.getDefault().getPath(SECTION_NAME, "Examples", "Dir2", "Dir3", "Dir4", "Dir5", "Dir6");
            Files.createDirectories(dirToCreate);*/

            /*Path dirToCreate = FileSystems.getDefault().getPath(SECTION_NAME, "Examples", "Dir2", "Dir3", "Dir4", "Dir5", "Dir6", "Dir7");
            Files.createDirectories(dirToCreate);*/

            Path filePath = FileSystems.getDefault().getPath(SECTION_NAME, "Examples", "Dir1", "file1.txt");
            System.out.println("file size = " + Files.size(filePath));;
            System.out.println("last modified = " + Files.getLastModifiedTime(filePath));

            BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("file size = " + attributes.size());;
            System.out.println("last modified = " + attributes.lastModifiedTime());
            System.out.println("Created = " + attributes.creationTime());
            System.out.println("Is directory = " + attributes.isDirectory());
            System.out.println("Is regular file = " + attributes.isRegularFile());
            //Object attributes = Files.getAttribute(filePath, "size");

            /*Path fileToDelete = FileSystems.getDefault().getPath(SECTION_NAME,"Examples", "Dir1", "file1copy.txt");
            Files.deleteIfExists(fileToDelete);*/

            /*sourceFile = FileSystems.getDefault().getPath(SECTION_NAME,"Examples", "file1copy.txt");
            copyFile = FileSystems.getDefault().getPath(SECTION_NAME,"Examples", "Dir1", "file1copy.txt");
            Files.move(sourceFile, copyFile);*/

            /*sourceFile = FileSystems.getDefault().getPath(SECTION_NAME,"Examples", "file1.txt");
            copyFile = FileSystems.getDefault().getPath(SECTION_NAME,"Examples", "file2.txt");
            Files.move(sourceFile, copyFile);*/

            /*sourceFile = FileSystems.getDefault().getPath(SECTION_NAME, "Examples", "Dir1");
            copyFile = FileSystems.getDefault().getPath(SECTION_NAME, "Examples", "Dir4");
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);*/


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            //ex.printStackTrace();
        }



        /*Path path = FileSystems.getDefault().getPath("Section14_6NIO_Filesystem", "WorkingDirectoryFile.txt");
        printFile(path);
        //path = FileSystems.getDefault().getPath("files", "SubDirectoryFile.txt");
        path = Paths.get(".","files", "SubDirectoryFile.txt");
        printFile(path);
        //path = Path.of("Users", "enrico", "IdeaProjects", "PathsTest", "OutsideDirectoryFile.txt");
        //path = Paths.get("/Users/enrico/IdeaProjects/PathsTest/OutsideDirectoryFile.txt");
        path = Paths.get("..","PathsTest", "OutsideDirectoryFile.txt");
        printFile(path);

        path = Paths.get(".");
        System.out.println(path.toAbsolutePath());

        Path path2 = FileSystems.getDefault().getPath(".", "files", "..", "files", "SubDirectoryFile.txt");
        System.out.println(path2.normalize().toAbsolutePath());
        printFile(path2);

        Path path3 = FileSystems.getDefault().getPath("thisFileDoesNotExist.txt");
        System.out.println(path3.toAbsolutePath());

        Path path4 = Paths.get("/Volumes/Test/ING", "abcdef", "whatever.txt");
        System.out.println(path4.toAbsolutePath());
        Path filePath = FileSystems.getDefault().getPath("files");
        System.out.println("Exists: " + Files.exists(filePath));
        System.out.println("Exists: " + Files.exists(path4));
        System.out.println("Readable: " + Files.isReadable(filePath));*/
    }

    /*private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }*/
}
