package ua.com.soft.vitalii;

/*thanks http://www.nutritionaustralia.org/national/resource/eat-rainbow*/
public enum Color{
    RED,
    PURPLE,
    BLUE,
    ORANGE,
    YELLOW,
    GREEN,
    BROWN,
    WHITE;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
