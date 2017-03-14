package com.tudor.pop;

import java.io.*;
import java.util.Random;

public class Main {
	public static void main(String[] args) throws IOException {
		// write your code here
		if (args.length < 1)
			throw new IllegalArgumentException("Trebuie introdus numele fisierului");

		File source = new File(args[0]);
		File out = new File("java" + new Random().nextInt(100) + "_reversed.txt");

		FileInputStream reader = new FileInputStream(source);
		RandomAccessFile writer = new RandomAccessFile(out, "rw");
		writer.getChannel().truncate(0);
		// mentine pozitia unde o sa scriem datele in fisier, pornind de la coada la cap
		long position = source.length();
		// readline returneaza null cand a ajuns la final
		for (int octet = reader.read(); octet != -1; octet = reader.read()) {
			position--;
			writer.seek(position);
			// scrie rezultatul
			writer.write(octet);
		}
		writer.close();
		reader.close();
	}
}