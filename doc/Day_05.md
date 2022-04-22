# Day Five

Ok, we are happy with our current implementation, and how we managed to refactor the GildedRose class encapsulating all
the different logics in their own classes.

The customer is still happy and doesn't have any request for the moment.

Might be a good time to mention to him the discrepancies we found in [Day 3](Day_03.md) between the requirements
expressed by the customer and the behavior observed in the application.

We can start by fixing the quality of the **Sulfura** item.

The requirement state that it should have a fixed value of 80.

We could use a fixed value in the _**NoChangeProduct**_ class, or even better we could rename it to _**
FixedQualityProduct**_ and provide to it the expected value during initialization.

This change will affect our current approved snapshot, but at least we will never see a bad quality **Sulfura**.