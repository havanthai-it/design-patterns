package creational.builder;

public class Builder {
    public static void main(String[] args) {
        Rectangle rectangle = new RectangleBuilder()
                .setWidth(100)
                .setHeight(60)
                .setBgColor("Black")
                .build();
    }
}

class RectangleBuilder {

    protected Rectangle rectangle;

    public RectangleBuilder() {
        rectangle = new Rectangle();
    }

    public RectangleBuilder setWidth(int width) {
        rectangle.setWidth(width);
        return this;
    }

    public RectangleBuilder setHeight(int height) {
        rectangle.setHeight(height);
        return this;
    }

    public RectangleBuilder setBgColor(String bgColor) {
        rectangle.setBgColor(bgColor);
        return this;
    }

    public Rectangle build() {
        return rectangle;
    }
}

class Rectangle {
    private int width;
    private int height;
    private String bgColor;

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}