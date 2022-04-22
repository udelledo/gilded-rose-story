# Day Five

Ok, we are happy with our current implementation, and how we managed to refactor the GildedRose class encapsulating all
the different logics in their own classes.

The customer is still happy and doesn't have any request for the moment.

Might be a good time to mention to him the discrepancies we found in [Day 3](Day_03.md) between the requirements
expressed by the customer and the behavior observed in the application.

### "Sulfuras" quality is 80 and it never alters.
We can start by fixing the quality of the **Sulfura** item.

The requirement state that it should have a fixed value of 80.

We could use a fixed value in the _**NoChangeProduct**_ class, or even better we could rename it to _**
FixedQualityProduct**_ and provide to it the expected value during initialization.

This change will affect our current approved snapshot, but at least we will never see a bad quality **Sulfura**.

### The Quality of an item is never more than 50

This can be easily achieved making sure that at the beginning of our ItemQuantityDailyProcessor.

Introducing this simple line
```
    getItem().quality = Math.max(0, Math.min(50, getItem().quality));
```
we guarantee that the quality is never less than 0 or higher than 50.

Only Mystical items will be allowed to have an arbitrary quality.