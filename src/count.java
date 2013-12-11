import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;



public class count {

       /**
       * @param args
       */
       public static void main(String[] args) {
              // TODO Auto-generated method stub
              String fn1 = "C:\\A\\test.txt";
              String fn2 = "C:\\A\\test1.txt";
              
              //count the time by using timeCount_1()
              long startTime1 = System.currentTimeMillis();
              System.out.println(timeCount_1(fileReader(fn1)));
              long endTime1 = System.currentTimeMillis();
             
              System.out.println(endTime1 - startTime1);
              
              System.out.println("------------------------------");
              
              //count the time by using timeCount_2()
              long startTime2 = System.currentTimeMillis();
              System.out.println(timeCount_2(fileReader(fn1)));
              long endTime2 = System.currentTimeMillis();
             
              System.out.println(endTime2 - startTime2);

              System.out.println("------------------------------");
              
              System.out.println(numberCount(fileReader(fn2)));
       }
       
       //Read a file and store the content to an Array List
       static List<String> fileReader(String fileName){
              
              
              //Read a file and store the content in a string array.
              File f = new File(fileName);
              BufferedReader reader = null;
              String tempString = null;
              List<String> fileContent = new ArrayList<String>();
              //String[] fileContent = null;
              //int i = 0;
              
              try {
                     reader = new BufferedReader(new FileReader(f));
                     while ((tempString = reader.readLine()) != null){
                  //while ((fileContent[i] = reader.readLine()) != null){
                           fileContent.add(tempString);
                      //i++;
                     }
                  reader.close();
              } catch (FileNotFoundException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              }
              finally{
                     if (reader != null){
                           try{
                                  reader.close();
                           }
                           catch(IOException e){
                                  e.printStackTrace();
                           }
                     }
              }
              
              return fileContent;
              
       }
       
       //1. Get the hour, minute, second from each time record. 
       //2. Sum hour, minute, second separately.
       //3. Update minute and second if it lager than 59.
       static String timeCount_1(List<String> Arr){
              int timeHH = 0;
              int timeMI = 0;
              int timeSS = 0;
              
              String r_hh = "";
              String r_mi = "";
              String r_ss = "";

              for(int i = 0; i < Arr.size(); i++ ){
                     
                     if (Pattern.matches("\\d{2}:\\d{2}:\\d{2}", Arr.get(i))){
                           
                           String[] s = Arr.get(i).split(":");
                           int hh = Integer.parseInt(s[0]);
                           int mi = Integer.parseInt(s[1]);
                           int ss = Integer.parseInt(s[2]);
                           
                           timeHH += hh;
                           timeMI += mi;
                           timeSS += ss;
                           
                     }
                     else{
                           continue;
                     }
              }
              
              timeMI += timeSS / 60;
              timeSS %= 60;
              
              timeHH += timeMI / 60;
              timeMI %= 60; 

              
              if (timeHH < 10){
                     r_hh = "0" + timeHH;
              }
              else{
                     r_hh = Integer.toString(timeHH);
              }
              
              if (timeMI < 10){
                     r_mi = "0" + timeMI;
              }
              else{
                     r_mi = Integer.toString(timeMI);
              }
              
              if (timeSS < 10){
                     r_ss = "0" + timeSS;
              }
              else{
                     r_ss = Integer.toString(timeSS);
              }
              
              
              
              String result = r_hh + ":" + r_mi + ":" + r_ss;
              //String result = timeHH + ":" + timeMI + ":" + timeSS;
              
              return result;
       }
       
       //1. Change each time record to second.
       //2. Sum them.
       //3. Change the total seconds back to hh:mi:ss format.
       static String timeCount_2(List<String> Arr){
           int timeHH = 0;
           int timeMI = 0;
           int timeSS = 0;
           
           int timeSum_second = 0;
           
           String r_hh = "";
           String r_mi = "";
           String r_ss = "";

           for(int i = 0; i < Arr.size(); i++ ){
                  
                  if (Pattern.matches("\\d{2}:\\d{2}:\\d{2}", Arr.get(i))){
                        
                        String[] s = Arr.get(i).split(":");
                        int hh = Integer.parseInt(s[0]);
                        int mi = Integer.parseInt(s[1]);
                        int ss = Integer.parseInt(s[2]);

                        timeSum_second += hh*60*60 + mi*60 + ss;
                        
                  }
                  else{
                        continue;
                  }
           }
           
           timeHH = timeSum_second/60/60;
           timeMI = (timeSum_second%(60*60))/60;
           timeSS = timeSum_second%60;
           
           if (timeHH < 10){
               r_hh = "0" + timeHH;
           }
           else{
               r_hh = Integer.toString(timeHH);
           }
        
           if (timeMI < 10){
               r_mi = "0" + timeMI;
           }
           else{
               r_mi = Integer.toString(timeMI);
           }
        
           if (timeSS < 10){
               r_ss = "0" + timeSS;
           }
           else{
               r_ss = Integer.toString(timeSS);
           }
           
           String result = r_hh + ":" + r_mi + ":" + r_ss;
           
           return result;
       }
       
       //Sum all items in the file.
       static double numberCount(List<String> Arr){
                   
                   double sum = 0.0;
                   
                   for(int i = 0; i < Arr.size(); i++ ){
                                   
                                   sum += Double.parseDouble(Arr.get(i));
                                   
           }
                   
                   return sum;
                   
       }
}

