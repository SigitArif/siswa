package com.example.siswa.util;

import java.util.Collection;

public class AssertUtil {
    public static Boolean isEmptyOrNull(Object obj){
        if(obj == null) return true;
        if(obj instanceof String)
            return ((String) obj).isEmpty();
        else if (obj instanceof Collection)
            return ((Collection<?>) obj).size() == 0;
        return false;
    }
}
