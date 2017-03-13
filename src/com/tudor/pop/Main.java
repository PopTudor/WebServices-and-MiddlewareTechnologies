package com.tudor.pop;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// write your code here
		if (args.length < 1)
			throw new IllegalArgumentException("Trebuie introdus numele fisierului");

		File source = new File(args[0]);
		File out = new File("java_reversed.txt");

		Reader reader = new FileReader(source);
		RandomAccessFile writer = new RandomAccessFile(out, "rw");
		writer.getChannel().truncate(0);
		// mentine pozitia unde o sa scriem datele in fisier, pornind de la coada la cap
		long position = source.length();
		// readline returneaza null cand a ajuns la final
		for (int character = reader.read(); character != -1; character = reader.read()) {
			position--;
			writer.seek(position);
			// pe windows linia noua este \r\n dar asa se pun doua line breaks in fisier
			// de aceea o sa inlocuim \n cu ' '
			if (character == '\n') character = ' ';
			// scrie rezultatul
			writer.write(character);
		}
		writer.close();
		reader.close();
	}
}