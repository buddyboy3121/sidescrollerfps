package org.thrawn.item;

import org.thrawn.player.Entity;

public class ItemWeapon implements Item {
	
	private String name;
	private String id;
	private ItemTier tier;
	
	private float damageMax;
	private float damageMin;
	
	private float criticalDamageMax;
	private float criticalDamageMin;
		
	private float headDamageMax;
	private float headDamageMin;
	
	public ItemWeapon(String name, String id, ItemTier tier) {
		this.name = name;
		this.id = id;
		this.tier = tier;
	}
	
	@Override
	public final String getName() {
		return this.name;
	}

	@Override
	public final String getIdentifier() {
		return this.id;
	}

	@Override
	public final ItemTier getTier() {
		return this.tier;
	}
	
	/**
	 * Occurs when a critical hit has been made to an {@link Entity}.
	 * @param damage The damage done to the {@link Entity}.
	 * @param victim The victim that took the damage.
	 */
	public void onCriticalHit(int damage, Entity victim) {}
	
	/**
	 * Occurs when damage has been done to another {@link Entity}.
	 * @param damage The damage done to the {@link Entity}.
	 * @param victim The victim that took the damage.
	 */
	public void onDamage(int damage, Entity victim) {}
	
	/**
	 * Occurs when damage has been made to an {@link Entity}'s head.
	 * @param damage The damage done to the {@link Entity}.
	 * @param victim The victim that took the damage.
	 */
	public void onHeadHit(int damage, Entity victim) {}
	
	/**
	 * Returns the damage this weapon does to other entities at maximum.<br>
	 * This is for both other Entities and Players.
	 * @return the maximum damage.
	 */
	public float getDamageMaximum() {
		return this.damageMax;
	}
	
	/**
	 * Returns the damage this weapon does to other entities at minimum.<br>
	 * This is for both other Entities and Players.
	 * @return the minimum damage.
	 */
	public final float getDamageMinimum() {
		return this.damageMin;
	}
	
	/**
	 * Returns the damage this weapon does at maximum when a critical hit has been made.<br>
	 * This is for both other Entities and Players.
	 * @return the maximum critical damage.
	 */
	public final float getCriticalDamageMaximum() {
		return this.criticalDamageMax;
	}
	
	/**
	 * Returns the damage this weapon does at minimum when a critical hit has been made.<br>
	 * This is for both other Entities and Players.
	 * @return the minimum critical damage.
	 */
	public final float getCriticalDamageMinimum() {
		return this.criticalDamageMin;
	}
	
	/**
	 * Returns the damage this weapon does at maximum when a hit to the head has been made.<br>
	 * This is for both other Entities and Players.
	 * @return the maximum head damage.
	 */
	public final float getHeadDamageMaximum() {
		return this.headDamageMax;
	}
	
	/**
	 * Returns the damage this weapon does at minimum when a hit to the head has been made.<br>
	 * This is for both other Entities and Players.
	 * @return the minimum head damage.
	 */
	public final float getHeadDamageMinimum() {
		return this.headDamageMin;
	}
	
}
