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
        StreamReader reader = new StreamReader(source);
        StreamWriter writer = new StreamWriter(dest);

        reader.BaseStream.Seek(0, SeekOrigin.Begin);
        dest.Write( Encoding.ASCII.GetBytes("asd"),0,3);
        dest.Seek(0, SeekOrigin.Begin);
        dest.Write(Encoding.ASCII.GetBytes("\r\n"),0,"\r\n".Length);
    
        // long position = source.Length;
        // for (int line = reader.Read(); line != -1; line = reader.Read())
        // {
        //     // line = ReverseString(line);
        //     // position -= line.Length;
        //     position--;
        //     writer.BaseStream.Seek(position, SeekOrigin.Begin);
        //     writer.Write(Convert.ToChar(line));
        // }
        writer.Flush();
        reader.Dispose();
        writer.Dispose();
    }
    public static string ReverseString(string sz)
    {
        var builder = new StringBuilder(sz.Length);
        for (int i = sz.Length - 1; i >= 0; i--)
        {
            builder.Append(sz[i]);
        }
        return builder.ToString();
    }
}
