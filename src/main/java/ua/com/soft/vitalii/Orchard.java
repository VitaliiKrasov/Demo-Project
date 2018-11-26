package ua.com.soft.vitalii;

public enum Orchard {
    Apricots(new Fruit("Apricots", Color.YELLOW)),
    Gala(new Fruit("Gala", Color.RED)),
    Avocado(new Fruit("Avocado", Color.GREEN)),
    Bananas(new Fruit("Bananas", Color.WHITE)),
    Pear(new Fruit("Pear", Color.BROWN)),
    Peach(new Fruit("Peach", Color.RED)),
    Plums(new Fruit("Plums", Color.PURPLE)),
    Kiwi(new Fruit("Kiwi", Color.GREEN)),
    Blueberies(new Fruit("Blueberies", Color.BLUE)),
    Grapefruit(new Citrus("Grapefruit", Color.RED, 31.2)),
    Lemon(new Citrus("Lemon", Color.YELLOW, 53)),
    Lime(new Citrus("Lime", Color.GREEN, 29.1)),
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
