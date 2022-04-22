package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void verificationTest() {
        List<String> itemNames = Arrays.asList(
                "+5 Dexterity Vest",
                "Aged Brie",
                "Clojure",
                "Elixir of the Mongoose",
                "Sulfuras, Hand of Ragnaros",
                "Backstage passes to a TAFKAL80ETC concert"
        );
        List<Integer> sellIns = Arrays.asList(10, 2, 5, 0, -1, 15, 3);
        List<Integer> qualities = Arrays.asList(20, 0, 7, 80, 20, 49, 6, -1);
        Item[] itemsList = itemNames.stream()
                .flatMap(name -> sellIns.stream()
                        .flatMap(sellIn -> qualities.stream()
                                .map(quality ->
                                        new Item(name, sellIn, quality))))
                .toArray(Item[]::new);
        GildedRose app = new GildedRose(itemsList);

        Approvals.verifyAll("Daily Item Report", IntStream.range(1, 15).boxed().toArray(), day -> {
            app.updateQuality();
            return "Items after day " + day + System.lineSeparator() + itemToString(itemsList);
        });
    }

    private String itemToString(Item[] itemsList) {
        return Arrays.stream(itemsList)
                .map(Objects::toString)
                .sorted()
                .collect(Collectors.joining(System.lineSeparator()));
    }

}
