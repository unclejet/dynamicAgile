package com.dynamic.agile.chorus;


import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/10/12 下午12:29
 * @description：
 * 描述
 *
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 *
 * 说明：
 *
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 *
 *
 * 注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
 * 请注意处理多组输入输出！
 *
 * 备注：
 * 1<=N<=3000
 * 输入描述：
 *
 * 有多组用例，每组都包含两行数据，第一行是同学的总数N，第二行是N位同学的身高，以空格隔开
 * 输出描述：
 *
 * 最少需要几位同学出列
 * 示例1
 * 输入：
 *
 * 8
 * 186 186 150 200 160 130 197 200
 *
 * 输出：
 *
 * 4
 *
 * 说明：
 *
 * 由于不允许改变队列元素的先后顺序，所以最终剩下的队列应该为186 200 160 130或150 200 160 130
 */
public class ChorusTest {
    @Test
    public void onePerson() {
        int[] heights = new int[]{200};
        assertThat(new Chorus(heights).outQueue().size(), is(0));
    }

    @Test
    public void twoPeople_lowAndHigh_lowOut() {
        int[] heights = new int[]{200, 180};
        List<Integer> outQueue = new Chorus(heights).outQueue();
        assertThat(outQueue.size(), is(1));
        assertThat(outQueue, hasItems(180));
    }

    @Test
    public void twoPeople_sameHeight_oneOut() {
        int[] heights = new int[]{200, 200};
        List<Integer> outQueue = new Chorus(heights).outQueue();
        assertThat(outQueue.size(), is(1));
        assertThat(outQueue, hasItems(200));
    }

    @Test
    public void threePeople_sameHeight_twoOut() {
        int[] heights = new int[]{200, 200, 200};
        List<Integer> outQueue = new Chorus(heights).outQueue();
        assertThat(outQueue.size(), is(2));
        assertThat(outQueue, contains(200, 200));
    }

    @Test
    public void threePeople_highLeft_twoOthersOut() {
        int[] heights = new int[]{200, 190, 180};
        List<Integer> outQueue = new Chorus(heights).outQueue();
        assertThat(outQueue.size(), is(2));
        assertThat(outQueue, hasItems(190, 180));
    }

    @Test
    public void threePeople_highRight_twoOthersOut() {
        int[] heights = new int[]{190, 180, 200};
        List<Integer> outQueue = new Chorus(heights).outQueue();
        assertThat(outQueue.size(), is(2));
        assertThat(outQueue, hasItems(190, 180));
    }

    @Test
    public void threePeople_highMiddle_noOut() {
        int[] heights = new int[]{190, 200, 180};
        List<Integer> outQueue = new Chorus(heights).outQueue();
        assertThat(outQueue.size(), is(0));
    }

    @Test
    public void fourPeople_leftPeopleMore_noOut() {
        int[] heights = new int[]{150, 190, 200, 180};
        List<Integer> outQueue = new Chorus(heights).outQueue();
        assertThat(outQueue.size(), is(0));
    }

    @Test
    public void fourPeople_leftPeopleMore_1out() {
        int[] heights = new int[]{190, 150, 200, 180};
        List<Integer> outQueue = new Chorus(heights).outQueue();
        assertThat(outQueue.size(), is(1));
        assertThat(outQueue, hasItems(150));
    }

    @Test
    public void fourPeople_rightPeopleMore_1out() {
        int[] heights = new int[]{190, 200, 150, 180};
        List<Integer> outQueue = new Chorus(heights).outQueue();
        assertThat(outQueue.size(), is(1));
        assertThat(outQueue, hasItems(180));
    }

    @Test
    public void manyPeople_highestInMiddle() {
        int[] heights = new int[]{186, 186, 150, 200, 160, 130, 197, 200};
        List<Integer> outQueue = new Chorus(heights).outQueue();
        assertThat(outQueue.size(), is(4));
        assertThat(outQueue, hasItems(186,200,197));
    }

    @Test
    public void highestNotInMiddle() {
        int[] heights = new int[]{186, 186, 150, 190, 160, 130, 197, 200};
        List<Integer> outQueue = new Chorus(heights).outQueue();
        assertThat(outQueue.size(), is(4));
        assertThat(outQueue, hasItems(186,200,197));
    }

    @Test
    public void chorusInLeft() {
        int[] heights = new int[]{186, 187, 150, 149, 148, 147, 148, 200};
        List<Integer> outQueue = new Chorus(heights).outQueue();
        assertThat(outQueue.size(), is(2));
        assertThat(outQueue, hasItems(148,200));
    }
}
