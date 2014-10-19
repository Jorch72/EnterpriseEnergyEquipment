package me.planetguy.endgamerf.api;

import java.util.Iterator;

import net.minecraft.item.ItemStack;

public interface IMachineCore {
	
	/**
	 * Takes input from side modules
	 * @param form the type being passed. See Types for some standard types; alternate types may be implemented by other mods.
	 * @param input the object passed in, in whatever type is specified.
	 * @return whatever is rejected by the machine
	 */
	public Object onReceive(String form, Object input);
	
	
	/**
	 * Returns an iterator of the outputs available in the specified form.
	 * @param form the form you are extracting in; specifies the type.
	 * @return the iterator
	 */
	public Iterator outputs(String form);
	
	/**
	 * Returns an iterator over the contents of this machine, in the given form
	 * @param form the form you are extracting in; specifies the type.
	 * @return the iterator
	 */
	public Iterator contents(String form);
	
	/**
	 * @return the client-side GUI to display
	 */
	public IMachineGui getGui();

}
