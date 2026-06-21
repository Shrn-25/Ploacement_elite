// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    
    public static int factorial(int n){
        int a=1;
        for(int i=1;i<=n;i++){
            a*=i;}
            System.out.println("n: "+n+" a: "+a);
            return a;
                 }
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int D=sc.nextInt();
        
        int[][] arr=new int[N][2];
        for(int i=0;i<N;i++){
            for(int j=0;j<2;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        
        int max_t=arr[0][0];
        for(int[] i:arr){for(int a:i){if(a>max_t)max_t=a;}}
        
        int[] calc=new int[max_t+1];
        
        for(int i=0;i<arr.length;i++){
            int S=arr[i][0];
            int T=arr[i][1];
            if(T-S>=D){
                
                calc[S]++;
                calc[(T+1-D)]--;
            }
            else{continue;}
        }
       /*for(int i=0;i<=Math.min(100,calc.length);i++){System.out.print(i+" ");}
        System.out.println();
        for(int i:calc){System.out.print(i+" ");}
        */
        for(int i=1;i<calc.length;i++){calc[i]+=calc[i-1];}
        System.out.println();
        for(int i=calc.length-10;i<calc.length;i++)
        {System.out.print(i+" : "+calc[i]+" ");}
        System.out.println();
        
        
        int count=0;
        for(int i:calc){if(i>=2)count++;}
        int com=count*factorial(4)/(factorial(2)*factorial(2));
        System.out.println(com);
    }
}
