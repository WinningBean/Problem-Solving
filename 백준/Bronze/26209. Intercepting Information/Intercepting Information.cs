using System;

class Program
{
    static void Main(string[] args)
    {
        int[] input = Array.ConvertAll(Console.ReadLine().Split(' '), int.Parse);
        char answer = 'S';

        foreach (int num in input)
        {
            if (num == 9)
            {
                answer = 'F';
                break;
            }
        }

        Console.WriteLine(answer);
    }
}