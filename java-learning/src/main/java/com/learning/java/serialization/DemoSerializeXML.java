package com.learning.java.serialization;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoSerializeXML {

    public static void main(String[] args) throws IOException {
        XMLPOJO xmlpojo = new XMLPOJO("Kaushik", "Sekar", " ");
        FileOutputStream fileOutputStream = new FileOutputStream("settings.xml");
        XMLEncoder xmlEncoder = new XMLEncoder(fileOutputStream);
        xmlEncoder.setExceptionListener(e -> System.out.println("Exception : " + e.toString()));
        xmlEncoder.writeObject(xmlpojo);
        xmlEncoder.close();
        fileOutputStream.close();
    }

}
