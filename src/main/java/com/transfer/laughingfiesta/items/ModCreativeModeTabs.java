package com.transfer.laughingfiesta.items;
import com.transfer.laughingfiesta.block.ModBlocks;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

import com.transfer.laughingfiesta.LaughingFiesta;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LaughingFiesta.MODID);


    public static final Supplier<CreativeModeTab> DRUGS_TAB = CREATIVE_MODE_TAB.register("drugs_tab", 
    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COCAINE.get()))
        .title(Component.translatable("creativetab.laughingfiesta.drugs_items"))
        .displayItems((itemDisplayParameters, output) -> {
            output.accept(ModItems.COCAINE);
            output.accept(ModItems.KETAMINE);
        }).build());

    public static final Supplier<CreativeModeTab> DRUGBLOCKS_TAB = CREATIVE_MODE_TAB.register("drugblocks_tab", 
    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.KILO_OF_COCAINE.get()))
        .withTabsBefore(ResourceLocation.fromNamespaceAndPath(LaughingFiesta.MODID, "drugs_tab"))
        .title(Component.translatable("creativetab.laughingfiesta.drug_blocks"))
        .displayItems((itemDisplayParameters, output) -> {
            output.accept(ModBlocks.KILO_OF_COCAINE);
        }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }


    
}
