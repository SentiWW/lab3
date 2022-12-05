public class Figure {
    public int x;
    public int y;
    public int width;
    public int height;
    public Shape shape;
    public AppColor color;

    public Figure(int x, int y, int width, int height, Shape shape, AppColor color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shape = shape;
        this.color = color;
    }
}
