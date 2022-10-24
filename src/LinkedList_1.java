import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedList_1
{
    static LinkedList<LinkedList> listOlists = new LinkedList<>();
    static ArrayList<String> CDs = new ArrayList<>();
    static LinkedList<String> names = new LinkedList<>();
    static LinkedList<String> albums = new LinkedList<>();
    static LinkedList<String> genres = new LinkedList<>();
    static LinkedList<Integer> years  = new LinkedList<>();
    static Scanner in = new Scanner(System.in);

    static int opt = 0;

    public static void main(String[] args) throws IOException
    {

        listOlists.add(names);
        listOlists.add(albums);
        listOlists.add(genres);
        listOlists.add(years);

        names.add("Red");
        albums.add("Innocence & Instinct");
        genres.add("2");
        years.add(2009);

        while(opt != 3)
        {
            ReadFile("Options");

            Scanner option = new Scanner(System.in);
            opt = option.nextInt();

            switch ( opt )
            {
                case 1 -> addCD();
                case 2 -> outputLList(listOlists);
                //case 3 -> ;
            }
        }

        // ReadFile("test"); <- WORKS BUT IS UNNEEDED RN

    }

    private static void addCD()
    {
        System.out.println();
        System.out.println("Enter a CD into the Organizer: ");

        System.out.print("Artist: ");
        String name = in.nextLine();
        names.add(name);

        System.out.print("Album: ");
        String album = in.nextLine();
        albums.add(album);

        System.out.print("Genre: ");
        String genre = in.nextLine();
        genres.add(genre);

        System.out.print("Year: ");
        int year = in.nextInt();
        years.add(year);

        System.out.println();

    }

    private static void WriteFile(String filename, String toWrite) throws IOException
    {
        FileWriter myWriter = new FileWriter(filename+".txt",true);
        myWriter.write(toWrite + '\n');
        myWriter.close();

    }

    private static void ReadFile(String filename) throws IOException
    {
        Scanner myReader = new Scanner(new File(filename+".txt"));
        while(myReader.hasNextLine())
        {
            System.out.println(myReader.nextLine());
        }
    }

    private static void clearFile(String filename) throws IOException
    {
        FileWriter myWriter = new FileWriter(filename+".txt");
        myWriter.write("");
        myWriter.close();

    }

    private static void outputLList(LinkedList<LinkedList> list) throws IOException
    {
        ArrayList<Object> temp = new ArrayList<>();
        ArrayList<Object> CDList = new ArrayList<>();

        for(int i = 0; i < list.get(i).size(); i++)
        {
            for(int j = 0; j < 4; j++)
            {
                temp.add( list.get(j).get(i));
            }
        }

        for(int i = 0; i < temp.size(); i+=4)
        {
            StringBuilder str = new StringBuilder();

            for(int n = 0; n < 4; n++)
            {
                if(n < 3)
                {
                    str.append(temp.get(i + n)).append(" ");
                }
                else
                {
                    str.append(temp.get(i+n));
                }
            }

            CDList.add(str);

        }

        clearFile("test");
        System.out.println();
        System.out.println("CD List: ");
        for ( Object o : CDList )
        {
            WriteFile("test", o.toString());
            System.out.println(o);
        }
        System.out.println();

    }

}

