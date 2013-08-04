package org.item;

public interface Item {

	/**
	 * Returns the name of the Item.
	 * @return the name.
	 */
	public String getName();
	
	/**
	 * Returns the Tier of the Item, representing how expensive it was.
	 * @return the Tier.
	 */
	public ItemTier getTier();
	
}
