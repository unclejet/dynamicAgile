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
        int hIdx = findHighestCandidateIdx();
        IntStream.range(0, heights.length).filter(i->needOut(i, hIdx)).forEach(h->outs.add(heights[h]));
        return outs;
    }

    private int findHighestCandidateIdx() {
        int[] candidatesIdx = findCandidates();
        int hIdx = 0;
        for (int i = 1; i < candidatesIdx.length; i++) {
            if (heights[candidatesIdx[i]] > heights[candidatesIdx[hIdx]]) {
                hIdx = i;
            }
        }
        return candidatesIdx.length > 0 ? candidatesIdx[hIdx] : findHighestIdx();
    }

    private int[] findCandidates() {
        return IntStream.range(1, heights.length - 1).filter(i -> isCandidate(i)).toArray();
    }

    private boolean isCandidate(int idx) {
        return isLeftSatisfy(idx) && isRightSatisfy(idx);
    }

    private boolean isRightSatisfy(int idx) {
        return IntStream.range(idx + 1, heights.length).anyMatch(i -> heights[i] < heights[idx]);
    }

    private boolean isLeftSatisfy(int idx) {
        return IntStream.range(0, idx).anyMatch(i -> heights[i] < heights[idx]);
    }

    private boolean needOut(int idx, int hIdx) {
        return idx != hIdx &&
                ((hasLeft(hIdx) && !hasRight(hIdx) || !hasLeft(hIdx) && hasRight(hIdx))
                        || notSatisfyChorusShape(idx, hIdx));
    }

    private boolean notSatisfyChorusShape(int idx, int hIdx) {
        return idx < hIdx ? notSatisfyChorusShapeLeft(idx) : notSatisfyChorusShapeRight(idx, hIdx);
    }

    /**
     * 右边高的出队
     * @param idx
     * @return
     */
    private boolean notSatisfyChorusShapeRight(int idx, int hIdx) {
        return IntStream.range(hIdx, idx).anyMatch(i->heights[i] <= heights[idx]);
    }

    /**
     * 左边矮的出队
     * @param idx
     * @return
     */
    private boolean notSatisfyChorusShapeLeft(int idx) {
        return IntStream.range(0, idx).anyMatch(i-> heights[i] >= heights[idx]);
    }

    private boolean hasRight(int hIdx) {
        return hIdx != heights.length - 1;
    }

    private boolean hasLeft(int hIdx) {
        return hIdx != 0;
    }

    private int findHighestIdx() {
        return IntStream.range(0, heights.length)
                .reduce((i, j) -> heights[i] >= heights[j] ? i : j)
                .getAsInt();
    }
}
