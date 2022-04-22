package com.gildedrose.products;

import com.gildedrose.Item;

public class ProductProcessorFactory {
    public ItemQuantityDailyProcessor getProduct(Item item) {
        switch (item.name) {
            case Constants.AGED_BRIE:
                return new SeasonedProduct(item);
            case Constants.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                return new EventProduct(item);
            case Constants.SULFURAS_HAND_OF_RAGNAROS:
                return new FixedQualityProduct(item, 80);
            case Constants.CLOJURE:
                return new HighlyPerishableProduct(item);
            default:
                return new PerishableProduct(item);
        }
    }
}
