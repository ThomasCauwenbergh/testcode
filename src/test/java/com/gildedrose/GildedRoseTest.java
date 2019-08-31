package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    private GildedRose gildedRose;

    public void CreateNewApp(String name, int sellin, int quality){
        Item[] items = new Item[] { new Item(name, sellin, quality) };
        gildedRose = new GildedRose(items);
    }

    public void IsItemEqual(String name, int sellin, int quality){
        assertEquals(name, gildedRose.items[0].name);
        assertEquals(sellin, gildedRose.items[0].sellIn);
        assertEquals(quality, gildedRose.items[0].quality);
    }



    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }




    @Test
    public void ItemQualityIsNeverNegativeTest(){
        CreateNewApp("foo", 2, 0);
        gildedRose.updateQuality();
        IsItemEqual("foo", 1, 0);
    }


    @Test
    public void ConjuredQualityIsNeverNegativeTest(){
        CreateNewApp("Conjured Mana Cake", 2, 0);
        gildedRose.updateQuality();
        IsItemEqual("Conjured Mana Cake", 1, 0);
    }



    @Test
    public void AgedBrieQualityIsNeverHigherThan50Test(){
        CreateNewApp("Aged Brie", 3, 49);
        gildedRose.updateQuality();
        IsItemEqual("Aged Brie", 2, 50);
        gildedRose.updateQuality();
        IsItemEqual("Aged Brie", 1, 50);

    }

    @Test
    public void BackstagePassQualityIsNeverHigherThan50Test(){
        CreateNewApp("Backstage passes to a TAFKAL80ETC concert", 3, 49);
        gildedRose.updateQuality();
        IsItemEqual("Backstage passes to a TAFKAL80ETC concert", 2, 50);
        gildedRose.updateQuality();
        IsItemEqual("Backstage passes to a TAFKAL80ETC concert", 1, 50);

    }

    @Test
    public void QualityDegradesTwiceAsFastPastSellDateTest(){
        CreateNewApp("foo", 1, 10);
        gildedRose.updateQuality();
        IsItemEqual("foo", 0, 9);
        gildedRose.updateQuality();
        IsItemEqual("foo", -1, 8);
        gildedRose.updateQuality();
        IsItemEqual("foo", -2, 6);
    }

    @Test
    public void SulfurasValueDoesNotCHangeTest(){
        CreateNewApp("Sulfuras, Hand of Ragnaros", 5, 80);
        gildedRose.updateQuality();
        IsItemEqual("Sulfuras, Hand of Ragnaros", 5, 80);
    }

    @Test
    public void BackstagePassIncreaseInQualityLifecycleTest(){
        CreateNewApp("Backstage passes to a TAFKAL80ETC concert", 11, 10);
        gildedRose.updateQuality();
        IsItemEqual("Backstage passes to a TAFKAL80ETC concert", 10, 11);
        gildedRose.updateQuality();
        IsItemEqual("Backstage passes to a TAFKAL80ETC concert", 9, 13);
        gildedRose.updateQuality();
        IsItemEqual("Backstage passes to a TAFKAL80ETC concert", 8, 15);
        gildedRose.updateQuality();
        IsItemEqual("Backstage passes to a TAFKAL80ETC concert", 7, 17);
        gildedRose.updateQuality();
        IsItemEqual("Backstage passes to a TAFKAL80ETC concert", 6, 19);
        gildedRose.updateQuality();
        IsItemEqual("Backstage passes to a TAFKAL80ETC concert", 5, 21);
        gildedRose.updateQuality();
        IsItemEqual("Backstage passes to a TAFKAL80ETC concert", 4, 24);
        gildedRose.updateQuality();
        IsItemEqual("Backstage passes to a TAFKAL80ETC concert", 3, 27);
        gildedRose.updateQuality();
        IsItemEqual("Backstage passes to a TAFKAL80ETC concert", 2, 30);
        gildedRose.updateQuality();
        IsItemEqual("Backstage passes to a TAFKAL80ETC concert", 1, 33);
        gildedRose.updateQuality();
        IsItemEqual("Backstage passes to a TAFKAL80ETC concert", 0, 36);
        gildedRose.updateQuality();
        IsItemEqual("Backstage passes to a TAFKAL80ETC concert", -1, 0);
    }

    @Test
    public void ConjuredItemsDegradeTwiceAsFastTest(){
        CreateNewApp("Conjured Mana Cake", 2, 30);
        gildedRose.updateQuality();
        IsItemEqual("Conjured Mana Cake", 1, 28);
        gildedRose.updateQuality();
        IsItemEqual("Conjured Mana Cake", 0, 26);
        gildedRose.updateQuality();
        IsItemEqual("Conjured Mana Cake", -1, 24);
        gildedRose.updateQuality();
        IsItemEqual("Conjured Mana Cake", -2, 20);
    }










}
