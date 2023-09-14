package exemplos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EnviarMensagemTeste {

    @Spy
    private EnviarMensagem enviarMensagem;

    @Test
    void verificarComportamentoDaClasse(){
        Mockito.verifyNoInteractions(enviarMensagem);

        Mensagem mensagem = new Mensagem("Hello World");
        enviarMensagem.adicionarMensagem(mensagem);

        Mockito.verify(enviarMensagem).adicionarMensagem(mensagem);

        Assertions.assertFalse(enviarMensagem.getMensagens().isEmpty());
    }
}
