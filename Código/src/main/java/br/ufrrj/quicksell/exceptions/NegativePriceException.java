package br.ufrrj.quicksell.exceptions;

public class NegativePriceException extends Exception{
    public NegativePriceException(String message) {
        super(
                message
        );
    }
}
