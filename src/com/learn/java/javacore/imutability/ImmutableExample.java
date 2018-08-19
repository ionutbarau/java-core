package com.learn.java.javacore.imutability;

/**
 * An object is considered immutable if its state cannot change after it is constructed.
 * Immutable objects are particularly useful in concurrent applications. Since they cannot change state,
 * they cannot be corrupted by thread interference or observed in an inconsistent state.
 *
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 16/08/2018.
 * Time: 15:52
 */

import java.util.Date;

/**
 * The class should be marked as final in order to not allow subclasses to override methods.
 * A more sophisticated approach is to make the constructor private and construct instances in factory methods.
 */

public final class ImmutableExample {

    /**
     * Fields should be private and final. No setter should be provided.
     * If the fields contain references to mutable objects, don't allow this objects to be changed. Provide a copy of them in getters
     */
    private final String field1;

    private final Date field2;

    public ImmutableExample(String field1, Date field2){
        this.field1 = field1;
        this.field2 = field2;
    }

    /**
     * No need to return a copy because String is itself immutable.
     * @return field1
     */
    public String getField1(){
        return field1;
    }

    /**
     * Return a copy because Date is mutable
     * @return a copy of field 2
     */
    public Date getField2(){
        Date d = new Date(field2.getTime());
        return d;
    }
}
