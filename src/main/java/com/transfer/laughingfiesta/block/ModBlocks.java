package com.transfer.laughingfiesta.block;



import java.util.function.Supplier;

import com.transfer.laughingfiesta.LaughingFiesta;
import com.transfer.laughingfiesta.items.ModItems;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(LaughingFiesta.MODID);

    public static final DeferredBlock<Block> KILO_OF_COCAINE = registerBlock("kilo_of_cocaine", () -> 
    new Block(BlockBehaviour.Properties.of()
    .strength(0.5f)
    .requiresCorrectToolForDrops()));
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        
    }

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
        
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        
    }
    
}
