import java.util.Random;

public class Apple {
    private final String name;
    private AppleColor color;
    private AppleColor[] colors = AppleColor.values();
    private Random random = new Random();
    public Apple(){
        color = colors[random.nextInt(colors.length)];
        name = color + " Apple";
    }

    public String getName(){
        return name;
    }

    public String getColor(){
        return color.toString();
    }
    @Override
    public String toString() {
        return name;
    }
}
