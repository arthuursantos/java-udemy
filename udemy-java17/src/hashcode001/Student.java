package hashcode001;

import java.util.Objects;

public class Student {

    protected int matricula;
    protected String nome;

    public Student(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return matricula == student.matricula && Objects.equals(nome, student.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, nome);
    }
}
