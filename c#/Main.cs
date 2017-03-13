using System;
using System.Text;
using System.IO;

class TestClass
{
    static void Main(string[] args)
    {
        if (args.Length < 1)
            throw new System.ArgumentException("Trebuie introdus numele fisierului");
        FileStream source = File.OpenRead(args[0]);
        FileStream dest = File.OpenWrite("C#_reverse.txt");
        dest.SetLength(0);

        dest.Seek(1,SeekOrigin.Begin);
        dest.WriteByte(Convert.ToByte('d'));
        dest.Seek(0, SeekOrigin.Begin);
        dest.WriteByte(Convert.ToByte('e'));

        long position = source.Length;
        for (int  line = source.ReadByte(); line != -1; line = source.ReadByte())
        {
            position--;
            if(line=='\n') line = ' ';
            dest.Seek(position, SeekOrigin.Begin);
            dest.WriteByte((byte)line);
        }
        source.Dispose();
        dest.Dispose();
    }
}
