package com.learning.java.serialization;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.IOException;

public class DemoDeserializeXML {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("settings.xml");
        XMLDecoder xmlDecoder = new XMLDecoder(fileInputStream);
        XMLPOJO xmlpojo = (XMLPOJO) xmlDecoder.readObject();
        xmlDecoder.close();
        fileInputStream.close();

        System.out.println(xmlpojo.getFirstName());
        System.out.println(xmlpojo.getLastName());
        System.out.println(xmlpojo.getMiddleName());

    }
}
