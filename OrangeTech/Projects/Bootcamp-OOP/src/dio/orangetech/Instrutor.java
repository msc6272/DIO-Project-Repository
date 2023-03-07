package dio.orangetech;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Instrutor extends Colaborador {
    private LocalDate dataInicioAtividade;
    private LocalDate dataFimAtividade;
    private Set<Skill> skills = new HashSet<>();
    
    public LocalDate getDataInicioAtividade() {
        return dataInicioAtividade;
    }

    public void setDataInicioAtividade(LocalDate dataInicioAtividade) {
        this.dataInicioAtividade = dataInicioAtividade;
    }

    public LocalDate getDataFimAtividade() {
        return dataFimAtividade;
    }

    public void setDataFimAtividade(LocalDate dataFimAtividade) {
        this.dataFimAtividade = dataFimAtividade;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
}
