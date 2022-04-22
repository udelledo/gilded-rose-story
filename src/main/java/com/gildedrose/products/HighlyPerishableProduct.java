package com.gildedrose.products;

import com.gildedrose.Item;

/**
 * This implementation decreases twice as fast as a {@link PerishableProduct}.
 */
public class HighlyPerishableProduct extends PerishableProduct {
    protected HighlyPerishableProduct(Item item) {
        super(item);
    }

    @Override
    protected void applyBasicUpdates() {
        quantityUpdater.decreaseQuality(getItem());
        quantityUpdater.decreaseQuality(getItem());
    }

}
