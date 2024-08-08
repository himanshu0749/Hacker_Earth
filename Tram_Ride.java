static long solve(int N, int start, int finish, int[] Ticket_cost){
       // Write your code here
       start-=1;
       finish-=1;
       if(start==finish) return 0;
       long clock=0;
       int i=start;
       while(i!=finish){
        clock+=Ticket_cost[i];
        i=(i+1)%N;
       }
       long anti=0;
       i=start;
       while(i!=finish){
        i=(i-1+N)%N;
        anti+=Ticket_cost[i];
       }
        return Math.min(anti,clock);

    
    }
