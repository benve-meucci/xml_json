package com.example;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Alunno a = new Alunno("Claudio", "Benvenuti", new Date(1979,9,22));
        XmlMapper xmlMapper = new XmlMapper();
        String s1 = xmlMapper.writeValueAsString(a);
        System.out.println(s1);

        xmlMapper.writeValue(new File("test.xml"), a);

        Alunno b = xmlMapper.readValue(new File("test.xml"), Alunno.class);
        System.out.println(b.cognome);
        System.out.println(b.nome);

        System.out.println("---------------------");


        ObjectMapper objectMapper = new ObjectMapper();
        String s2 = objectMapper.writeValueAsString(a);
        System.out.println(s2);

        objectMapper.writeValue(new File("test.json"), a);

        Alunno c = objectMapper.readValue(new File("test.json"), Alunno.class);
        System.out.println(c.cognome);
        System.out.println(c.nome);



    }
}

