
public class Asociacion<K, V> {


	protected K key;
	protected V value;

	public Asociacion(){

	}
	   /**
     * Constructor de un nodo con una key y un value.
     *
     * @pre key no debe ser null
     * @post construir el par de key-value
     * @param key un objeto que no sea null.
     * @param value A (posiblemente null) object.
     */
	 public Asociacion(K key, V value)
	    {

	        this.key = key;
	        this.value = value;
	    }

	  /**
	     * Standard comparison function.  Comparison based on keys only.
	     *
	     * @pre other is non-null Association
	     * @post returns true iff the keys are equal
	     * @param other Another association.
	     * @return true iff the keys are equal.
	     */
	    public boolean equals(Object other)
	    {
	        Asociacion otherAssoc = (Asociacion)other;
	        return getKey().equals(otherAssoc.getKey());
	    }
	    

	 /**
     * Standard hashcode function.
     *
     * @post return hash code association with this association
     * @return A hash code for association.
     * @see Hashtable
     */
    public int hashCode()
    {
        return getKey().hashCode();
    }

    /**
     * Fetch value from association.  May return null.
     *
     * @post returns value from association
     * @return The value field of the association.
     */
    public V getValue()
    {
        return value;
    }

    /**
     * Fetch key from association.  Should not return null.
     *
     * @post returns key from association
     * @return Key of the key-value pair.
     */
    public K getKey()
    {
        return key;
    }
  
    /**
     * Sets the value of the key-value pair.
     *
     * @post sets association's value to value
     * @param value The new value.
     */
    public V setValue(V value)
    {
        V oldValue = value;
        value = value;
        return oldValue;
    }

    /**
     * Standard string representation of an association.
     *
     * @post returns string representation
     * @return String representing key-value pair.
     */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("\n"+" DPI: "+getKey()+" name: "+getValue());
        return s.toString();
    }
}
