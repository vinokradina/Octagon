import org.example.GeometricObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OctagonTest {

    public static class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
        private double side;

        public Octagon() {
            this(0);
        }

        public Octagon(double side) {
            this.side = side;
        }

        public double getSide() {
            return side;
        }

        public void setSide(double side) {
            this.side = side;
        }

        // Переопределение метода для вычисления площади
        @Override
        public double getArea() {
            return (2 + 4 / Math.sqrt(2)) * side * side;
        }

        // Переопределение метода для вычисления периметра
        @Override
        public double getPerimeter() {
            return 8 * side;
        }

        // Реализация метода для сравнения двух объектов
        @Override
        public int compareTo(Octagon other) {
            return Double.compare(this.getArea(), other.getArea());
        }

        // Реализация метода для клонирования объекта
        @Override
        public Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Test
    public void testOctagonArea() {
        Octagon octagon = new Octagon(5);
        double expectedArea = (2 + 4 / Math.sqrt(2)) * 5 * 5;
        assertEquals(expectedArea, octagon.getArea(), 0.0001, "Площадь вычислена неверно");
    }

    @Test
    public void testOctagonPerimeter() {
        Octagon octagon = new Octagon(5);
        double expectedPerimeter = 8 * 5;
        assertEquals(expectedPerimeter, octagon.getPerimeter(), 0.0001, "Периметр вычислен неверно");
    }

    @Test
    public void testOctagonComparison() {
        Octagon octagon1 = new Octagon(5);
        Octagon octagon2 = new Octagon(5);
        Octagon octagon3 = new Octagon(10);

        assertEquals(0, octagon1.compareTo(octagon2), "Объекты должны быть равны");
        assertTrue(octagon1.compareTo(octagon3) < 0, "Первый объект должен быть меньше третьего");
        assertTrue(octagon3.compareTo(octagon1) > 0, "Третий объект должен быть больше первого");
    }

    @Test
    public void testOctagonClone() {
        Octagon octagon = new Octagon(5);
        Octagon clonedOctagon = (Octagon) octagon.clone();

        assertNotSame(octagon, clonedOctagon, "Клон должен быть новым объектом");
        assertEquals(octagon.getSide(), clonedOctagon.getSide(), 0.0001, "Стороны клона не совпадают");
        assertEquals(octagon.getArea(), clonedOctagon.getArea(), 0.0001, "Площади клона не совпадают");
        assertEquals(octagon.getPerimeter(), clonedOctagon.getPerimeter(), 0.0001, "Периметры клона не совпадают");
    }
}
