package structural.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Composite {
    public static void main(String[] args) {
        FileComponent leaf = new FileLeaf("Leaf", 100);
        FileComponent leafThai = new FileLeaf("Thai", 150);

        FileComponent folderHome = new FolderComposite("home", 200, new ArrayList<FileComponent>());
        FileComponent folderUser = new FolderComposite("user", 120, new ArrayList<FileComponent>(Arrays.asList(leafThai)));

        FileComponent root = new FolderComposite(
                "root",
                500,
                new ArrayList<FileComponent>(Arrays.asList(leaf, folderHome, folderUser)));
        root.open();
    }
}

abstract class FileComponent {
    protected String name;
    protected int size;

    public FileComponent (String name, int size) {
        this.name = name;
        this.size = size;
    }

    protected void showProperties() {
        System.out.println(String.format("Name: %s", name));
        System.out.println(String.format("Size: %d", size));
    }

    public abstract void open();
}

class FileLeaf extends FileComponent {
    public FileLeaf(String name, int size) {
        super(name, size);
    }

    @Override
    public void open() {
        System.out.println(">> Opening file...");
        this.showProperties();
    }
}

class FolderComposite extends FileComponent {

    List<FileComponent> children;

    public FolderComposite(String name, int size, List<FileComponent> files) {
        super(name, size);
        this.children = files;
    }

    @Override
    public void open() {
        System.out.println(">> Opening folder...");
        this.showProperties();
        for (FileComponent file: children) {
            file.open();
        }
    }
}
