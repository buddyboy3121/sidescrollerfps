package org.thrawn.item;

public interface Item {

	/**
	 * Returns the name of the Item.
	 * @return the name.
	 */
	public String getName();
	
	/**
	 * Returns the unique identifier of the item.<br>
	 * It must be different from all the other item's identifiers.
	 * @return the identifier.
	 */
	public String getIdentifier();
	
	/**
	 * Returns the Tier of the Item, representing how expensive it was.
	 * @return the Tier.
	 */
	public ItemTier getTier();
	
}
