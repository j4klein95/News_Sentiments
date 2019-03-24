package com.selenium.ff.drive;

import java.io.File;
import java.util.Calendar;

public class fileBuilder {
    public File buildFile(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        System.out.println(day);
      return null;
    }
}
