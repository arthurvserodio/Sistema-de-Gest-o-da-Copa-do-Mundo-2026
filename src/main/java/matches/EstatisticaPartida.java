package matches;

public class EstatisticaPartida {
    private EstatisticaTime estatisticaCasa;
    private EstatisticaTime estatisticaVisitante;

    public EstatisticaPartida(EstatisticaTime estatisticaCasa, EstatisticaTime estatisticaVisitante) {
        this.estatisticaCasa = estatisticaCasa;
        this.estatisticaVisitante = estatisticaVisitante;
    }
    public EstatisticaTime getEstatisticaCasa() {
        return estatisticaCasa;
    }
    public void setEstatisticaCasa(EstatisticaTime estatisticaCasa) {
        this.estatisticaCasa = estatisticaCasa;
    }

    public EstatisticaTime getEstatisticaVisitante() {
        return estatisticaVisitante;
    }
    public void setEstatisticaVisitante(EstatisticaTime estatisticaVisitante) {
        this.estatisticaVisitante = estatisticaVisitante;
    }
}
