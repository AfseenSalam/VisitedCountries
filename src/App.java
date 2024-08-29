
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int i = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Visited Countries");
        System.out.println("Please make a selection ");
        ArrayList<String> visitors = new ArrayList<>(List.of("Tommy", "Yumi", "Sahara"));
        ArrayList<HashSet<String>> places = new ArrayList<>();
        places.add(new HashSet<>(List.of("France", "India", "Canada")));
        places.add(new HashSet<>(List.of("France", "Canada")));
        places.add(new HashSet<>(List.of("France", "Dubai")));
        
        boolean isValid =true;
        while(isValid){
            System.out.println(i + " Search for people who visited a country");
        System.out.println(i + 1 + " Add a country to a person's set of visited countries ");
        System.out.println(i + 2 + " List the countries a person has visited");
        System.out.println(i + 3 + " Quit");
        int userChoice = sc.nextInt();
        sc.nextLine();
        if (userChoice == 1){
            System.out.println("What country would you like to search for?");
            String country = sc.nextLine();
            System.out.println("The following people have visited "+ country);
            ListOfPeoples(country, visitors, places);
            

        }
        else if(userChoice == 2){
            System.out.println("Who would you like to add a country to?");
            String user = sc.nextLine();
            System.out.println("What country would you like to add for this person?");
            String country = sc.nextLine();
            AddingNewCountry(user, country, visitors, places);
            
        }

       else if (userChoice == 3) {
            System.out.println("Who would you like to see the countries they've visited?");
            String user = sc.nextLine();
            System.out.println(user + " has visited these countries: ");
            visitedCountry(user, visitors, places);
            
        }else if(userChoice == 4){
            System.out.println("Thank you and goodbye!");
            isValid =false;
            break;
        }else{
            System.out.println("Invalid Input");
            isValid = true;
            continue;
        }
        
        }
       
    }

    public static void visitedCountry(String s,ArrayList<String> visitors, ArrayList<HashSet<String>> places){
       int index = visitors.indexOf(s);
        if(index == -1 || index >=4 ){
        System.out.println(s+" is not existing in list");
        }else{
            HashSet<String> listPlaces = places.get(index);
        
        for (String c : listPlaces) {
            System.out.println(c);
        }

        }
        
    }
    public static void ListOfPeoples(String s,ArrayList<String> visitors, ArrayList<HashSet<String>> places){
        String targetClass =s;
        for(int i=0;i<places.size();i++){
           HashSet<String> currentClasses = places.get(i);
           if(currentClasses.contains(targetClass)){
            System.out.println(visitors.get(i));
           }

        }
    }
    public static void AddingNewCountry(String s,String c, ArrayList<String> visitors, ArrayList<HashSet<String>> places){
        int index = visitors.indexOf(s);
        if(index == -1 || index >=4 ){
            System.out.println(s+" is not existing in list");
            }else{
                places.get(index).add(c);
                System.out.println(c+" has been added for "+s);

            }
        

    }

}