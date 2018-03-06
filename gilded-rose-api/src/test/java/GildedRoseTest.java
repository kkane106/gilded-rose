import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GildedRoseTest {

    @Test
    public void testTheTruth() {
        assertTrue(true);
    }

    @Test
    public void testSimpleItemQualityReducedByOne() {
        GildedRose rose = new GildedRose(Arrays.asList(new SimpleItem("toothbrush", 2, 2) {
        }));
        rose.updateQuality();

        Item toothbrush = rose.getItems().get(0);

        assertEquals(1, toothbrush.getQuality());

    }

    @Test
    public void testSimpleItemSellInReducedByOne() {
        GildedRose rose = new GildedRose(Arrays.asList(new SimpleItem("toothbrush", 2, 2)));
        rose.updateQuality();

        Item toothbrush = rose.getItems().get(0);

        assertEquals(1, toothbrush.getSellIn());
    }

    @Test
    public void testAgedBrieQualityPlusOne() {
        GildedRose rose = new GildedRose(Arrays.asList(new AppreciatingItem("Aged Brie", 2, 2)));
        rose.updateQuality();

        Item toothbrush = rose.getItems().get(0);

        assertEquals(3, toothbrush.getQuality());
    }

    @Test
    public void testDegradedSimpleItemSellinReducedBeyondZero() {
        GildedRose rose = new GildedRose(Arrays.asList(new SimpleItem("toothbrush", 0, 2)));
        rose.updateQuality();

        Item toothbrush = rose.getItems().get(0);

        assertEquals(-1, toothbrush.getSellIn());
    }

    @Test
    public void testDegradedSimpleItemQualityReducedByTwo() {
        GildedRose rose = new GildedRose(Arrays.asList(new SimpleItem("toothbrush", 0, 2)));
        rose.updateQuality();

        Item toothbrush = rose.getItems().get(0);

        assertEquals(0, toothbrush.getQuality());
    }

    @Test
    public void testAgedBrieSellInMinusOne() {
        GildedRose rose = new GildedRose(Arrays.asList(new AppreciatingItem("Aged Brie", 2, 2)));
        rose.updateQuality();

        Item toothbrush = rose.getItems().get(0);

        assertEquals(1, toothbrush.getSellIn());
    }

    @Test
    public void testSulfurasQualityEighty() {
        GildedRose rose = new GildedRose(Arrays.asList(new LegendaryItem("Sulfuras, Hand of Ragnaros", 2, 80)));
        rose.updateQuality();

        Item toothbrush = rose.getItems().get(0);

        assertEquals(80, toothbrush.getQuality());
    }

    @Test
    public void testSulfurasSellinNoChange() {
        GildedRose rose = new GildedRose(Arrays.asList(new LegendaryItem("Sulfuras, Hand of Ragnaros", 2, 80)));
        rose.updateQuality();

        Item toothbrush = rose.getItems().get(0);

        assertEquals(2, toothbrush.getSellIn());
    }

    @Test
    public void testBackstagePassIncreaseByOneMoreThanTenSellIn() {
        GildedRose rose = new GildedRose(Arrays.asList(new TimeLimitItem("Backstage passes to a TAFKAL80ETC concert", 12, 10)));
        rose.updateQuality();

        Item toothbrush = rose.getItems().get(0);

        assertEquals(11, toothbrush.getQuality());
    }


    @Test
    public void testBackstagePassIncreaseByTwoLessThanTenSellIn() {
        GildedRose rose = new GildedRose(Arrays.asList(new TimeLimitItem("Backstage passes to a TAFKAL80ETC concert", 9, 10)));
        rose.updateQuality();

        Item toothbrush = rose.getItems().get(0);

        assertEquals(12, toothbrush.getQuality());
    }


    @Test
    public void testBackstagePassIncreaseByThreeLessThanFiveSellIn() {
        GildedRose rose = new GildedRose(Arrays.asList(new TimeLimitItem("Backstage passes to a TAFKAL80ETC concert", 4, 10)));
        rose.updateQuality();

        Item toothbrush = rose.getItems().get(0);

        assertEquals(13, toothbrush.getQuality());
    }


    @Test
    public void testBackStagePasseIncreasesQualityAt11DaysByOne() {
        GildedRose rose = new GildedRose(Arrays.asList(new TimeLimitItem("Backstage passes to a TAFKAL80ETC concert", 11, 20)));
        rose.updateQuality();
        List<UpdateableItem> items = rose.getItems();

        assertEquals(21, items.get(0).getQuality());
    }

    @Test
    public void testBackStagePasseIncreasesQualityAt10DaysByTwo() {
        GildedRose rose = new GildedRose(Arrays.asList(new TimeLimitItem("Backstage passes to a TAFKAL80ETC concert", 10, 20)));
        rose.updateQuality();
        List<UpdateableItem> items = rose.getItems();

        assertEquals(22, items.get(0).getQuality());
    }

    @Test
    public void testBackStagePasseIncreasesQualityAt6DaysByTwo() {
        GildedRose rose = new GildedRose(Arrays.asList(new TimeLimitItem("Backstage passes to a TAFKAL80ETC concert", 6, 20)));
        rose.updateQuality();
        List<UpdateableItem> items = rose.getItems();

        assertEquals(22, items.get(0).getQuality());
    }

    @Test
    public void testBackStagePasseIncreasesQualityAt5DaysByThree() {
        GildedRose rose = new GildedRose(Arrays.asList(new TimeLimitItem("Backstage passes to a TAFKAL80ETC concert", 5, 20)));
        rose.updateQuality();
        List<UpdateableItem> items = rose.getItems();

        assertEquals(23, items.get(0).getQuality());
    }

    @Test
    public void testBackStagePassQualityDecreasesToZeroOnDayZero() {
        GildedRose rose = new GildedRose(Arrays.asList(new TimeLimitItem("Backstage passes to a TAFKAL80ETC concert", 0, 20)));
        rose.updateQuality();
        List<UpdateableItem> items = rose.getItems();

        assertEquals(0, items.get(0).getQuality());
    }


    @Test
    public void testBackStagePassQualityCannotReduceBelowZero() {
        GildedRose rose = new GildedRose(Arrays.asList(new TimeLimitItem("Backstage passes to a TAFKAL80ETC concert", -10, 20)));
        rose.updateQuality();
        List<UpdateableItem> items = rose.getItems();

        assertEquals(0, items.get(0).getQuality());
    }

    @Test
    public void testBackStagePassSellInCanReduceBelowZero() {
        GildedRose rose = new GildedRose(Arrays.asList(new TimeLimitItem("Backstage passes to a TAFKAL80ETC concert", -10, 20)));
        rose.updateQuality();
        List<UpdateableItem> items = rose.getItems();

        assertEquals(-11, items.get(0).getSellIn());
    }

    @Test
    public void testBackStagePassQualityCannotIncreaseBeyond50() {
        GildedRose rose = new GildedRose(Arrays.asList(new TimeLimitItem("Backstage passes to a TAFKAL80ETC concert", 3, 48)));
        rose.updateQuality();
        List<UpdateableItem> items = rose.getItems();

        assertEquals(50, items.get(0).getQuality());
    }

    @Test
    public void testSimpleItemQualityCannotDecreaseBelowZero() {
        GildedRose rose = new GildedRose(Arrays.asList(new SimpleItem("toothbrush", -100, 0)));
        rose.updateQuality();
        List<UpdateableItem> items = rose.getItems();

        assertEquals(0, items.get(0).getQuality());
    }


    @Test
    public void testConjuredItemQualityCannotDecreaseBelowZero() {
        GildedRose rose = new GildedRose(Arrays.asList(new ConjuredItem("Conjured Mana Cake", -100, 0)));
        rose.updateQuality();
        List<UpdateableItem> items = rose.getItems();

        assertEquals(0, items.get(0).getQuality());
    }

    @Test
    public void testAppreciatingItemQualityCannotIncreaseBeyond50() {
        GildedRose rose = new GildedRose(Arrays.asList(new AppreciatingItem("Aged Brie", -10, 50)));
        rose.updateQuality();
        List<UpdateableItem> items = rose.getItems();

        assertEquals(50, items.get(0).getQuality());
    }

    @Test
    public void testDefaultConstructorOfGildedRoseInitializesItemsToEmptyArrayList() {
        GildedRose rose = new GildedRose();
        List<UpdateableItem> items = rose.getItems();

        assertEquals(0, items.size());
    }

}

