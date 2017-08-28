class MyIntNum{
    private int v;

    public MyIntNum(int v) {
        this.v = v;
    }

    public int getNum() {
        return v;
    }

    boolean isFactor(int n){
        return (v % n) == 0;
    }

    boolean hasCommonFactor(int n){
        int m = Math.min(n, v);
        for (int i = 2; i <= m; i++) {
            if (((v % i) == 0)&&((n % i) ==0))
                return true;
        }
        return false;
    };
}
