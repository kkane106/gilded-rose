public class SimpleItem extends UpdateableItem {

    public SimpleItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        this.sellIn--;

        if (this.sellIn > 0) {
            if (this.quality < 1) {
                this.quality = 0;
            } else {
                this.quality--;
            }
        } else {

            if (this.sellIn < 2) {
                this.quality = 0;
            } else {
                this.quality -= 2;
            }
        }

    }
}
