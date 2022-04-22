package com.gildedrose.products;

import com.gildedrose.Item;


/**
 * This is a special item that does not change anything. It is used for mystical elements.
 */
public class FixedQualityProduct extends ItemQuantityDailyProcessor {
    private final int quality;

    public FixedQualityProduct(Item item, int quality) {
        super(item);
        this.quality = quality;
    }

    @Override
    protected void applyBasicUpdates() {
        getItem().quality = quality;
    }

    @Override
    protected void markPassingOfTime() {
        // Time does not pass for mystical items
    }

    @Override
    protected void adjustAccordingToNewSellInValue() {
        // SellIn value does not affect mystical items
    }
}
