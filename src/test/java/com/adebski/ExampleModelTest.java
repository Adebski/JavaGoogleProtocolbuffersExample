package com.adebski;

import com.google.protobuf.TextFormat;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExampleModelTest {

    @Test
    public void testBasicOperations() throws IOException {
        // Using generated builders to create instances of classes defined in the .protoc file
        ExampleProtoc.AccountDetails accountDetails =
                ExampleProtoc.AccountDetails.newBuilder()
                        .setId("someId")
                        .setAccountType(ExampleProtoc.AccountType.PROFESSIONAL)
                        .build();
        ExampleProtoc.Person person =
                ExampleProtoc.Person.newBuilder()
                        .setName("someName")
                        .setSurname("someSurname")
                        .setEmail("some_email@foo.bar")
                        .addAccounts(accountDetails)
                        .build();

        // Taking advantage of the auto generated toString() methods
        System.out.println("AccountDetails toString() result:");
        System.out.println(accountDetails);

        System.out.println("Person toString() result:");
        System.out.println(person);

        // Serializing using binary/compact encoding
        ByteArrayOutputStream personAsBytesStream =
                new ByteArrayOutputStream();
        person.writeTo(personAsBytesStream);
        byte[] personAsBytes = personAsBytesStream.toByteArray();

        System.out.println(
                String.format(
                        "Serialized Person object using binary encoder takes %d bytes in memory:",
                        personAsBytes.length));
        for (byte b : personAsBytes) {
            System.out.print(String.format("%02x", b));
        }
        System.out.println();
        System.out.println("original.equals(deserialized): " + ExampleProtoc.Person.parseFrom(personAsBytes).equals(person));

        // Serializing using human readable TextFormat encoding
        System.out.println();
        String personAsTextFormat = TextFormat.printer().printToString(person);
        System.out.println(
                String.format(
                        "Serialized Person object using TextFormat encoder takes %d bytes in memory",
                        personAsTextFormat.length()));
        System.out.println(personAsTextFormat);
        System.out.println("original.equals(deserialized): " + TextFormat.parse(personAsTextFormat, ExampleProtoc.Person.class).equals(person));
    }

    @Test(expected = TextFormat.ParseException.class)
    public void parseInvalidTextFormat() throws IOException {
        try {
            String exampleConfiguration =
                Files.readString(Paths.get("./example-person-invalid.proto"));

            TextFormat.parse(exampleConfiguration, ExampleProtoc.Person.class);
        } catch (TextFormat.ParseException e) {
            System.out.println(e);
            throw e;
        }

    }
}
