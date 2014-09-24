package com.mycompany.app;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.copy.HierarchicalStreamCopier;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.XppReader;
import org.apache.commons.io.FileUtils;

public class App2 {

        public static void main(String[] args) throws Exception {

            File file = new File("d:\\simple\\res3.xml");
            File file2 = new File("d:\\simple\\res2.json");
            String str = "";
            try {
                str = FileUtils.readFileToString(file);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            HierarchicalStreamReader sourceReader = new XppReader(new StringReader(str));


            StringWriter buffer = new StringWriter();
            JettisonMappedXmlDriver jettisonDriver = new JettisonMappedXmlDriver();
            HierarchicalStreamWriter destinationWriter = jettisonDriver.createWriter(buffer);

            HierarchicalStreamCopier copier = new HierarchicalStreamCopier();
            copier.copy(sourceReader, destinationWriter);

            System.out.println(buffer.toString());
            try {
                FileUtils.writeStringToFile(file2, buffer.toString());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
}
