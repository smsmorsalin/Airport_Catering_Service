package utility;

import user.User;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;

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

        }catch (NumberFormatException e1){
            System.out.println("Exception in converting String to Integer");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return String.valueOf(maxId + 1);
    }


}