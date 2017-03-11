package com.tudor.pop;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here
        if (args.length < 1)
            throw new IllegalArgumentException("Trebuie introdus numele fisierului");

        File source = new File(args[0]);
        File out = new File(source.getName().replace(".txt", "_reversed.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(source)));
        RandomAccessFile randomAccessFile = new RandomAccessFile(out, "rw");
        // keep track of the current position (we're going backwards, so we start at the end)
        long position = source.length();
        // Reader.read will return -1 when it reached the end.
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            StringBuilder stringBuffer = new StringBuilder(line);
            String reversed = stringBuffer.reverse().toString()+"\n";
            position -= reversed.length(); // \r\n is only one newline character
            // turn the character into bytes according to the character encoding
            // go to the proper position in the random access file
            randomAccessFile.seek(position);

            // write one or more bytes for the character
            randomAccessFile.writeUTF(reversed);
        }

        randomAccessFile.close();
        reader.close();
    }
}
