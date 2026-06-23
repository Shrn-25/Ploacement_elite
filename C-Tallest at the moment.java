
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] H=new int[N];
        int[] L=new int[N];
        for(int i=0;i<N;i++){
            H[i]=sc.nextInt();
            L[i]=sc.nextInt();
        }
        
        int Q=sc.nextInt();
        int[] T=new int[Q];
        for(int i=0;i<Q;i++){
            T[i]=sc.nextInt();
        }
        
        int[] suf=new int[N];
        suf[N-1]=H[N-1];
        for(int i=N-2;i>=0;i--){
            suf[i]=Math.max(suf[i+1],H[i]);
        }
        
        for(int i:suf){System.out.print(i+" ");}
        
        for(int i=0;i<Q;i++){
            int cur=T[i];
            int index=find(cur,L);
            System.out.println(suf[index]);
        }
    }
    
    public static int find(int cur,int[] L){
        int l=0;
        int r=(L.length)-1;
        while(r-l!=1 && r>=l){

            int mid=l+(r-l)/2;
            //System.out.println("l "+l+" ,mid "+mid+" r "+r);
            if(L[mid]==cur){return mid+1;}
            if(L[mid]>cur) {r=mid-1;}
            if(L[mid]<cur) {l=mid+1;}
        }
        
        if(L[l]>cur){return l;}
        if(L[r]>cur){return r;}
        return 0;
    }
}


// Online Java Compiler
// Use this editor to write, compile and run your Java code online

/*
Time Limit: 2 sec / Memory Limit: 1024 MiB

Score : 
300 points

Problem Statement
Currently, there are 
N Takahashi in a conference room. The 
i-th 
(1≤i≤N) Takahashi has a height of 
H 
i
​
  and will leave the room 
L 
i
​
  minutes from now. Once a Takahashi leaves the room, he never returns.

You are given 
Q queries, so answer them in order. For the 
i-th 
(1≤i≤Q) query, you are given an integer 
T 
i
​
 , so find the maximum height among the Takahashi who are in the room 
T 
i
​
 + 
2
1
​
  minutes from now. Under the constraints of this problem, it is guaranteed that at least one Takahashi will be in the room 
T 
i
​
 + 
2
1
​
  minutes from now.

Constraints
1≤N≤3×10 
5
 
1≤H 
i
​
 ≤10 
9
  (1≤i≤N)
1≤L 
1
​
 ≤L 
2
​
 ≤⋯≤L 
N
​
 ≤10 
9
 
1≤Q≤3×10 
5
 
0≤T 
i
​
 <L 
N
 
Output
Output 
Q lines. The 
i-th line 
(1≤i≤Q) should contain the answer to the 
i-th query.

Sample Input 1
Copy
4
31 4
26 5
3 5
15 9
4
3 4 5 6
Sample Output 1
Copy
31
26
15
15
3+ 
2
1
​
  minutes from now, all Takahashi currently in the room are still there. Thus, the answer to the first query is 
31, the maximum of 
{31,26,3,15}.

5+ 
2
1
​
  minutes from now, only the fourth Takahashi is in the room. Thus, the answer to the third query is 
15, the maximum of 
{15}.

Sample Input 2
Copy
10
587 138
772 155
755 404
519 408
529 432
169 586
114 632
249 656
329 972
299 984
14
443 801 824 276 399 314 300 510 311 580 498 930 359 5
Sample Output 2
Copy
329
329
329
755
755
755
755
329
755
329
329
329
755
*/
