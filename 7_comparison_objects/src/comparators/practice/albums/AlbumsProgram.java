package comparators.practice.albums;

import comparators.practice.helpers.Console;

/**
 * Print and sort greatest record albums.
 */
public class AlbumsProgram
{
    //some test objects to sort
    private static Album[] albums = {
        new Album("Marvin Gaye, What's Going On", 1971, 35.38, true),
        new Album("The Beach Boys, Pet Sounds", 1966, 35.57, true),
        new Album("The Beach Boys, Smile", 1971, 48.24, false),
        new Album("Nirvana, Nevermind", 1991, 42.38, true),
        new Album("The Who, The Rock Opera Lifehouse", 1971, 85.87, false),
        new Album("The Beatles, Revolver", 1966, 35.01, true),
        new Album("Michael Jackson, Thriller", 1982, 42.19, true)
    };

    public static void main(String[] args)
    {
        int choice = -1;
        while (choice != 6)
        {
            choice = menu();
            menuAction(choice);
        }
    }

    private static int menu()
    {
        //show the menu
        System.out.println("1. Show albums");
        System.out.println("2. Sort by title (ASC)");
        System.out.println("3. Sort by year (DESC)");
        System.out.println("4. Sort by minutes (ASC)");
        System.out.println("5. Sort by completed");
        System.out.println("6. Exit");

        //get a user choice
        int choice = Console.getInt();
        System.out.println();
        return choice;
    }

    private static void menuAction(int choice)
    {
        switch(choice)
        {
            case 1:
                printAlbums();
                break;
            case 2:
                //sort albums...
                break;
            case 3:
                //sort albums...
                break;
            case 4:
                //sort albums...
                break;
            case 5:
                //sort albums...
                break;
        }
    }

    private static void printAlbums()
    {
        for (Album album : albums)
        {
            System.out.println(album);
        }
        System.out.println();
    }
}
