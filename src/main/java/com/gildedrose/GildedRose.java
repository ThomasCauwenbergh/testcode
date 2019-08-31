package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    /* refactored version */
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Denote(items[i]);
        }
    }


    private void Denote(Item item){
        switch (item.name){
            case "Conjured Mana Cake":
                DenoteConjuredItem(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                increaseQualityBackstagePasses(item);
                break;
            case "Aged Brie":
                increaseQualityAgedBrie(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                DenoteItem(item);
                break;
        }
        if(!item.name.equals("Sulfuras, Hand of Ragnaros"))
        item.sellIn -= 1;
    }

    private void DenoteItem(Item item){
        if (item.quality > 0) {
            item.quality -= 1;
        }
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality -= 1;
            }
        }
    }

    private void DenoteConjuredItem(Item item){
        if (item.sellIn >= 0) {
            if (item.quality >= 2) {
                item.quality -= 2;
            }
        }
        else {
            if (item.quality >=4) {
                item.quality -= 4;
            }
        }
    }

    private void increaseQualityAgedBrie(Item item){
        if (item.quality < 50){
            item.quality += 1;
        }
    }

    private void increaseQualityBackstagePasses(Item item){
        if (item.quality < 50){
            item.quality += 1;
        }
        if (item.sellIn <= 10){
            if (item.quality < 50){
                item.quality += 1;
            }
        }
        if (item.sellIn <= 5){
            if (item.quality < 50){
                item.quality += 1;
            }
        }
        if (item.sellIn <= 0){
            item.quality = 0;
        }
    }




}



