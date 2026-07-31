package utility;

import java.io.*;
import java.util.ArrayList;

public class BinaryFileUtility {

    public static ArrayList<Object> readObjects(String fileName) {
        ArrayList<Object> objectsList = null;
        if (fileName == null) {
            return objectsList;
        }
        ObjectInputStream ois = null;
        try {
            objectsList = new ArrayList<Object>();
            ois = new ObjectInputStream(new FileInputStream(fileName));
            while (true) {
                Object tempObject = ois.readObject();
                objectsList.add(tempObject);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found in read Objects Operation");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.out.println("Error while closing ObjectInputStream");
                }
            }

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
}
