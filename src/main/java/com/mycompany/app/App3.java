package com.mycompany.app;

import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.copy.HierarchicalStreamCopier;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JettisonStaxWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;
import com.thoughtworks.xstream.io.xml.Dom4JXmlWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyWriter;
import com.thoughtworks.xstream.io.xml.XppReader;
import org.apache.commons.io.FileUtils;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

public class App3 {

        public static void main(String[] args) throws Exception {

            File file = new File("d:\\simple\\src3.json");
            File file2 = new File("d:\\simple\\res3.xml");

            HierarchicalStreamDriver driver = new JettisonMappedXmlDriver();
            HierarchicalStreamDriver driver2 = new DomDriver();
            HierarchicalStreamReader hsr = driver.createReader(file);
//            HierarchicalStreamWriter hsw = driver2.createWriter(file);

            StringWriter writer = new StringWriter();
            new HierarchicalStreamCopier().copy(hsr, driver2.createWriter(writer));
            writer.close();
//            System.out.println(writer.toString());

            try {
                FileUtils.writeStringToFile(file2, writer.toString());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
}

