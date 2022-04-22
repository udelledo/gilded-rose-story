package com.gildedrose.products;

import com.gildedrose.Item;

/**
 * This product is the primary behavior for most grocery goods, and more generally perishable items.
 */
public class PerishableProduct extends ItemQuantityDailyProcessor {
    protected PerishableProduct(Item item) {
        super(item);
    }

    @Override
    protected void applyBasicUpdates() {
        quantityUpdater.decreaseQuality(getItem());
    }

    @Override
    protected void adjustAccordingToNewSellInValue() {
        if (getItem().sellIn < 0) {
            quantityUpdater.decreaseQuality(getItem());
        }
    }
}
