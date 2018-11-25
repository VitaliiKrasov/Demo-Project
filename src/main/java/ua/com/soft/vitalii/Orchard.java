package ua.com.soft.vitalii;

public enum Orchard {
    Apricots(new Fruit("Apricots", Color.yellow)),
    Apple_gala(new Fruit("Apple", Color.red)),
    Avocado(new Fruit("Avocado", Color.green)),
    Bananas(new Fruit("Bananas", Color.white)),
    Plums(new Fruit("Plums", Color.purple)),
    Kiwi(new Fruit("Kiwi", Color.green)),
    Blueberies(new Fruit("Blueberies", Color.blue)),
    Grapefruit(new Citrus("Grapefruit", Color.red, 31.2)),
    Lemon(new Citrus("Lemon", Color.red, 53)),
    Clementine(new Citrus("Clementine", Color.orange, 48.8)),
    Tangerine(new Citrus("Tangerine", Color.red, 26.7)),
    Pomelo(new Citrus("Pomelo", Color.yellow, 61)),
    Watermelon(new Fruit("Watermelon", Color.red));

    final Fruit fruit;

    Orchard(Fruit fruit) {
        this.fruit = fruit;
    }

    public Fruit get() {
        return fruit;
    }
}
