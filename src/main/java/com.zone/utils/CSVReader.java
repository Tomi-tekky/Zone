package com.zone.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class CSVReader {
            public static Map<String, Map<String, String>> readCSV(String filePath) {
            Map<String, Map<String, String>> data = new HashMap<>();

            try (
                    Reader reader = new FileReader(filePath);
                    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.builder().setSkipHeaderRecord(true).build())

            ) {

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return data;
        }
    }

