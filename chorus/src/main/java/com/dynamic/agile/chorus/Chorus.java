package com.dynamic.agile.chorus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/10/20 上午11:41
 * @description：
 */
public class Chorus {
    private int[] heights;

    public Chorus(int[] heights) {
        this.heights = heights;
    }

    public List<Integer> outQueue() {
        List<Integer> outs = new ArrayList<>();
        int hIdx = findHighestIdx();
        for (int i = 0; i < heights.length; i++) {
            if (i != hIdx) {
                outs.add(heights[i]);
            }
        }
        return outs;
    }

    private int findHighestIdx() {
        return IntStream.range(0, heights.length)
                .reduce((i, j) -> heights[i] >= heights[j] ? i : j)
                .getAsInt();
    }
}
