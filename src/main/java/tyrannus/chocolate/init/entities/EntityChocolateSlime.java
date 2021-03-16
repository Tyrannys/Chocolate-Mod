package tyrannus.chocolate.init.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.JumpGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Items;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import tyrannus.chocolate.setup.ModEntities;

import java.util.Random;

public class EntityChocolateSlime extends SlimeEntity {
    public EntityChocolateSlime(EntityType<? extends EntityChocolateSlime> type, World worldIn) {
        super(type, worldIn);
    }




    public static AttributeModifierMap.MutableAttribute func_234294_m_() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.2F);
    }
    public static boolean func_223367_b(EntityType<EntityChocolateSlime> p_223367_0_, IWorld p_223367_1_, SpawnReason p_223367_2_, BlockPos p_223367_3_, Random p_223367_4_) {
        return p_223367_1_.getDifficulty() != Difficulty.PEACEFUL;
    }

    public boolean isNotColliding(IWorldReader worldIn) {
        return worldIn.checkNoEntityCollision(this) && !worldIn.containsAnyLiquid(this.getBoundingBox());
    }
    public EntityType<? extends EntityChocolateSlime> getType() {
        return (EntityType<? extends EntityChocolateSlime>)super.getType();
    }

    protected void setSlimeSize(int size, boolean resetHealth) {
        super.setSlimeSize(size, resetHealth);
        this.getAttribute(Attributes.ARMOR).setBaseValue((double)(size * 3));
    }
    protected int getJumpDelay() {
        return super.getJumpDelay() * 4;
    }

    protected void alterSquishAmount() {
        this.squishAmount *= 0.9F;
    }

    protected void jump() {
        Vector3d vector3d = this.getMotion();
        this.setMotion(vector3d.x, (double)(this.getJumpUpwardsMotion() + (float)this.getSlimeSize() * 0.1F), vector3d.z);
        this.isAirBorne = true;
        net.minecraftforge.common.ForgeHooks.onLivingJump(this);
    }
    protected void handleFluidJump(ITag<Fluid> fluidTag) {
        if (fluidTag == FluidTags.LAVA) {
            Vector3d vector3d = this.getMotion();
            this.setMotion(vector3d.x, (double)(0.22F + (float)this.getSlimeSize() * 0.05F), vector3d.z);
            this.isAirBorne = true;
        } else {
            super.handleFluidJump(fluidTag);
        }

    }
    protected boolean canDamagePlayer() {
        return this.isServerWorld();
    }

    protected float func_225512_er_() {
        return super.func_225512_er_() + 2.0F;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return this.isSmallSlime() ? SoundEvents.ENTITY_MAGMA_CUBE_HURT_SMALL : SoundEvents.ENTITY_MAGMA_CUBE_HURT;
    }

    protected SoundEvent getDeathSound() {
        return this.isSmallSlime() ? SoundEvents.ENTITY_MAGMA_CUBE_DEATH_SMALL : SoundEvents.ENTITY_MAGMA_CUBE_DEATH;
    }

    protected SoundEvent getSquishSound() {
        return this.isSmallSlime() ? SoundEvents.ENTITY_MAGMA_CUBE_SQUISH_SMALL : SoundEvents.ENTITY_MAGMA_CUBE_SQUISH;
    }

    protected SoundEvent getJumpSound() {
        return SoundEvents.ENTITY_MAGMA_CUBE_JUMP;
    }
}
