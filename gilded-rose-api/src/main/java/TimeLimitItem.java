public class TimeLimitItem extends UpdateableItem {
    public TimeLimitItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {

        if (this.sellIn <= 0) {
            this.quality = 0;
        } else if (this.sellIn <= 5) {
            if (this.quality > 47) {
                this.quality = 50;
            } else {
                this.quality += 3;
            }
        } else if (this.sellIn <= 10) {
            if (this.quality > 48) {
                this.quality = 50;
            } else {
                this.quality += 2;
            }
        } else {
            if (this.quality > 49) {
                this.quality = 50;
            } else {
                this.quality += 1;
            }
        }
        sellIn--;
    }
}
