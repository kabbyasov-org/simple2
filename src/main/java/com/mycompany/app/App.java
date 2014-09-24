package com.mycompany.app;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class App
{
    public static void main( String[] args )
    {
        JSONtoXML();
        XMLtoJSON();
    }

    public static void JSONtoXML() {
        File file = new File("d:\\simple\\src.json");
        File file2 = new File("d:\\simple\\res.xml");
        String str = "";
        try {
            str = FileUtils.readFileToString(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        JSONObject json = JSONObject.fromObject(str);
        XMLSerializer serializer = new XMLSerializer();
//        serializer.setTypeHintsEnabled(false);
        serializer.setElementName("arrayElement");
        serializer.setRootName("application");
        String xml = serializer.write(json);

        try {
            FileUtils.writeStringToFile(file2, xml);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void XMLtoJSON() {
        File file = new File("d:\\simple\\res.xml");
        File file2 = new File("d:\\simple\\res.json");
        String str = "";
        try {
            str = FileUtils.readFileToString(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        XMLSerializer serializer = new XMLSerializer();
//        serializer.setTypeHintsEnabled(false);
        JSON json = serializer.read(str);

        try {
            FileUtils.writeStringToFile(file2, json.toString(2));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
