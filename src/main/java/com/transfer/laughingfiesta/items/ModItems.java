package com.transfer.laughingfiesta.items;

import com.transfer.laughingfiesta.LaughingFiesta;
import com.transfer.laughingfiesta.items.custom.ChistelItem;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LaughingFiesta.MODID);

    public static final DeferredItem<Item> COCAINE = ITEMS.register("cocaine", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> KETAMINE = ITEMS.register("ketamine", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel", 
    () -> new ChistelItem(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
