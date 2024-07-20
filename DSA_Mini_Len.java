import java.util.Scanner;
class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int[] A=new int[n];
            int[] B=new int[n];
            for(int j=0;j<n;j++){
                A[j]=sc.nextInt();
            }
            for(int j=0;j<n;j++){
                B[j]=sc.nextInt();
            }
            int res=find_mini_len(n,A,B);
            System.out.println(res);
        }
    }
    public static int find_mini_len(int n,int[] A,int[] B){
        int i=-1,j=-1;
        for(int k=0;k<n;k++){
            if(A[k]!=B[k]){
                if(i==-1) i=k;
                j=k;
            }
        }
        if(i==-1) return 0;
        else{
            return j-i+1;
        }
    }
}
