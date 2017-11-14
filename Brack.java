import java.util.Scanner;

class Brack{

    private static char [][] table = new char [3][3];
    
    // define possibleInput as an array of the allowable inputs for this program
    static char [] possibleInput = new char [] {'A', 'B', 'C'};
    
    // u is the length of possibleInput, go from 0 to 2
    static int u = possibleInput.length;
        
    public static void main(String [] args){
        
        table[0][0]='B'; table[0][1]='B'; table[0][2]='A';
        table[1][0]='C'; table[1][1]='B'; table[1][2]='A';
        table[2][0]='A'; table[2][1]='C'; table[2][2]='C';
        
        
        Scanner scanner = new Scanner(System.in);
        
        char [] input;
        
        System.out.println("Give an input word please");
        
        while(true){
            
            input = scanner.next().toCharArray();
        
            boolean ok = true;
            
            for(int i = 0; i<input.length; i++){
        
                if(input[i]!='A' && input[i]!='B'&& input[i]!='C'){
                    ok=false;
                    break;
                }
            }
            if(ok == true)
                break;
                System.out.println("A new word please: ");
        }
        
        System.out.println();
        System.out.println("Excellent!");
        System.out.println();

        System.out.println("Which Task?");
        
        int taskNumber = scanner.nextInt();
        
        if(taskNumber==1){
            
            System.out.println("Start Position?");

            int startPosition = scanner.nextInt();
            
            System.out.println("End Position?");
            
            int endPosition = scanner.nextInt();
            
            System.out.println("Target Symbol?");
            
            char target = scanner.next().charAt(0);
            
            System.out.println();
            System.out.println("The output is:");
            
            System.out.println(possibleRec(input,startPosition,endPosition,target));
        }
        
        if(taskNumber==2){
            
            System.out.println("Start Position?");
            
            int startPosition = scanner.nextInt();
            
            System.out.println("End Position?");
            
            int endPosition = scanner.nextInt();
            
            System.out.println("Target Symbol?");
            
            char target = scanner.next().charAt(0);
            
            System.out.println();
            System.out.println("The output is:");
            

            
            System.out.println(numberRec(input,startPosition,endPosition,target));
            

       }
     
    
        if(taskNumber==3){
            
            System.out.println("Start Position?");
            
            int startPosition = scanner.nextInt();
            
            System.out.println("End Position?");
            
            int endPosition = scanner.nextInt();
            
            System.out.println("Target Symbol?");
            
            char target = scanner.next().charAt(0);
            
            System.out.println();
            System.out.println("The output is:");
       }
        
        if(taskNumber==4){
            
            System.out.println("Start Position?");
            
            int startPosition = scanner.nextInt();
            
            System.out.println("End Position?");
            
            int endPosition = scanner.nextInt();
            
            System.out.println("Target Symbol?");
            
            char target = scanner.next().charAt(0);
            
            System.out.println();
            System.out.println("The output is:");
            
            System.out.println(possibleDynamic(input,startPosition,endPosition,target));
       }
        
        if(taskNumber==5){
            
            System.out.println("Start Position?");
            
            int startPosition = scanner.nextInt();
            
            System.out.println("End Position?");
            
            int endPosition = scanner.nextInt();
            
            System.out.println("Target Symbol?");
            
            char target = scanner.next().charAt(0);
            
            System.out.println();
            System.out.println("The output is:");
            
            long startTime = System.currentTimeMillis();
            
            System.out.println(numberDynamic(input,startPosition,endPosition,target));   
            
            long endTime = System.currentTimeMillis();
            long estimatedTime = endTime - startTime;
            
            System.out.println("Estimated time is " + estimatedTime + " ms.");
        }
        
        if(taskNumber==6){
            
            System.out.println("Start Position?");
            
            int startPosition = scanner.nextInt();
            
            System.out.println("End Position?");
            
            int endPosition = scanner.nextInt();
            
            System.out.println("Target Symbol?");
            
            char target = scanner.next().charAt(0);
            
            System.out.println();
            System.out.println("The output is:");
        }
}
    
    /* Task 1 */
    
