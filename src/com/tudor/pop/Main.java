package com.tudor.pop;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here
        if (args.length < 1)
            throw new IllegalArgumentException("Trebuie introdus numele fisierului");

        File source = new File(args[0]);
        File out = new File("java_reversed.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(source)));
        RandomAccessFile writer = new RandomAccessFile(out, "rw");
        writer.getChannel().truncate(0);
        // mentine pozitia unde o sa scriem datele in fisier, pornind de la coada la cap
        long position = source.length();
        // readline returneaza null cand a ajuns la final
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            String rLine = new StringBuilder(line).reverse().append("\n").toString();

            // mergi la pozitia corecta in fisier
            position -= rLine.length();
            writer.seek(position);

            // scrie rezultatul
            writer.write(rLine.getBytes("UTF-8"));
        }
        writer.close();
        reader.close();
    }
}