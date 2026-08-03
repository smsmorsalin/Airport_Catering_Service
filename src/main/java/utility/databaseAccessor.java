package utility;

import nonuser.CateringOrder;
import user.User;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.UUID;

public class databaseAccessor {

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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return maxId + 1;
    }

    public static String generateNewUniqueStringId(String fileName, String fieldName) {
        try {
            String prefix = "OI-";
            String uniquePart = UUID.randomUUID()
                    .toString()
                    .replace("-", "")
                    .substring(0, 10)
                    .toUpperCase();
            String uniqueStringId = prefix + uniquePart;
            ArrayList<Object> arrayList = BinaryFileUtility.readObjects(fileName);
            for (Object object : arrayList) {
                Field field = object.getClass().getDeclaredField(fieldName);
                if (field.equals(uniqueStringId)) {
                    generateNewUniqueStringId(fileName, fieldName);
                }
            }
            return uniqueStringId;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object checkTheIdExist(String fileName, String fieldName, int toCheckId) {

        ArrayList<Object> objectList;

        try {
            objectList = BinaryFileUtility.readObjects(fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        if (objectList == null || objectList.isEmpty()) {
            return null;
        }

        for (Object object : objectList) {
            try {
                Field field = object.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);

                int id = Integer.parseInt(field.get(object).toString());

                if (id == toCheckId) {
                    return object;   // Found
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;    // Not found
    }

}