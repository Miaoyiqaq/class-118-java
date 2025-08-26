package MyLinkedList;

public class IllegalIndexException extends RuntimeException{
    public IllegalIndexException(String message) {
        super(message);
    }
}
