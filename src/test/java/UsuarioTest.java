import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UsuarioTest {
    @Test
    public void deveNotificarUmUsuario() {
        Moeda moeda = new Moeda("dolar", 5);
        Usuario usuario = new Usuario("Usuario 1");
        usuario.observar(moeda);
        usuario.comprar(moeda);
        assertEquals("A moeda Moeda{nome=dolar', cotacao=6'} teve sua cotacao modificada.", usuario.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarUsuarios() {
        Moeda moeda = new Moeda("dolar", 5);
        Usuario usuario1 = new Usuario("Usuario 1");
        Usuario usuario2 = new Usuario("Usuario 1");
        usuario1.observar(moeda);
        usuario2.observar(moeda);
        usuario1.comprar(moeda);
        assertEquals("A moeda Moeda{nome=dolar', cotacao=6'} teve sua cotacao modificada.", usuario1.getUltimaNotificacao());
        assertEquals("A moeda Moeda{nome=dolar', cotacao=6'} teve sua cotacao modificada.", usuario2.getUltimaNotificacao());
    }

    @Test
    public void naoDeveNotificarUsuarios() {
        Moeda moeda = new Moeda("dolar", 5);
        Usuario usuario1 = new Usuario("Usuario 1");
        usuario1.observar(moeda);
        usuario1.comprar(moeda);
        assertNull(usuario1.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarUsuariosDolar() {
        Moeda dolar = new Moeda("dolar", 5);
        Moeda euro = new Moeda("euro", 5);
        Usuario usuario1 = new Usuario("Usuario 1");
        Usuario usuario2 = new Usuario("Usuario 2");
        usuario1.observar(dolar);
        usuario1.comprar(dolar);
        usuario2.comprar(euro);
        assertEquals("A moeda Moeda{nome=dolar', cotacao=6'} teve sua cotacao modificada.", usuario1.getUltimaNotificacao());
        assertNull(usuario2.getUltimaNotificacao());
    }
}
