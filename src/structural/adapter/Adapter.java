package structural.adapter;

public class Adapter {
    public static void main(String[] args) {
        int x1 = 10;
        int y1 = 20;
        int x2 = 120;
        int y2 = 60;

        Shape[] shapes = { new LineAdapter(new Line()), new RectangleAdapter(new Rectangle()) };
        for (Shape shape: shapes) {
            shape.draw(x1, y1, x2, y2);
        }
    }
}

class Line {
    public void draw(int x1, int y1, int x2, int y2) {
        System.out.println(String.format("Draw line: (%d, %d) -> (%d, %d)", x1, y1, x2, y2));
    }
}

class Rectangle {
    public void draw(int x, int y, int width, int height) {
        System.out.println(String.format("Draw rectangle: (%d, %d) -> (%d, %d)", x, y, x + width, y + height));
    }
}

interface Shape {
    void draw(int x1, int y1, int x2, int y2);
}

class LineAdapter implements Shape {
    private Line adaptee;

    public LineAdapter(Line line) {
        adaptee = line;
    }

    @Override
    public void draw(int x1, int y1, int x2, int y2) {
        adaptee.draw(x1, y1, x2, y2);
    }
}

class RectangleAdapter implements Shape {
    private Rectangle adaptee;

    public RectangleAdapter(Rectangle rectangle) {
        adaptee = rectangle;
    }

    @Override
    public void draw(int x1, int y1, int x2, int y2) {
        adaptee.draw(x1, y1, x2 - x1, y2 - y1);
    }
}