    /* possibleRec - determine if there is a bracketing of w[i...j]
        evaluating to z, using recursion */
        
    
    static boolean possibleRec(char [] w, int i, int j, char z){
        
            
        //base case 1, when i = j, return true if w[i] matches the target
        if ((i == j) && (w[i] == z)){
            return true;
        }
        
        //base case 2, when i = j, return false if w[i] doesn't match the target
        if ((i == j) && w[i] != z){
            return false;
        }
        
        //loop over all possible ways to split the string in two
        for (int k = i; k < j; k++) {
            //for each loop, find all the multiplications within the multiplication table that yield z
            for (int j1 = 0; j1 < u; j1++) {
                for (int j2 = 0; j2 < u; j2++) {
                    if (table[j1][j2] == z) {
                        //check if it is possible to get j1 and j2 from the input string to gain target z
                        if ((possibleRec(w, i, k, possibleInput[j1]) == true) && (possibleRec(w, k + 1, j, possibleInput[j2]) == true)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
        }

                                 
    /* Task 2 */
    
    /* numberRec - determine the number of bracketings of w[i...j]
         evaluating to z, using recursion */
    
    static int numberRec(char [] w, int i, int j, char z){
        
        //initialize the number of ways to bracket w[i...j) to 0
        int count = 0;
        
        //if i = j, there is 1 way to bracket w if w[i] matches the target
        if ((i == j) && (w[i] == z)){
            return 1;
        }
        
        //if i = j, there is 0 way to bracket w if w[i] doesn't match the target
        if ((i == j) && (w[i] != z)){
            return 0;
        }
        
        //loop over all possible ways to split the array in two
        for (int k = i; k < j; k++){
            //for each loop, find all the multiplication within the multiplication table that yields z
            for (int j1 = 0; j1 < u; j1++){
                for (int j2 = 0; j2 < u; j2++){
                    if (table[j1][j2] == z){
                            count += numberRec(w, i, k, possibleInput[j1]) * numberRec(w, k + 1, j, possibleInput[j2]);
                    }
                }
            }
        }
        
        return count;
    }
    
                        
                            
    /* Task 4 */
    
    /* possibleDynamic - determine if there is a bracketing of w[i...j]
     evaluating to z, using dynamic programming */
    
    static boolean possibleDynamic(char [] w, int i, int j, char z){
        
        // define n as length of w[i...j)
        int n = j - i + 1;
        
        // initialize the integer that will be used as numerical representations of A, B, and C to -1
        int r = -1;
        
        // use integers 0, 1, and 2 as numerical representations of inputs A, B and C
        if (z == 'A'){
            r = 0;
        }
        
        if (z == 'B'){
            r = 1;
        }
        
        if (z == 'C'){
            r = 2;
        }
        
        // initialize a boolean array of dimension 30x30x3
        boolean [][][] poss = new boolean [30][30][3];
        
        // examine array of length 1, where i == j, which fills in the diagonal cells of the table
        for (int s = i; s < n; s++){
            for (int v = 0; v < u; v++){
                if (w[s] == possibleInput[v]){
                    poss[s][s][v] = true;
                }
            }
        }
        
        // begin to fill up the rest of the table, each new cell returns true if the cell
        // to the left and below it returns true
        
        //subSize is defined as the size of each sub-problem
        for (int subSize = 1; subSize < n; subSize++){
            //subLeft is defined as where the left end of the sub-problem starts
            for (int subLeft = i; subLeft < n - subSize; subLeft++){
                //subPartition is defined as the different ways each sub-problem can be broken up
                for (int subPartition = subLeft; subPartition < subLeft + subSize; subPartition++){
                    //k, j1, j2 are used to loop through the multiplication table
                    for (int k = 0; k < u; k++){
                        for (int j1 = 0; j1 < u; j1++){
                            for (int j2 = 0; j2 < u; j2++){
                                if (table[j1][j2] == possibleInput[k]){
                                    //check if the cell below and the cell to the left returns true value
                                    if ((poss[subLeft][subPartition][j1] == true) && (poss[subPartition + 1][subLeft + subSize][j2]) == true){
                                        poss[subLeft][subLeft + subSize][k] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return poss[i][j][r];
    }
        

    /* Task 5 */
    
    /* numberDynamic - determine the number of bracketings of w[i..j]
     evaluating to z, using dynamic programming */
    
    static int numberDynamic(char [] w, int i, int j, char z){
        
        // define n as length of w[i...j)
        int n = j - i + 1;
        
        // initialize the integer that will be used as numerical representations of A, B, and C to -1
        int r = -1;
        
        // use integers 0, 1, and 2 as numerical representations of inputs A, B and C
        if (z == 'A'){
            r = 0;
        }
        
        if (z == 'B'){
            r = 1;
        }
        
        if (z == 'C'){
            r = 2;
        }
        
        // initialize a integer array of dimension 30x30x3
        int [][][] poss = new int [30][30][3];  
        
        // examine array of length 1, where i == j, which fills in the diagonal cells of the table
        for (int s = i; s < n; s++){
            for (int v = 0; v < u; v++){
                if (w[s] == possibleInput[v]){
                    poss[s][s][v] = 1;
                }
            }
        }
        
        // begin to fill up the rest of the table, each new cell is acquired by
        // multiplying the cells to the left and below it
        
        //subSize is defined as the size of each sub-problem
        for (int subSize = 1; subSize < n; subSize++){
            //subLeft is defined as where the left end of the sub-problem starts
            for (int subLeft = i; subLeft < n - subSize; subLeft++){
                //subPartition is defined as the different ways each sub-problem can be broken up
                for (int subPartition = subLeft; subPartition < subLeft + subSize; subPartition++){
                    //k, j1, j2 are used to loop through the multiplication table
                    for (int k = 0; k < u; k++){
                        for (int j1 = 0; j1 < u; j1++){
                            for (int j2 = 0; j2 < u; j2++){
                                if (table[j1][j2] == possibleInput[k]){
                                    // each new cell is acquired by multiplying the cells
                                    // to the left and below it
                                    poss[subLeft][subLeft + subSize][k] += poss[subLeft][subPartition][j1] *
                                    poss[subPartition + 1][subLeft + subSize][j2];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        return poss[i][j][r];
    }
}
