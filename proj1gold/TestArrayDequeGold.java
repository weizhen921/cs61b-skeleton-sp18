import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestArrayDequeGold {
    @Test
    public void autoGrader() {
        StudentArrayDeque<Integer> s = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> a = new ArrayDequeSolution<>();
        String expression = new String();

        for (int i = 0; i < 500; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne <= 0.25) {
                s.addFirst(i);
                a.addFirst(i);
                expression = expression + "addFirst(" + i + ")\n";
                assertEquals(expression, s.size(), a.size());
            } else if (numberBetweenZeroAndOne > 0.25 && numberBetweenZeroAndOne <= 0.5) {
                s.addLast(i);
                a.addLast(i);
                expression = expression + "addLast(" + i + ")\n";
                assertEquals(expression, s.size(), a.size());
            } else if (numberBetweenZeroAndOne > 0.5 && numberBetweenZeroAndOne <= 0.75) {
                if (s.size() != 0 && a.size() != 0) {
                    Integer sn = s.removeFirst();
                    Integer an = a.removeFirst();
                    expression = expression + "removeFirst()\n";
                    assertEquals(expression, sn, an);
                }
            } else if (numberBetweenZeroAndOne > 0.75) {
                if (s.size() != 0 && a.size() != 0) {
                    Integer sn = s.removeLast();
                    Integer an = a.removeLast();
                    expression = expression + "removeLast()\n";
                    assertEquals(expression, sn, an);
                }
            }


        }


    }
}



