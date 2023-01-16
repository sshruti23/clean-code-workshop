package com.movierental;

import org.junit.Test;

public class PerformanceImplicationsTest {

    /*
   The output of the previous example shows us that code with 3 for-loops does not take
   3 times more time than the code with a single for loop.
   Moreover, after a few runs, JVM is able to identify hotspots of intensive code and
   optimises parts of the code to make them significantly faster.
   In our previous example, after 2 runs, the JVM had already optimised the code so much
   that the discussion around for-loops became redundant. This is called JIT (Just In Time compilation).

   The Java JVM has evolved so much that unless we know what's happening inside, we cannot predict the performance
   implications of changes like introduction of for-loops. The only way to actually improve the performance of
   a system is by measuring it and focusing only on fixing the actual bottlenecks.

   */
    @Test
    public void singleLoopVsMultiple() {
        for (int j = 0; j < 100; j++) {

            //single loop
            int x = 0, y = 0, z = 0;
            long l = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                x++;
                y++;
                z++;
            }
            l = System.currentTimeMillis() - l;


            //multiple loops doing the same thing
            int a = 0, b = 0, c = 0;
            long m = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                a++;
            }
            for (int i = 0; i < 100000000; i++) {
                b++;
            }
            for (int i = 0; i < 100000000; i++) {
                c++;
            }
            m = System.currentTimeMillis() - m;
            System.out.println(String.format("%d,%d", l, m));

        }
    }

}
