package boardgame;

//runtime exceção opcional a ser tratada
public class BoardException extends RuntimeException {

    public BoardException(String msg){
        super(msg);
    }
}
