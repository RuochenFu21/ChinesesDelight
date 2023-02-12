package net.forsteri.chinesesdelight.contents.foods;

import net.forsteri.chinesesdelight.contents.foods.customizable.CustomRecipeHandler;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class RawDumplingProduct extends Item {
    public RawDumplingProduct(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, @NotNull TooltipFlag p_41424_) {
        p_41423_.addAll(Arrays.stream(p_41421_.getOrCreateTag().getIntArray("fillings"))
                .mapToObj(i ->
                        new TranslatableComponent(CustomRecipeHandler.supportedFillings().get(i).asItem().getDescriptionId())
                                .withStyle(new ChatFormatting[]{ChatFormatting.GRAY})
                ).toList());
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
    }
}
