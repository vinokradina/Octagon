package org.example;

public class GeometricObject {
    private String color = "белый";
    private boolean filled;
    private java.util.Date dateCreated;

    // Конструктор по умолчанию
    public GeometricObject() {
        dateCreated = new java.util.Date();
    }

    // Конструктор с указанным цветом и заливкой
    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        dateCreated = new java.util.Date();
    }

    // Getter для цвета
    public String getColor() {
        return color;
    }

    // Setter для цвета
    public void setColor(String color) {
        this.color = color;
    }

    // Getter для заливки
    public boolean isFilled() {
        return filled;
    }

    // Setter для заливки
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // Getter для даты создания
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return "Создан: " + dateCreated + "\nЦвет: " + color + "\nЗаливка: " + filled;
    }

    // Метод для получения площади (переопределяется в наследниках)
    public double getArea() {
        return 0;
    }

    // Метод для получения периметра (переопределяется в наследниках)
    public double getPerimeter() {
        return 0;
    }
}
