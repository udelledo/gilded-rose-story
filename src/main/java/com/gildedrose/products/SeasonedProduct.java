package com.gildedrose.products;

import com.gildedrose.Item;

/**
 * This processor will be used for product that can be seasoned,
 * and will increase their value when the sellIn date is less than zero.
 */
public class SeasonedProduct extends ItemQuantityDailyProcessor {
    protected SeasonedProduct(Item item) {
        super(item);
    }

    @Override
    protected void applyBasicUpdates() {
        quantityUpdater.increaseQuality(getItem());
    }

    @Override
    protected void adjustAccordingToNewSellInValue() {
        if (getItem().sellIn < 0) {
            quantityUpdater.increaseQuality(getItem());
        }
    }
}
