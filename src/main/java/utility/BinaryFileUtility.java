package utility;

import java.io.*;
import java.util.ArrayList;

public class BinaryFileUtility {

    public static ArrayList<Object> readObjects(String fileName) {

        ArrayList<Object> objectsList = new ArrayList<>();

        if (fileName == null || fileName.isBlank()) {
            return objectsList;
        }

        File file = new File(fileName);

        if (!file.exists() || file.length() == 0) {
            return objectsList;
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {

            while (true) {
                Object tempObject = ois.readObject();
                objectsList.add(tempObject);
            }

        } catch (EOFException e) {
            // all objects have been read

        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        } catch (InvalidClassException e) {
            System.out.println("The class structure has changed.");
            e.printStackTrace();

        } catch (StreamCorruptedException e) {
            System.out.println("The binary file is corrupted or has invalid headers.");
            e.printStackTrace();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return objectsList;
    }

    public static boolean writeObjects(String fileName, Object newObject) {
        if (fileName == null) {
            return false;
        }
        ObjectOutputStream oos = null;
        try {
            File objectFile = new File(fileName);
            FileOutputStream fosForOos = null;
            if (objectFile.exists() && objectFile.length() > 0) {
                fosForOos = new FileOutputStream(objectFile, true);
                oos = new AppendableObjectOutputStream(fosForOos);
            } else {
                fosForOos = new FileOutputStream(objectFile);
                oos = new ObjectOutputStream(fosForOos);
            }
            oos.writeObject(newObject);
            return true;
        } catch (IOException e) {
            System.out.println("Error while writing to file");
        } catch (Exception e) {
            System.out.println("Error while Write Objects");
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println("Error while closing ObjectOutputStream");
                }
            }
        }
        return false;
    }

    public static boolean overwriteObjects(String fileName, ArrayList<Object> objects) {
        if (fileName == null || objects == null) {
            return false;
        }

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            for (Object object : objects) {
                oos.writeObject(object);
            }

            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
