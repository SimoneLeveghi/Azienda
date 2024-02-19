import java.util.Date;

public abstract class Dipendente {
    private String nome;
    private double stipendioMensile;
    private int inquadramento;
    private Date dataAssunzione;

    public Dipendente(String nome, double stipendioMensile, int inquadramento, Date dataAssunzione) throws Exception {
        this.nome = nome;
        setStipendioMensile(stipendioMensile);


        this.dataAssunzione = new Date(dataAssunzione.getTime());
    }

    public String getNome() {
        return nome;
    }

    public double getStipendioMensile() {
        return stipendioMensile;
    }

    public int getInquadramento() {
        return inquadramento;
    }

    public Date getDataAssunzione() {
        return dataAssunzione;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStipendioMensile(double stipendioMensile) throws Exception {
        if(stipendioMensile <= 0) throw new Exception("Stipendio non valido");
        this.stipendioMensile = stipendioMensile;
    }
}
