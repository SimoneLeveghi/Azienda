import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Azienda {
    private String nome;
    private Date dataCreazione;
    private ArrayList<Dipendente> dipendenti;

    public Azienda(String nome, Date dataCreazione) {
        this.nome = nome;
        this.dataCreazione = new Date(dataCreazione.getTime());
        this.dipendenti = new ArrayList<Dipendente>();
    }

    public Azienda(String nome, Date dataCreazione, ArrayList<Dipendente> dipendenti) {
        this(nome, dataCreazione);

        this.dipendenti = new ArrayList<Dipendente>();
        for(int i = 0; i < dipendenti.size(); ++i) {
            this.dipendenti.add(dipendenti.get(i).clone());
        }
    }

    public Azienda(String nome, Date dataCreazione, Dipendente[] dipendenti) {
        this(nome, dataCreazione, (ArrayList<Dipendente>) Arrays.asList(dipendenti));
    }
}
