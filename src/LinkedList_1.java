import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedList_1
{
    static LinkedList<LinkedList> MasterList = new LinkedList<>();
    static LinkedList<String> names = new LinkedList<>();   //List of all names
    static LinkedList<String> albums = new LinkedList<>();  //List of all albums
    static LinkedList<String> genres = new LinkedList<>();  //List of all genres
    static LinkedList<Integer> years = new LinkedList<>();  //List of all years
    static Scanner in = new Scanner( System.in );           //General scanner (since I have a thousand scanners used)
    
    static int opt = 0;
    
    public static void main( String[] args ) throws IOException
    {
        //Add the LinkedLists to the MasterList
        MasterList.add( names );
        MasterList.add( albums );
        MasterList.add( genres );
        MasterList.add( years );
        
        //Preload a CD for testing
        names.add( "Red" );
        albums.add( "Innocence & Instinct" );
        genres.add( "2" );
        years.add( 2009 );
        
        //While the user doesn't select the "Exit" option
        while ( opt != 3 )
        {
            ReadFile( "Options" );                             //Output the available options
            Scanner option = new Scanner( System.in );                //Select the option number
            opt = option.nextInt();
            
            switch ( opt )                                            //Switch statement to handle the current cases
            {                                                         //(will have more than 2 later)
                
                case 1 -> addCD();                                    //Add a CD to the MasterList
                case 2 -> outputLList( MasterList );                  //Show the CD's in the MasterList
                
            }
        }
        
        // ReadFile("test"); <- WORKS BUT IS UNNEEDED RN
        
    }
    
    private static void addCD()
    {
        System.out.println();
        System.out.println( "Enter a CD into the Organizer: " );
        
        System.out.print( "Artist: " );   //Get artist
        String name = in.nextLine();      // <- error occurs here (only on second run through of while loop in main)
        names.add( name );                // Error is that after the initial run, names is always = ""
        
        System.out.print( "Album: " );    //Get album
        String album = in.nextLine();
        albums.add( album );              //Add to album list
        
        System.out.print( "Genre: " );    //Get genre
        String genre = in.nextLine();
        genres.add( genre );              //Add to genre list
        
        System.out.print( "Year: " );     //Get year
        int year = in.nextInt();
        years.add( year );                //Add to year list
        
        System.out.println();             //Give extra space
        
    }
    
    private static void WriteFile( String filename, String toWrite ) throws IOException
    {
        FileWriter myWriter = new FileWriter( filename + ".txt", true );
        myWriter.write( toWrite + '\n' );
        myWriter.close();
        
    }
    
    private static void ReadFile( String filename ) throws IOException
    {
        Scanner myReader = new Scanner( new File( filename + ".txt" ) );
        while ( myReader.hasNextLine() )
        {
            System.out.println( myReader.nextLine() );
        }
    }
    
    private static void clearFile( String filename ) throws IOException
    {
        FileWriter myWriter = new FileWriter( filename + ".txt" );
        myWriter.write( "" );
        myWriter.close();
        
    }
    
    private static void outputLList( LinkedList<LinkedList> list ) throws IOException
    {
        ArrayList<Object> temp = new ArrayList<>();                 //Add in a temporary ArrList for switching
        ArrayList<Object> CDList = new ArrayList<>();               //Add in permanent ArrList (post switch)
        
        for ( int i = 0; i < list.get( i ).size(); i++ )            //For however long the list at list i in
            {                                                       // MasterList
            for ( int j = 0; j < 4; j++ )                           //For all 4 lists in the MasterList
            {
                temp.add( list.get( j ).get( i ) );                 //Get the ith value from each jth list and
            }                                                       // add to temp
        }
        
        for ( int i = 0; i < temp.size(); i += 4 )                  //For as long as temp was, break into 4s
        {
            StringBuilder str = new StringBuilder();                //Declare a new StringBuilder str
            
            for ( int n = 0; n < 4; n++ )                           //For the four indexes (including curr) that come
            {                                                       //after i
                if ( n < 3 )                                        //For the first 3 indexes
                {
                    str.append( temp.get( i + n ) ).append( " " );  //Add the value of temp at that location
                }                                                   // and a space
                else                                                //For the final index, just the value, no space
                {
                    str.append( temp.get( i + n ) );
                }
            }
            
            CDList.add( str );                                      //Add the final string to the final ArrList
            
        }
        
        clearFile( "test" );                                        //Empty the current list of CDs
        System.out.println();                                       //Add spacing for ~AESTHETIC~
        System.out.println( "CD List: " );
        for ( Object o : CDList )                                   //For each element in the final ArrList
        {
            WriteFile( "test", o.toString() );                      //Add to the list of CDs
            System.out.println( o );                                //Output the CDs
        }
        
        System.out.println();                                       //More aesthetically pleasing spacing
        
    }
    
}
