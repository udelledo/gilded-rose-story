package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isDecreasingItem(item)) {
                if (item.quality > 0 && !isSulfuras(item)) {
                    decreaseQuality(item);
                }
                if (isClojure(item)) {
                    decreaseQuality(item);
                }
            } else {
                if (item.quality < 50) {
                    increaseQuality(item);

                    if (isBackStagePass(item)) {
                        if (item.sellIn < 11 && item.quality < 50) {
                            increaseQuality(item);
                        }

                        if (item.sellIn < 6 && item.quality < 50) {
                            increaseQuality(item);
                        }
                    }
                }
            }

            if (!isSulfuras(item)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!isAgedBrie(item)) {
                    if (!isBackStagePass(item)) {
                        if (item.quality > 0 && !isSulfuras(item)) {
                            decreaseQuality(item);
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        increaseQuality(item);
                    }
                }
            }
        }
    }

    private boolean isClojure(Item item) {
        return "Clojure".equals(item.name);
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private boolean isDecreasingItem(Item item) {
        return !isAgedBrie(item)
                && !isBackStagePass(item);
    }

    private boolean isSulfuras(Item item) {
        return "Sulfuras, Hand of Ragnaros".equals(item.name);
    }

    private boolean isBackStagePass(Item item) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(item.name);
    }

    private boolean isAgedBrie(Item item) {
        return "Aged Brie".equals(item.name);
    }
}