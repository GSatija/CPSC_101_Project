package ca.unbc.cpsc.score4.exceptions;

public class PlayerException extends Exception{

    public PlayerException()                        { this("Unknown Player Exception");}


    public PlayerException(String s)                { super(s);}

    public PlayerException(Throwable t)             { super(t);}

    public PlayerException(String s, Throwable t)   { super(s,t);}

}
