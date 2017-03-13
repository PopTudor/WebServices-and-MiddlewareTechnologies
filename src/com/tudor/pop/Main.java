package com.tudor.pop;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// write your code here
		if (args.length < 1)
			throw new IllegalArgumentException("Trebuie introdus numele fisierului");

		File source = new File(args[0]);
		File out = new File("java_reversed.txt");

		RandomAccessFile reader = new RandomAccessFile(source,"r");
		RandomAccessFile writer = new RandomAccessFile(out, "rw");
		writer.getChannel().truncate(0);
		// mentine pozitia unde o sa scriem datele in fisier, pornind de la coada la cap
		long position = source.length();
		byte[] buff = new byte[1];
		// readline returneaza null cand a ajuns la final
		for (int line = reader.read(buff, 0, buff.length); line != -1; line = reader.read(buff, 0, buff.length)) {
			position--;
			writer.seek(position);
			// scrie rezultatul
			writer.write(buff,0,buff.length);
		}
		writer.close();
		reader.close();
	}
}