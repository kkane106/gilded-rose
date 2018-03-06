public class ConjuredItem extends UpdateableItem {
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        this.sellIn--;

        if (this.quality < 2) {
            this.quality = 0;
        } else {
            this.quality -= 2;
        }

    }
}
