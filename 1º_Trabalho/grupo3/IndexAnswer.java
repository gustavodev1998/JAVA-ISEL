package trab1.grupo3;

/*
* Defina o tipo de resposta IndexAnswer para aceitar apenas um valor inteiro com o índice da escolha verdadeira.
Lança InvalidFormatException caso a resposta não seja um valor inteiro. O valor do parâmetro passado no
construtor é a resposta correta. Note que o método estático parseInt de Integer pode lançar
NumberFormatException.
* */

public class IndexAnswer implements Answer{

    private final int indice;

    public  IndexAnswer(int idx) {
        this.indice = idx;
    }

    @Override
    public boolean check(String resp) throws InvalidFormatException {
        try {
            int a = Integer.parseInt(resp);

            if ( this.indice == a )  return true;

            return false;
        } catch ( NumberFormatException e) {
            throw new InvalidFormatException(resp,"não é um número");
        }

    }
}
