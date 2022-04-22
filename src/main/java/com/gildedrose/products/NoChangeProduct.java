package com.gildedrose.products;

import com.gildedrose.Item;


/**
 * This is a special item that does not change anything. It is used for mystical elements.
 */
public class NoChangeProduct extends ItemQuantityDailyProcessor {
    protected NoChangeProduct(Item item) {
        super(item);
    }

    @Override
    protected void applyBasicUpdates() {
        // Mystical items do not degrade nor improve.
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
