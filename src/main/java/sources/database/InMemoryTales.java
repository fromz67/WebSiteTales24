package sources.database;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import sources.entities.Tale;

public class InMemoryTales {
    private static String fileName;
    private static List<Tale> tales = new ArrayList<>();

    public static void setServletContext(ServletContext context) {
        if (context != null) {
            fileName = context.getRealPath("/WEB-INF/data/tales.dat");
            System.out.println("File path for tales.dat: " + fileName);
            loadTales();
        }
    }

    public static List<Tale> getTales() {
        return tales;
    }

    public static Tale getTale(int index) {
        return tales.get(index);
    }

    public static void addTale(Tale tale) {
        tales.add(tale);
        saveTales();
    }

    public static void updateTale(int index, Tale tale) {
        tales.set(index, tale);
        saveTales();
    }

    public static void removeTale(int index) {
        tales.remove(index);
        saveTales();
    }

    public static void saveTales() {
        if (fileName == null) {
            System.err.println("File path for tales.dat is not set.");
            return;
        }

        try {
            File file = new File(fileName);
            File directory = file.getParentFile();
            if (!directory.exists()) {
                directory.mkdirs();
            }

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
                out.writeObject(tales);
            }
            System.out.println("Tales saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void likeTale(int index, String user) {
        Tale tale = tales.get(index);
        tale.like(user);
    }

    public static void loadTales() {
        if (fileName == null) {
            System.err.println("File path for tales.dat is not set.");
            return;
        }

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Tales file not found, using empty list.");
            return;
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            tales = (List<Tale>) in.readObject();
            System.out.println("Tales loaded from file.");
        } catch (FileNotFoundException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
