/**
     * 这句话是重点：Bob found that he will always lose this game (poor Bob, he always loses), so he decided to minimize the score's difference. Alice's goal is to maximize the difference in the score.
     * 不管是Bob minimize 还是Alice maximize，本质都是在当前轮选取一个stone去掉后，保证剩余之和最大。
     * 子问题划分：对于当前stones，去掉一个stone，该轮最佳得分为剩余stones加和减去下一轮(去掉stone之后的stones)的最佳得分。去掉stones有两种方式：1.去掉最左边，2.去掉最右边。最佳得分即从这两种方式的得分中取最大值。
     * 抽象问题：fun(0:n)=MAX(sum(1:n)-fun(1:n), sum(0,n-1)-fun(0,n-1))
     * 总结：
     *  1.抽象问题是关键，如何从题目介绍中抽象问题并进行子问题划分是这道题的重点；
     *  2.可以抽象为递归；3.递归完成后，会发现会出现很多重复计算，如果记录每一步的结果不再重复计算，TATA!就完成了DP!
     *  3.其他优化：求sum时可以只求一次，在子问题计算时通过加减进行sum的调整
     * @param stones
     */
    public int stoneGameVII(int[] stones) {
        //dp 记录每一步状态
        int[][] result = new int[stones.length][stones.length];
        //初始化sum
        int sum = 0;
        for(int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        return helper(stones, 0, stones.length-1, sum ,result);
    }

    private int helper(int[] stones, int begin, int end, int sum, int[][] result) {
        //递归先写结束条件
        if(begin >= end) {
            return 0;
        }
        //如果之前计算过，直接返回结果
        if(result[begin][end] != 0) {
            return result[begin][end];
        }
        int left = sum-stones[begin] - helper(stones, begin+1, end, sum-stones[begin], result); //sum-stones[begin]通过上一轮的sum计算这一轮sum
        int right = sum-stones[end] -helper(stones, begin, end-1, sum-stones[end], result);
        int max = Math.max(left, right);
        result[begin][end] = max;
        return max;
    }
