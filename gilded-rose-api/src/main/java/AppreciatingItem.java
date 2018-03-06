public class AppreciatingItem extends UpdateableItem {

    public AppreciatingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        this.sellIn--;

        if (this.quality > 49) {
            this.quality = 50;
        } else {
            this.quality++;
        }
    }
}
