package dev.scotthammer.advent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;

public class TestUtil {
    public static URL getClasspathResource(String resourcePath) {
        return ClassLoader.getSystemClassLoader().getResource(resourcePath);
    }

    @SuppressWarnings("unused")
    private static BufferedReader getBufferedReader(URL url) throws FileNotFoundException {
        assert url != null;
        return new BufferedReader(new FileReader(url.getFile()));
    }

    public static BufferedReader getBufferedReader(String resourcePath) throws FileNotFoundException {
        URL url = getClasspathResource(resourcePath);
        return new BufferedReader(new FileReader(url.getFile()));
    }
}
