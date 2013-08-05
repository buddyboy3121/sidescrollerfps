package org.item;

public class ItemGunWeapon extends ItemWeapon {

	private int ammunation;
	private int magazines;
	private int magAmmo;
	
	public ItemGunWeapon(String name, String id, ItemTier tier {
		super(name, id, tier);
	}

	/**
	 * Fire the gun.<br>
	 * This automatically removes ammunation from the magazine.<br>
	 * When there's no magazines left, an event will be thrown.
	 */
	public final void fire() {
		if (ammunation >= 1) {         			// Checks if there's any ammunation left in the magazine.
			ammunation--;			   			// Removes ammunation from the magazine. (bullets has been shot)
			onFire();							// Raises the onFire() event to notify that a shot has been made.
		} else {
			onAmmunationEmpty();
			if (magazines >= 1) {      			// Checks if there are any magazines left.
				ammunation += magAmmo; 			// Adds new ammunation from the magazines. (reloads)
				magazines--; 		   			// Removes the magazine that the ammunation was taken from. (takes a magazine)
				onMagazineChange(magazines);	// Raises the onMagazineChange() event to notify that the magazine has been changed.
				onReload();						// Raises the onReload() event to notify that a reload of the gun has been made.
			} else {
				onMagazineEmpty();				// Raises the onMagazineEmpty() event to notify that there are no more magazines.
			}
		}
	}
	
	/**
	 * Occurs when a bullet has been fired.
	 */
	public void onFire() {}
	
	/**
	 * Occurs when the magazine of the gun is empty.<br>
	 * You can refill the ammunation by picking up a gun of the same type.
	 */
	public void onMagazineEmpty() {}
	
	/**
	 * Occurs when the magazine is being changed.
	 * @param magazine The magazine the gun is being changed to.
	 */
	public void onMagazineChange(int magazine) {}
	
	/**
	 * Occurs when the ammunation of a magazine is full.
	 */
	public void onAmmunationFull() {}
	
	/**
	 * Occurs when the ammunation of a magazine is empty.
	 */
	public void onAmmunationEmpty() {}
	
	/**
	 * Occurs when the gun is being reloaded.<br>
	 * This is the event to be used for reloading timings.
	 */
	public void onReload() {}
	
}
