import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Student{
    public static void main(String[] args)  throws Exception{
        System.out.println("Viva Management");
        System.out.print("Enter your name: ");
        try (Scanner sc = new Scanner(System.in)) {
            String name = sc.nextLine();
            System.out.print("Enter your IUKL ID: ");
            String iuklId = sc.nextLine();

            int[] inputOptions = new int[10];
            showMcq(inputOptions); // showMcq method displays the MCQs and receive answers from the user.
            int[] answers = new int[10];
            answerArray(answers); // answerArray method to retrieve the correct answers.
            //checking
            int score = 0;
            for(int i=0;i<answers.length;i++){
                if((answers[i] == inputOptions[i]) && inputOptions[i] !=0) {
                    score+=1;
                }
            }
            System.out.println("Your score: " + score +"/10");
            saveResult(name, iuklId, score); //saveResult method  saves the user's name, IUKL ID, and score to a file.
        }
    }

    public static void showMcq(int[] inputOptions) throws Exception{
        int i=0;
        //path of mcqs
        String filePath = "C://Users/chira/IdeaProjects/(OOP )Viva Management System - Chiranjibi/src/Questions";
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String lines;
        int j=0;
        while((lines=br.readLine())!=null){
            //asking input in each 4 lines
            System.out.println(lines);
            i++;
            if(i%4==0){
                System.out.print("Enter options:");
                Scanner sc = new Scanner(System.in);
                try{
                    inputOptions[j] = sc.nextInt();
                }catch (Exception e){
                    System.out.println("Value Error!");
                }
                j++;
            }
        }
    }

    //answers file
    public static void answerArray(int[] answers) {
        //path of answers
        String filePath = "C://Users/chira/IdeaProjects/(OOP )Viva Management System - Chiranjibi/src/Answers";
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String lines;
        int i=0;
        while((lines=br.readLine())!=null){
            answers[i] = Integer.parseInt(lines);
            i++;
        }
    }

    //save result to file
    public static void saveResult(String name, String iuklId, int score) throws Exception{
        //path of result
        String filePath = "C://Users/chira/IdeaProjects/(OOP )Viva Management System - Chiranjibi/src/Result";
        FileWriter fw = new FileWriter(filePath, true);
        fw.write(name + "," + iuklId + "," + score + "\n");
        fw.close();
        System.out.println("Finished !");
    }
}