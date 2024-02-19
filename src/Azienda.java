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

    public double stipendioMedio() {
        double stipendioTotale = 0;
        for (Dipendente d : this.dipendenti) {
            stipendioTotale += d.getStipendioMensile();
        }

        return stipendioTotale / this.dipendenti.size();
    }

    public double nDipendenti() {
        return this.dipendenti.size();
    }

    public <T extends Dipendente> T piuAnziano () {
        T anziano = null;
        for (Dipendente d : this.dipendenti) {
            try {
                T tmp = (T) d;
                if(anziano == null || tmp.getDataAssunzione().getTime() > anziano.getDataAssunzione().getTime()) {
                    anziano = tmp;
                }
            }
            catch (ClassCastException ignored) {}

            return anziano;
        }
    }
}
