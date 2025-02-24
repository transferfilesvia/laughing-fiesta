package com.transfer.laughingfiesta.items.custom;

import java.util.Map;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.server.level.ServerLevel;

public class ChistelItem extends Item{
    private static final Map<Block, Block> CHISEL_MAP = Map.of(
        Blocks.STONE, Blocks.COBBLESTONE,
        Blocks.COBBLESTONE, Blocks.GRAVEL,
        Blocks.GRAVEL, Blocks.SAND,
        Blocks.SAND, Blocks.SANDSTONE
    );



    public ChistelItem(Properties properties) {
        super(properties);
        //TODO Auto-generated constructor stub
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)){
            if (!level.isClientSide) {
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());


                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(), 
                item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
            }
        }
        return super.useOn(context);
    }
    
}
