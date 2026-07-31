package utility;

import java.util.Random;

public class databaseAccessor {
    public static boolean verifyUnique(Object ObjectToVerify, String fileName, String fieldName){
        boolean isUnique = true;
        // check file if any field Value same with ObjectToVerify then return flase
        // else:
        return isUnique;
    }

    public static Object generateNewUniqueId(String fileName, String fieldName){
        boolean tempUniqueIdCheck = false;
        int tempId;
        Random rand = new Random();
        do {
            tempId = rand.nextInt();
//            tempUniqueIdCheck = databaseAccessor.verifyUnique(tempId, "User.bin", "userId");
//            for Now as a testing purpose: tempId = unique id without verify
        }while(!tempUniqueIdCheck);
        return tempId;
    }
}
