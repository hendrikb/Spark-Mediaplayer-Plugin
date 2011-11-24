package com4j.itunes  ;

import com4j.*;

/**
 * IITSourceCollection Interface
 */
@IID("{2FF6CE20-FF87-4183-B0B3-F323D047AF41}")
public interface IITSourceCollection extends Com4jObject,Iterable<Com4jObject> {
  // Methods:
  /**
   * <p>
   * Returns the number of sources in the collection.
   * </p>
   * <p>
   * Getter method for the COM property "Count"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(1610743808) //= 0x60020000. The runtime will prefer the VTID if present
  @VTID(7)
  int count();


  /**
   * <p>
   * Returns an IITSource object corresponding to the given index (1-based).
   * </p>
   * <p>
   * Getter method for the COM property "Item"
   * </p>
   * @param index Mandatory int parameter.
   * @return  Returns a value of type com4j.itunes.IITSource
   */

  @DISPID(0) //= 0x0. The runtime will prefer the VTID if present
  @VTID(8)
  @DefaultMethod
  com4j.itunes.IITSource item(
    int index);


  /**
   * <p>
   * Returns an IITSource object with the specified name.
   * </p>
   * <p>
   * Getter method for the COM property "ItemByName"
   * </p>
   * @param name Mandatory java.lang.String parameter.
   * @return  Returns a value of type com4j.itunes.IITSource
   */

  @DISPID(1610743810) //= 0x60020002. The runtime will prefer the VTID if present
  @VTID(9)
  com4j.itunes.IITSource itemByName(
    java.lang.String name);


  /**
   * <p>
   * Returns an IEnumVARIANT object which can enumerate the collection.
   * </p>
   * <p>
   * Getter method for the COM property "_NewEnum"
   * </p>
   */

  @DISPID(-4) //= 0xfffffffc. The runtime will prefer the VTID if present
  @VTID(10)
  java.util.Iterator<Com4jObject> iterator();

  /**
   * <p>
   * Returns an IITSource object with the specified persistent ID.
   * </p>
   * <p>
   * Getter method for the COM property "ItemByPersistentID"
   * </p>
   * @param highID Mandatory int parameter.
   * @param lowID Mandatory int parameter.
   * @return  Returns a value of type com4j.itunes.IITSource
   */

  @DISPID(1610743812) //= 0x60020004. The runtime will prefer the VTID if present
  @VTID(11)
  com4j.itunes.IITSource itemByPersistentID(
    int highID,
    int lowID);


  // Properties:
}
