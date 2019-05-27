package com.txtBuilder;
/**
 * @author Jay
 * @version 1.0
 */

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class txtBuilder {
    /** Produces a new file with the date in the file name and headers for writing to
     * @return file
     */
    public File createNewFile() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String fileName = "Sentiments-"
                + dateFormat.format(date) + ".txt";

        File file = new File("Data" + File.separator + "Raw",
                fileName);

        try{
            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile,
                    '|',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            String[] header = {"website", "author", "article_title", "comment"};
            writer.writeNext(header);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!file.exists()) createNewFile();
        return file;
    }
}


