package com.gildedrose.products;

import com.gildedrose.Item;
import com.gildedrose.QuantityDailyProcessor;

public abstract class ItemQuantityDailyProcessor implements QuantityDailyProcessor {
    private final Item item;
    final QuantityUpdater quantityUpdater = new QuantityUpdater();

    protected ItemQuantityDailyProcessor(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }


    @Override
    public void processDailyQuantityUpdate() {
        applyBasicUpdates();
        markPassingOfTime();
        adjustAccordingToNewSellInValue();
    }

    protected abstract void applyBasicUpdates();

    protected void markPassingOfTime(){
        getItem().sellIn--;
    }

    protected abstract void adjustAccordingToNewSellInValue();

    public static class QuantityUpdater {
        public void increaseQuality(Item item) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    
        public void decreaseQuality(Item item) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}
