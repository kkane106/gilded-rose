import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    private List<UpdateableItem> items = null;

    public GildedRose() {
        this(new ArrayList<UpdateableItem>());
    }

    public GildedRose(List<UpdateableItem> items) {
        this.items = items;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        List<UpdateableItem> items = new ArrayList<>();
        items.add(new SimpleItem("+5 Dexterity Vest", 10, 20));
        items.add(new AppreciatingItem("Aged Brie", 2, 0));
        items.add(new SimpleItem("Elixir of the Mongoose", 5, 7));
        items.add(new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new TimeLimitItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new ConjuredItem("Conjured Mana Cake", 3, 6));
        GildedRose rose = new GildedRose(items);
        rose.updateQuality();
    }


    public void updateQuality() {
        this.items.forEach(item -> item.update());
    }

    public List<UpdateableItem> getItems() {
        return items;
    }
}