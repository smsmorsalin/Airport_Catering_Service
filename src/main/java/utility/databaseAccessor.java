package utility;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class databaseAccessor {

    public static boolean verifyUnique(Object objectToVerify,
                                       String fileName,
                                       String fieldName) {

        ArrayList<Object> objectList = BinaryFileUtility.readObjects(fileName);

        if (objectList == null) {
            return true;
        }

        try {
            for (Object object : objectList) {

                Field field = object.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);

                Object value = field.get(object);

                if (value.equals(objectToVerify)) {
                    return false;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public static Integer generateNewUniqueId(String fileName,
                                              String fieldName) {

        ArrayList<Object> objectList = BinaryFileUtility.readObjects(fileName);

        if (objectList == null || objectList.isEmpty()) {
            return 1;
        }

        int maxId = 0;

        try {

            for (Object object : objectList) {

                Field field = object.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);

                int id = (Integer) field.get(object);

                if (id > maxId) {
                    maxId = id;
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return maxId + 1;
    }
    public static String generateNewUniqueId(String fileName,
                                             String fieldName, String S) {

        ArrayList<Object> objectList = BinaryFileUtility.readObjects(fileName);

        if (objectList == null || objectList.isEmpty()) {
            return "1";
        }

        int maxId = 0;

        try {

            for (Object object : objectList) {

                Field field = object.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);

                int id = Integer.parseInt(field.get(object).toString());

                if (id > maxId) {
                    maxId = id;
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return String.valueOf(maxId + 1);
    }

}