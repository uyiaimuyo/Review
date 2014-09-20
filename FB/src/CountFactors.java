class CountFactors {
    public int solution(int N) {
        if (N == 1)
            return 1;
        int i = 1;
        int result = 0;
        while ( i*i < N) {
            if (N % i == 0)
                result += 2;
            i++;
        }
        if (i*i == N)
            result++;
        return result;
    }
}
