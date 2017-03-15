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
        FileStream dest = File.OpenWrite("C#"+new Random().Next(0,100)+"_reverse.txt");
        dest.SetLength(0);

        dest.Seek(1,SeekOrigin.Begin);
        dest.WriteByte(Convert.ToByte('d'));
        dest.Seek(0, SeekOrigin.Begin);
        dest.WriteByte(Convert.ToByte('e'));

        long position = source.Length;
        for (int  octet = source.ReadByte(); octet != -1; octet = source.ReadByte())
        {
            position--;
            dest.Seek(position, SeekOrigin.Begin);
            dest.WriteByte((byte)octet);
        }
        source.Dispose();
        dest.Dispose();
    }
}
