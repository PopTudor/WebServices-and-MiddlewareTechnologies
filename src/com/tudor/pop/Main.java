package com.tudor.pop;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here
        if (args.length < 1)
            throw new IllegalArgumentException("Trebuie introdus numele fisierului");

        File source = new File(args[0]);
        File out = new File(source.getName().replace(".txt", "_reversed.txt"));
        Reader reader = new InputStreamReader(new FileInputStream(source));
        BufferedWriter writer = new BufferedWriter(new FileWriter(out));
        RandomAccessFile randomAccessFile = new RandomAccessFile(out, "rw");
        randomAccessFile.setLength(source.length());
        char[] buff = new char[1];
        // keep track of the current position (we're going backwards, so we start at the end)
        long position = source.length();
        // Reader.read will return -1 when it reached the end.
        while ((reader.read(buff)) > -1) {
            // turn the character into bytes according to the character encoding
            String s = String.valueOf(buff[0]);
            // go to the proper position in the random access file
            position--;
            randomAccessFile.seek(position);

            // write one or more bytes for the character
            randomAccessFile.write(s.getBytes());
        }

        randomAccessFile.close();
        writer.close();
    }
}
