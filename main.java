import java.util.*;  
import java.io.*;
public class Main{
        public static void main(String[] args) {
                Scanner s = new Scanner(System.in);

                //Creating new hash file
		//Create a file as "input.txt" to retrive input from buffer reader
                HashMap<Integer, String> hm = new HashMap<Integer, String>();
                try{
                        File file = new File("input.txt"); 
                        BufferedReader br = new BufferedReader(new FileReader(file)); 
                        String st;
                        try{ 
                                while ((st = br.readLine()) != null) {
                                        String[] str = st.split(":");
                                        if(str.length != 1){
                                                int a = Integer.parseInt(str[1].substring(1));
                                                hm.put(a, str[0]);
                                        }
                                }
                        }catch(IOException e){System.out.println("Exception 1");}
                }catch(FileNotFoundException e){System.out.println("Exception");}

		 // Take input as no of employees from the user

                System.out.print("Number of the Employees:");
                int num = s.nextInt();
                ArrayList<Integer> al = new ArrayList<Integer>();
                for(int a : hm.keySet()){
                        al.add(a);
                }

		// sort the array of goodies

                Collections.sort(al);
                int min = -1, max = -1;
                int mindiff = 9999999;
		//get the difference of the high and low goodies
                for(int i = 0;i < 10;i++){
                        int j = i + num - 1;
                        if(j >= 10)
                                break;
                        int diff = al.get(j) - al.get(i);
                        if(diff <= mindiff){
                               
                                mindiff = diff;
                                min = i;
                                max = j;
                               
                        }
                }
                ArrayList<Integer> al2 = new ArrayList<Integer>();
                for(int i = min;i <= max;i++){
                        al2.add(al.get(i));
                }
		// Create an output file 
                Integer[] array = new Integer[al2.size()]; 
                array = al2.toArray(array); 
                try{
                        PrintWriter out = new PrintWriter("output.txt");
                        out.println("Here the goodies that are selected for distirbution are :");
                        for(int i = 0;i < array.length;i++){
                                out.println(hm.get(array[i])+":"+array[i]);
                                     
                        }
			//print the difference between the goodies choosen with highest and lowest price as output 
                        out.println("And the difference between the chosen goodies with highest price and the lowest price is : "+mindiff);
                        out.close();
                }catch(FileNotFoundException e){System.out.println(e);}
        }
}