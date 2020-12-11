package me.hydos.arms.block;

import io.netty.buffer.ByteBuf;
import me.hydos.arms.block.blockentity.ArmChipBlockEntity;
import me.hydos.arms.network.Networking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ArmChipBlock extends BlockWithEntity {

	public ArmChipBlock(Settings settings) {
		super(settings.nonOpaque());
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	@Nullable
	@Override
	public BlockEntity createBlockEntity(BlockView world) {
		return new ArmChipBlockEntity();
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if(!world.isClient()){
			PacketByteBuf buf = PacketByteBufs.create().writeBlockPos(pos);
			ServerPlayNetworking.send((ServerPlayerEntity) player, Networking.OPEN_COOL_SCREEN, buf);
		}
		return ActionResult.SUCCESS;
	}
}
