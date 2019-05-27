package com.txtBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class txtBuilder {
    public void createNewFile() throws IOException {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String fileName = "Sentiments-" + dateFormat.format(date) + ".txt";
        
        File file = new File (fileName);
        file.createNewFile();
    }
}


