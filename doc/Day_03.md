# Day 03

There's something weird going on. Or at least it's what our approved file shows.

We have discrepancies between the stated requirements and the results of the running application on the items:

* The Quality of an item is never more than 50
* The Quality of an item is never negative
* "Sulfuras" quality is 80 and it never alters.


### The Quality of an item is never more than 50

If this point were correctly implemented, how come that we have items with higher quality?

```
+5 Dexterity Vest, -1, 78
Aged Brie, 1, 80
Backstage passes to a TAFKAL80ETC concert, 1, 80
```

### The Quality of an item is never negative

To test this scenario we try to modify our test to include a negative quality and see if the system filters it out.

As a matter of fact the negative qualities are processed and there's no real check or effect when an Item is initialized with a negative quality.

### "Sulfuras" quality is 80 and it never alters.

We have several _Sulfuras_ with the wrong state.

```
Sulfuras, Hand of Ragnaros, -1, 80
Sulfuras, Hand of Ragnaros, 0, -1
Sulfuras, Hand of Ragnaros, 0, 0
```
