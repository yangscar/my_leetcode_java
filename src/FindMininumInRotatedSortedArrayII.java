    public int findMin(int[] num) {
        if (num[num.length-1] > num[0]) return num[0];
        return find(num,0,num.length-1);
    }
    
    private int find(int[] num, int lo, int hi){
        if (hi<=lo) return num[lo];
        int mid = lo + (hi-lo)/2;
        if (mid < hi && num[mid] > num[mid+1])
            return num[mid+1];
        if(lo < mid && num[mid] < num[mid-1])
            return num[mid];
        if (num[mid] < num[lo])
            return find(num, lo, mid-1);
        if (num[mid] > num[lo]) 
            return find(num, mid+1, hi);
        else 
            return Math.min(find(num,lo,mid-1),find(num,mid+1,hi));
    }
