package com.example.base64;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by aaron.korver.
 */
public class TestBase64 {

    //Lookie! No more importing

    @Test
    public void testBase64Encoding() throws UnsupportedEncodingException {
        String asB64 = Base64.getEncoder().encodeToString("some string".getBytes(StandardCharsets.UTF_8));
        System.out.println(asB64); // Output will be: c29tZSBzdHJpbmc=
        assertThat(asB64,is("c29tZSBzdHJpbmc="));

// Decode
        byte[] asBytes = Base64.getDecoder().decode("c29tZSBzdHJpbmc=");
        String decoded = new String(asBytes, StandardCharsets.UTF_8);
        System.out.println(decoded); // And the output is: some string
        assertThat(decoded, is("some string"));
    }

    @Test
    public void testBase64URLEncoding() throws UnsupportedEncodingException {
        String basicEncoded = Base64.getEncoder().encodeToString("subjects?abcd".getBytes(StandardCharsets.UTF_8));
        System.out.println("Using Basic Alphabet: " + basicEncoded);

        String urlEncoded = Base64.getUrlEncoder().encodeToString("subjects?abcd".getBytes(StandardCharsets.UTF_8));
        System.out.println("Using URL Alphabet: " + urlEncoded);
    }
}
