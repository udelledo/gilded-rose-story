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

Nonetheless the owner has asked us to update the application to include the **Clojure** item.

The requirement is:
>- "Conjured" items degrade in Quality twice as fast as normal items

So let's get into the code and understand how to implement the requirement.

## Getting handle of the code

Many of the functionalities used now are available in most of the latest IDE.
At the time of writing IntelliJ Idea is the tool of choice.


### Extract variables
First thing that pops to the eye is the amount of array access to get the item
```
items[i]
```
Let's **extract a variable**; it will help us keep track of the item processed in the loop without too much thought.

### Flip equals

There are lots of calls to an equals of a possibly null object that could raise a NullPointerException.
```
item.name.equals("Aged Brie")
```
This can be avoided by _flipping the .equals()_
```
"Aged Brie".equals(item.name)
```

### Extract methods

The _.equals()_ calls found so fare are repeated around the code, and might be useful to extract them as specific methods.
For example
```
"Aged Brie".equals(item.name)
```
could become
```
private boolean isAgedBrie(Item item) {
    return "Aged Brie".equals(item.name);
}
```

In some cases the IDE can offer to change the signature of the extracted method so that it accepts also the string used to invoke the _.equals()_
```
private boolean isAgedBrie(Item item, String name) {
    return name.equals(item.name);
}
```
and capture all other name checks available in the code block.

As of now there's no reason to make this method so flexible, and we are happy replacing all the other places were it was used..

We repeat the process for all other name check.

### Merge nested if statements

The previous developer had a really strange way to think of the problem and all the nested if statements show it.

It's time to merge the one that don't have to be separated and let's see if we can get some order from them.

For example 
```
if (item.quality > 0) {
    if (!isSulfuras(item)) {
        item.quality = item.quality - 1;
    }
}
```

could become
```
if (item.quality > 0 && !isSulfuras(item)) {
    item.quality = item.quality - 1;
}
```

## Checkup point

I'm about to describe what we should have done at each one of the changes above, but for simplicity I'll write just here.

>TEST!!!!

Since we defined it as dependency we can directly execute **pitest** to make sure that our changes didn't break anything.

```
 Statistics
================================================================================
>> Line Coverage: 36/36 (100%)
>> Generated 43 mutations Killed 43 (100%)
>> Mutations with no coverage 0. Test strength 100%
>> Ran 85 tests (1.98 tests per mutation)
```

_So far so good!_
