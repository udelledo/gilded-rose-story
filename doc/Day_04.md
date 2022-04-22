# Day Four

Our client is happy, but we know that it will not last. New changes will be coming any time soon.


> We'd better get started

## Simplify

Since we put safeguard into the quality manipulation, we can safely get rid of the several if condition left in _updateQuality_.

And to simplify it further we can **invert if condition** all the _if/else_ statement that include a `!`

### Defining responsibilities

Now that the flow is more simple to read we look, we notice that there are three main points in the business logic of our customer are:

* Process basic rule on quality
* Mark day passed
* Apply processing for item with complex degradation rules based on the sell in date

All the rules for all the products are written inside the **_GildedRose_** class, this sounds like too much responsibility for this class!!!

We should lift some of its burden.

It should be nice if the logic specific to each product or product type would be separate from all other code.

We can introduce the interface _QuantityProcessor_ to mark the process of updating

We can abstract two main types of products on which to desing some interfaces

