package model;

public interface CreateID {
    /**
     * This is an abstract method that returns a String and is used to create an ID.
     * 
     * @return A String is being returned. The method signature indicates that the method is abstract,
     * which means that it does not have an implementation in the current class and must be implemented
     * by any concrete subclass. The purpose of the method is to create and return an ID, but the
     * specific implementation details are left to the implementing subclass.
     */
    public String createID();

}
