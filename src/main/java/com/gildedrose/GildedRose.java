package com.gildedrose;

import com.gildedrose.products.ProductProcessorFactory;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    ProductProcessorFactory productProcessorFactory = new ProductProcessorFactory();
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(this::processItem);
    }

    private void processItem(Item item) {
        productProcessorFactory.getProduct(item).processDailyQuantityUpdate();
    }
}