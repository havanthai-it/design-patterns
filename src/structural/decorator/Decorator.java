package structural.decorator;

public class Decorator {
    public static void main(String[] args) {
        Widget widget = new BorderDecorator(new BackgroundDecorator(new TextField(100, 50)));
        widget.draw();
    }
}

interface Widget {
    void draw();
}

class TextField implements Widget {
    private int width, height;

    public TextField (int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println(String.format("TextField - width: %d - height: %d", this.width, this.height));
    }
}

abstract class WidgetDecorator implements Widget {
    Widget widget;

    public WidgetDecorator(Widget widget) {
        this.widget = widget;
    }

    @Override
    public void draw() {
        this.widget.draw();
    }
}

class BorderDecorator extends WidgetDecorator {

    public BorderDecorator(Widget widget) {
        super(widget);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Do decorate Border");
    }
}

class BackgroundDecorator extends WidgetDecorator {

    public BackgroundDecorator(Widget widget) {
        super(widget);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Do decorate Background");
    }
}

