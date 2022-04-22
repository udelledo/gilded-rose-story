package com.gildedrose.products;

import com.gildedrose.Item;

/**
 * This implementation is used for event based products.
 * After the sellIn date is passed the quality is fixed to zero
 * While the date of the event is getting closer the value of the item increase accordingly.
 * 
 * <ul>
 *     <li>1 point every day</li>
 *     <li>1 additional point if the sellIn date is less than 11</li>
 *     <li>1 additional point if the sellIn date is also less than 6</li>
 * </ul>
 */
public class EventProduct extends ItemQuantityDailyProcessor {
    protected EventProduct(Item item) {
        super(item);
    }

    @Override
    protected void applyBasicUpdates() {
        quantityUpdater.increaseQuality(getItem());

        if (getItem().sellIn < 11) {
            quantityUpdater.increaseQuality(getItem());
        }

        if (getItem().sellIn < 6) {
            quantityUpdater.increaseQuality(getItem());
        }

    }

    @Override
    protected void adjustAccordingToNewSellInValue() {
        if (getItem().sellIn < 0) {
            getItem().quality = 0;
        }
    }
}
