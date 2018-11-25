package ua.com.soft.vitalii;

public enum Orchard {
    Apricots(new Fruit("Apricots", Color.YELLOW)),
    Apple_gala(new Fruit("Apple", Color.RED)),
    Avocado(new Fruit("Avocado", Color.GREEN)),
    Bananas(new Fruit("Bananas", Color.WHITE)),
    Plums(new Fruit("Plums", Color.PURPLE)),
    Kiwi(new Fruit("Kiwi", Color.GREEN)),
    Blueberies(new Fruit("Blueberies", Color.BLUE)),
    Grapefruit(new Citrus("Grapefruit", Color.RED, 31.2)),
    Lemon(new Citrus("Lemon", Color.RED, 53)),
    Orange(new Citrus("Orange", Color.ORANGE, 53.2)),
    Clementine(new Citrus("Clementine", Color.ORANGE, 48.8)),
    Tangerine(new Citrus("Tangerine", Color.RED, 26.7)),
    Pomelo(new Citrus("Pomelo", Color.YELLOW, 61)),
    Watermelon(new Fruit("Watermelon", Color.RED));

    final Fruit fruit;

    Orchard(Fruit fruit) {
        this.fruit = fruit;
    }

    public Fruit get() {
        return fruit;
    }
}
