# Day Four

Our client is happy, but we know that it will not last. New changes will be coming any time soon.


> We'd better get started

### Simplify

Since we put safeguard into the quality manipulation, we can safely get rid of the several if condition left in _
updateQuality_.

And to simplify it further we can **invert if condition** all the _if/else_ statement that include a `!`

---

### Defining responsibilities

Now that the flow is more simple to read we take a closer look, and we notice that there are three main points in the
business logic of
our customer are:

* Process basic rule on quality
* Mark day passed
* Apply processing for item with complex degradation rules based on the sell in date

All the rules for all the products are written inside the **_GildedRose_** class, this sounds like too much
responsibility for this class!!!

We should lift some of its burden.

So far we have some general rules and few exceptions, and it is a good moment to introduce the interface _
QuantityDailyProcessor_ to define the binding contract of updating the quality on a daily basis.

We can implement several flavor of QuantityDailyProcessor, trying to generify and reuse as much as possible.

We end up with the following list:

* PerishableProduct: This is going to be the default
* SeasonedProduct: This is going to be used for the **Aged Brie**
* EventProduct: This is going to be used for the **Backstage pass**
* NoChangeProduct: This will be used for the **Sulfuras**
* HighlyPerishableProduct: This is going to be used by the **Clojure**

With these implementations now we are only missing a way to map the _Item_ so dear to the owner of the Inn to the proper
implementation of QuantityDailyProcess type.

The body of our GildedRose class is now free from all the clutter and looks like this:
```java
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
```

Regardless all these _"big changes"_, the application we are maintaining has not stopped working for a moment, and we could verify it.

**In the end our mutation coverage is still 100%!!!**